package in.com.ezone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.ezone.dao.BaseDAO;
import in.com.ezone.dao.ContactDAO;
import in.com.ezone.domain.Contact;
import in.com.ezone.rm.ContactRowMapper2;
import in.com.ezone.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public void save(Contact contact) {

		contactDAO.save(contact);

	}

	public void update(Contact contact) {

		contactDAO.update(contact);

	}

	public void delete(Integer contactId) {

		contactDAO.delete(contactId);

	}

	public void delete(Integer[] contactIds) {

		String ids = StringUtil.toCommaSeparatedString(contactIds);

		String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";

		getJdbcTemplate().update(sql);

	}

	public List<Contact> findUserContact(Integer userId) {

		return contactDAO.findByProperty("userId", userId);

	}

	public List<Contact> findUserContact(Integer userId, String txt) {

/*		String sql = "select contactId,userId, name, phone, email, address, remark from contact WHERE userId=? AND (name LIKE '% "+ txt + "%' OR address LIKE '% " + txt + "%' OR phone LIKE '% " + txt + "%' OR email LIKE '% " + txt+ "%' remark LIKE '% " + txt + "%')";*/
		String sql = "select * from contact WHERE userId=? AND (name LIKE '% "+ txt + "%' OR address LIKE '% " + txt + "%' OR phone LIKE '% " + txt + "%' OR email LIKE '% " + txt+ "%' OR remark LIKE '% " + txt + "%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper2(), userId);
	}

	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
		return contactDAO.findById(contactId);
	}

	/*
	 * public List<Contact> contactList() {
	 * 
	 * return contactDAO.contactList(); }
	 */
}
