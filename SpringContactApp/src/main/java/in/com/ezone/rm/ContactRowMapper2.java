package in.com.ezone.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.com.ezone.domain.Contact;
import in.com.ezone.domain.User;

public class ContactRowMapper2 implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int i) throws SQLException {

		Contact c = new Contact();
		c.setContactId(rs.getInt("contactId"));
		c.setUserId(rs.getInt("userId"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setPhone(rs.getString("phone"));
		c.setRemark(rs.getString("remark"));
		return c;
	}

}
