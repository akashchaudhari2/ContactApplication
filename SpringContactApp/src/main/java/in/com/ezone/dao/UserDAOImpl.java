package in.com.ezone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import in.com.ezone.domain.User;
import in.com.ezone.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User u) {

		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ "VALUES (:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map hashMap = new HashMap();
		hashMap.put("name", u.getName());
		hashMap.put("phone", u.getPhone());
		hashMap.put("email", u.getEmail());
		hashMap.put("address", u.getAddress());
		hashMap.put("loginName", u.getLoginName());
		hashMap.put("password", u.getPassword());
		hashMap.put("role", u.getRole());
		hashMap.put("loginStatus", u.getLoginStatus());

		GeneratedKeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(hashMap);

		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);

	}

	public void update(User u) {

		String sql = "UPDATE user SET name=:name, phone=:phone, email=:email, address=:address,role=:role,loginStatus=:loginStatus WHERE userId=:userId";

		Map hashMap = new HashMap();
		hashMap.put("name", u.getName());
		hashMap.put("phone", u.getPhone());
		hashMap.put("email", u.getEmail());
		hashMap.put("address", u.getAddress());
		hashMap.put("role", u.getRole());
		hashMap.put("loginStatus", u.getLoginStatus());

		hashMap.put("userId", u.getUserId());

		getNamedParameterJdbcTemplate().update(sql, hashMap);
	}

	public void delete(User u) {

		
		this.delete(u.getUserId());
	}

	public void delete(Integer userId) {

		String sql = "Delete from user where userId=?";
		getJdbcTemplate().update(sql, userId);

	}

	public User findById(Integer userId) {

		String sql="select userId, name, phone, email, address, loginName, password, role, loginStatus from user where userId=?" ;
		
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		
		return user;
	}

	public List<User> findAll() {
	String sql="select userId, name, phone, email, address, loginName, password, role, loginStatus from user" ;
		
		/*List<User> users = getJdbcTemplate().query(sql, new UserRowMapper(),userId);*/
		
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object propValue) {
		
		
		String sql="select * from user where role=?";
		
		
		
		return getJdbcTemplate().query(sql, new UserRowMapper(),propValue);
	}

}
