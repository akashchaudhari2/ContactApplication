package in.com.ezone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.ezone.config.SpringRootConfig;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {

		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		UserDAO userDAO = cx.getBean(UserDAO.class);

		User user = new User();
		user.setName("Lata");
		user.setPhone("1112121212");

		user.setEmail("ltaa@gmail.com");
		user.setAddress("Pune");

		user.setRole(1);
		user.setLoginStatus(1);
		user.setUserId(8);

		userDAO.update(user);

		System.out.println("----------- Data Updated----------");

	}

}
