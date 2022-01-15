package itu.web;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
}
