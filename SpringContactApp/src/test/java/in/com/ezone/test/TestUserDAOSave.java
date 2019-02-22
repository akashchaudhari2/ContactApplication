package in.com.ezone.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.ezone.config.SpringRootConfig;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		
		
		
		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		UserDAO userDAO = cx.getBean(UserDAO.class);
		
		
		User user = new User();
		user.setName("akash");
		user.setPassword("Akash@123");
		user.setEmail("a@gmail.com");
		user.setAddress("Pune");
		user.setLoginName("akash");
		user.setPhone("1121212121");
		user.setRole(1);
		user.setLoginStatus(1);
		
		
		userDAO.save(user);
		
		System.out.println("----------- Data Saved");
		
	
	}
	
}
