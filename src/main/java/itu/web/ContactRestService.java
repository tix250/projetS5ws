package itu.web;

import java.awt.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.dao.ContactRepository;
import itu.dao.MikaInterface;
import itu.entities.Contact;
import itu.entities.Signalement;
import itu.entities.TypeSignalement;
import itu.entities.UserBackoffice;
import itu.entities.UtilisateurFO;
import itu.entities.UtilisateurMobile;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository  contactRepository;
	

	
	@Autowired
	private MikaInterface  mika;
	
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ArrayList<Contact> getContact()
	{
		return  (ArrayList<Contact>) contactRepository.findAll();
	}
	
	@RequestMapping(value="/listSignalement",method=RequestMethod.GET)
	public List listSignalement()
	{
		return  (List) mika.listSignalement();
	}

	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id)
	{
		return contactRepository.findById(id);
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public int login (@RequestBody String user ,@RequestBody String mdp )
	{
		return mika.connexion(user, mdp);
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void inscription (@RequestBody UserBackoffice user)
	{
		mika.insertUserBackoffice(user);
		
	}
	
	@RequestMapping(value="/recherche",method=RequestMethod.POST)
	public List rechercher (@RequestBody int type , @RequestBody Date date , @RequestBody int statut  )
	{
		
		List signalement = (List) mika.recherche(type, date, statut);
		return signalement;
	}
	
	@RequestMapping(value="/insertUserFo",method=RequestMethod.POST)
	public void insertUtilisateurFO (@RequestBody UtilisateurFO user)
	{
		mika.insertUtilisateurFO(user);
		
	}
	
	@RequestMapping(value="/updateSugnialement",method=RequestMethod.POST)
	public void updateTypeSignalement (@RequestBody TypeSignalement type)
	{
		mika.updateTypeSignalement(type);
		
	}
	
	@RequestMapping(value="/affecterSignalement",method=RequestMethod.POST)
	public void affecterSignalement (@RequestBody  Signalement s)
	{
		mika.affecterSignalement(s);
		
	}
	
	@RequestMapping(value="/insertUserTypeSignialement",method=RequestMethod.POST)
	public void insertUtilisateurFO (@RequestBody TypeSignalement type)
	{
		mika.inserTypeSignalement(type);
		
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.DELETE)
	public boolean delete (@RequestBody Contact c)
	{
		  contactRepository.delete(c);
		  return true;
	}
	
	@RequestMapping(value="/deleteUserMobile",method=RequestMethod.DELETE)
	public boolean deleteUserMobile (@RequestBody UtilisateurMobile user)
	{
		  mika.deleteUtilisateurMobile(user);
		  return true;
	}
	
	@RequestMapping(value="/deleteTypeSignalement",method=RequestMethod.DELETE)
	public boolean deleteTypeSignalement (@RequestBody TypeSignalement type)
	{
		  mika.deleteTypeSignalement(type);
		  return true;
	}
	
	@RequestMapping(value="/contact/{id}",method=RequestMethod.PUT)
	public boolean update (@PathVariable Long id , @RequestBody Contact c)
	{
		  c.setId(id);
		  contactRepository.save(c);
		  return true;
	}
	
	
	
	
	
	
}
