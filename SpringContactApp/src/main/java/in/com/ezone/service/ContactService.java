package in.com.ezone.service;

import java.util.List;

import in.com.ezone.domain.Contact;

public interface ContactService {

	
	
	
	public void save(Contact contact);
	public void update(Contact contact);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	public List<Contact> findUserContact(Integer userId);
	

	
	public List<Contact> findUserContact(Integer userId,String txt);
	
	public Contact findById(Integer contactId);
	
/*	public List<Contact> contactList();*/
}
