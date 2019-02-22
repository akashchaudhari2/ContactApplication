package in.com.ezone.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.com.ezone.domain.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int i) throws SQLException {

		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setLoginName(rs.getString("loginName"));
		user.setRole(rs.getInt("role"));
		user.setLoginStatus(rs.getInt("loginStatus"));
		return user;
	}

}
