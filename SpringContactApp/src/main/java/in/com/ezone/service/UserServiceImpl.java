package in.com.ezone.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import in.com.ezone.dao.BaseDAO;
import in.com.ezone.dao.UserDAO;
import in.com.ezone.domain.User;
import in.com.ezone.exception.UserBlockedException;
import in.com.ezone.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;

	public void register(User user) {

		userDAO.save(user);
	}

	public User login(String loginName, String password) throws UserBlockedException {

		String sql = "SELECT userId,name,phone,email,address,role,loginStatus,loginName from user where loginName=:ln AND password=:pw";

		Map hashMap = new HashMap();

		hashMap.put("ln", loginName);
		hashMap.put("pw", password);

		try {

			User user = super.getNamedParameterJdbcTemplate().queryForObject(sql, hashMap, new UserRowMapper());

			if (user.getLoginStatus().equals(UserService.Login_Status_BLOCKED)) {

				throw new UserBlockedException("Your Account Has Been Blocked!!! Contact to Admin");

			}

			else {

				return user;

			}

		} catch (EmptyResultDataAccessException ex) {

			return null;

		}

	}

	public List<User> getUserList() {

		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	public void changeLoginStatus(Integer userId, Integer status) {

		String sql = "update user set loginStatus=:lst where userId=:uid";

		Map hashMap = new HashMap();

		hashMap.put("uid", userId);
		hashMap.put("lst", status);

		getNamedParameterJdbcTemplate().update(sql, hashMap);
	}

	public Boolean isUsernameExit(String username) {

		String sql = "select count(loginName) from user where loginName=?";

		Integer count = getJdbcTemplate().queryForObject(sql, new String[] { username }, Integer.class);

		if (count == 1) {

			return true;
		} else {

			return false;
		}

	}

}
