package in.com.ezone.dao;

import java.util.List;

import in.com.ezone.domain.Contact;


public interface ContactDAO {

	
	public void save(Contact c);

	public void update(Contact c);

	public void delete(Contact c);

	public void delete(Integer contactId);

	public Contact findById(Integer contactId);

	public List<Contact> findAll();
	
	public List<Contact> findByProperty(String propName,int propValue);
	
	/*public List<Contact> contactList();*/
}
