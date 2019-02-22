package in.com.ezone.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.com.ezone.domain.Contact;
import in.com.ezone.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/user/contact_form")
	public String contactForm(Model model) {

		Contact contact = new Contact();

		model.addAttribute("command", contact);

		return "contact_form";

	}

	@RequestMapping(value = "/user/save_contact")
	public String saveOrUpdate(@ModelAttribute("command") Contact contact, Model model, HttpSession session) {

		Integer contactId = (Integer) session.getAttribute("aContactId");

		// save
		if (contactId == null) {

			try {
				Integer userId = (Integer) session.getAttribute("userId");
				contact.setUserId(userId);
				contactService.save(contact);
				return "redirect:clist?act=sv";
			} catch (Exception e) {

				e.printStackTrace();
				model.addAttribute("err", "Failed To save Contact");
				return "contact_form";
			}

		}

		// update
		else {

			try {

				contact.setContactId(contactId);
				contactService.update(contact);
				return "redirect:clist?act=sv";
			} catch (Exception e) {

				e.printStackTrace();
				model.addAttribute("err", "Failed To Edit Contact");
				return "contact_form";
			}

		}

	}

	@RequestMapping(value = "/user/clist")
	public String contactList(Model model, HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");

		model.addAttribute("contactList", contactService.findUserContact(userId));

		return "clist";

	}

	@RequestMapping(value = "/user/contact_search")
	public String contactSearch(Model model, HttpSession session, @RequestParam("freeText") String freeText) {

		Integer userId = (Integer) session.getAttribute("userId");

		model.addAttribute("contactList", contactService.findUserContact(userId, freeText));
		
		
		System.out.println("Hello");

		return "clist";

	}

	/*
	 * @RequestMapping(value = "/user/clist") public String contactList(Model model,
	 * HttpSession session) {
	 * 
	 * 
	 * Integer userId = (Integer) session.getAttribute("userId");
	 * model.addAttribute("contactList", contactService.contactList()); return
	 * "clist";
	 * 
	 * }
	 */

	@RequestMapping(value = "/user/del_contact")
	public String deleteContact(@RequestParam("cid") Integer contactId) {

		contactService.delete(contactId);

		return "redirect:clist?act=del";

	}

	@RequestMapping(value = "/user/edit_contact")
	public String prepareEditForm(Model model, HttpSession session, @RequestParam("cid") Integer contactId) {

		session.setAttribute("aContactId", contactId);

		Contact contact = contactService.findById(contactId);

		model.addAttribute("command", contact);

		return "contact_form";

	}
	
	
	
	@RequestMapping(value = "/user/bulk_cdelete")
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {

		contactService.delete(contactIds);

		return "redirect:clist?act=del";

	}

}
