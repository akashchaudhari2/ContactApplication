package in.com.ezone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.com.ezone.domain.Contact;
import in.com.ezone.domain.User;
import in.com.ezone.rm.ContactRowMapper2;
import in.com.ezone.rm.UserRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public void save(Contact c) {

		String sql = "INSERT INTO contact(userId, name,phone, email, address, remark)"
				+ "VALUES (:userId, :name,:phone, :email, :address, :remark)";
		Map hashMap = new HashMap();
		hashMap.put("userId", c.getUserId());
		hashMap.put("name", c.getName());

		hashMap.put("phone", c.getPhone());
		hashMap.put("email", c.getEmail());
		hashMap.put("address", c.getAddress());
		hashMap.put("remark", c.getRemark());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(hashMap);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);

		c.setContactId(kh.getKey().intValue());

	}

	public void update(Contact c) {

		String sql = "UPDATE contact SET name=:name, phone=:phone, email=:email, address=:address,remark=:remark WHERE contactId=:contactId";

		Map hashMap = new HashMap();
		hashMap.put("contactId", c.getContactId());
		hashMap.put("name", c.getName());
		hashMap.put("phone", c.getPhone());
		hashMap.put("email", c.getEmail());
		hashMap.put("address", c.getAddress());
		hashMap.put("remark", c.getRemark());

		getNamedParameterJdbcTemplate().update(sql, hashMap);

	}

	public void delete(Contact c) {

		this.delete(c.getContactId());

	}

	public void delete(Integer contactId) {

		String sql = "Delete from contact where contactId=?";
		getJdbcTemplate().update(sql, contactId);

	}

	public Contact findById(Integer contactId) {
		String sql = "select contactId,userId, name, phone, email, address,remark from contact where contactId=?";

		Contact contact = getJdbcTemplate().queryForObject(sql, new ContactRowMapper2(), contactId);

		return contact;
	}

	public List<Contact> findAll() {
		String sql = "select contactId,userId, name, phone, email, address, remark from contact";

		/*
		 * List<User> users = getJdbcTemplate().query(sql, new UserRowMapper(),userId);
		 */

		return getJdbcTemplate().query(sql, new ContactRowMapper2());
	}

	public List<Contact> findByProperty(String propName, int propValue) {

/*		String sql = "SELECT contactId,userId, name, phone, email, address, remark from contact WHERE name=?" + propName
				+ "=?";*/
		
		String sql = "SELECT contactId,userId, name, phone, email, address, remark from contact WHERE userId=?";
		
		
	/*	String sql = "SELECT contactId,userId, name, phone, email, address, remark from contact WHERE="+propName;*/
	/*	String sql1="select * from contact where name=?";*/

		return getJdbcTemplate().query(sql, new ContactRowMapper2(), propValue);
	}

/*	public List<Contact> contactList() {
		String sql1="select * from contact where name=?";

		return getJdbcTemplate().query(sql1, new ContactRowMapper2());
	}*/

}
