package itu.web;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import itu.dao.ContactRepository;
import itu.entities.Contact;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository  contactRepository;
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ArrayList<Contact> getContact()
	{
		return  (ArrayList<Contact>) contactRepository.findAll();
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id)
	{
		return contactRepository.findById(id);
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public Contact save (@RequestBody Contact c)
	{
		 return contactRepository.save(c);
	}
}
