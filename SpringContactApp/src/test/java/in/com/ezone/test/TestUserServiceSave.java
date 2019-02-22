package in.com.ezone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.ezone.config.SpringRootConfig;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;
import in.com.ezone.service.UserService;

public class TestUserServiceSave {

	public static void main(String[] args) {

		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		UserService userService = cx.getBean(UserService.class);

		User user = new User();
		user.setName("priyanka");
		user.setPassword("p@123");
		user.setEmail("a@gmail.com");
		user.setAddress("Pune");
		user.setLoginName("priya");
		user.setPhone("8080808080");
		user.setRole(userService.ROLE_ADMIN);
		user.setLoginStatus(userService.Login_Status_ACTIVE);

		userService.register(user);

		System.out.println("----------- Data Saved-------------------");

	}

}
