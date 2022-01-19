package itu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import itu.entities.Contact;
import itu.entities.UserBackoffice;

public interface UserrRepository extends JpaRepository<UserBackoffice, Integer> {

}
