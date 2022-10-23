package com.eazy_bytes.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazy_bytes.project.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	
}