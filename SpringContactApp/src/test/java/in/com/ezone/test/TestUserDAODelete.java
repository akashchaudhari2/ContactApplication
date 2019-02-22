package in.com.ezone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.ezone.config.SpringRootConfig;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;

public class TestUserDAODelete {

	public static void main(String[] args) {

		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);

		UserDAO userDAO = cx.getBean(UserDAO.class);

		userDAO.delete(9);

		System.out.println("----------- Data Deleted");

	}

}
