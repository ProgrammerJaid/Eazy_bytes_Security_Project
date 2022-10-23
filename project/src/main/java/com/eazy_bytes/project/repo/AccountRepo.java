package com.eazy_bytes.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazy_bytes.project.model.Accounts;

@Repository
public interface AccountRepo extends JpaRepository<Accounts, Long> {

	Accounts findByCustomerId(int custId);
	
}
