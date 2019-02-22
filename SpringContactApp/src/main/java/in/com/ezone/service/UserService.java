package in.com.ezone.service;

import java.util.List;

import in.com.ezone.domain.User;
import in.com.ezone.exception.UserBlockedException;

public interface UserService {
	
	
	
	public static final Integer Login_Status_ACTIVE=1;
	public static final Integer Login_Status_BLOCKED=2;
	
	
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	public void register(User user);
	
	public User login(String loginName,String password) throws UserBlockedException;

	
	public List<User> getUserList();
	
	
	public void changeLoginStatus(Integer userId,Integer status);
	
	public Boolean isUsernameExit(String username);
	
}
