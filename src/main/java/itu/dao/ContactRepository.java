package itu.dao;

import java.awt.List;

import org.springframework.data.jpa.repository.JpaRepository;

import itu.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Long>{
	
}
