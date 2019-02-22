package in.com.ezone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.com.ezone.command.LoginCommand;
import in.com.ezone.command.UserCommand;
import in.com.ezone.domain.User;
import in.com.ezone.exception.UserBlockedException;
import in.com.ezone.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String index(Model model) {

		model.addAttribute("command", new LoginCommand());

		return "index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand command, Model model, HttpSession httpSession) {

		try {
			User login = userService.login(command.getLoginName(), command.getPassword());

			if (login == null) {

				model.addAttribute("err", "Login Failed!!!! Enter Valid Credentials");

				return "index";

			}

			else {

				if (login.getRole().equals(userService.ROLE_ADMIN)) {

					addUserInSession(login, httpSession);

					return "redirect:admin/dashboard";

				}

				else {

					if (login.getRole().equals(userService.ROLE_USER)) {

						addUserInSession(login, httpSession);

						return "redirect:user/dashboard";

					}

					else {

						model.addAttribute("err", "Invalid User Role!!!! Enter Valid Credentials");

						return "index";

					}

				}

			}

		} catch (UserBlockedException e) {

			model.addAttribute("err", e.getMessage());

			return "index";

		}

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession httpSession) {

		httpSession.invalidate();
		return "redirect:index?act=lo";

	}

	@RequestMapping(value = { "/user/dashboard" })
	public String userDashboard() {

		return "dashboard_user";

	}

	@RequestMapping(value = { "/admin/dashboard" })
	public String adminDashboard() {

		return "dashboard_admin";

	}

	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model model) {

		UserCommand userCommand = new UserCommand();

		model.addAttribute("command", userCommand);

		return "reg_form";

	}

	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand userCommand, Model model) {

		try {
			User user = userCommand.getUser();
			user.setRole(userService.ROLE_USER);
			user.setLoginStatus(userService.Login_Status_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";
		} catch (DuplicateKeyException e) {

			e.printStackTrace();

			model.addAttribute("err", "Username is already present.Please select another Username ");

			return "reg_form";

		}

	}

	private void addUserInSession(User user, HttpSession httpSession) {

		httpSession.setAttribute("user", user);
		httpSession.setAttribute("userId", user.getUserId());
		httpSession.setAttribute("role", user.getRole());

	}

	@RequestMapping(value = { "/admin/users" })
	public String getUserList(Model model) {

		model.addAttribute("userList", userService.getUserList());
		return "users";

	}

	@RequestMapping(value = "/admin/change_status")
	@ResponseBody
	public String registrationForm(@RequestParam Integer userId, @RequestParam Integer loginStatus) {

		try {
			userService.changeLoginStatus(userId, loginStatus);

			return "SUCCESS:status changed";

		} catch (Exception e) {
			e.printStackTrace();

			return "ERROR: Unable to  change status";
		}

	}

	@RequestMapping(value = "/check_avail")
	@ResponseBody
	public String checkAvailibility(@RequestParam String username) {

		if (userService.isUsernameExit(username)) {

			return "This Username is Already Taken. Please Choose Another One";
		} else {
			
			return "Yes You can take this";

		}

	}

}
