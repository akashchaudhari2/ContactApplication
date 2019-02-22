package in.com.ezone.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.ezone.config.SpringRootConfig;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {

		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		UserDAO userDAO = cx.getBean(UserDAO.class);
		
		
		

	/*	List<User> users = userDAO.findByProperty("userId", 1);*/
		/*List<User> users = userDAO.findByProperty("user", "akash");*/
		List<User> users = userDAO.findByProperty("role", 2);

		System.out.println("----------- Retrived------------");

	for (User user : users) {
		
		
		
		System.out.println(user.getUserId());
		System.out.println(user.getName());
		System.out.println(user.getPhone());
		System.out.println(user.getEmail());
		System.out.println(user.getAddress());
		System.out.println(user.getLoginName());
		System.out.println(user.getLoginStatus());
		System.out.println(user.getRole());
	}
	}
}
