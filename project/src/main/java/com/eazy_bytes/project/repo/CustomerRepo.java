package com.eazy_bytes.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazy_bytes.project.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	List<Customer> findByEmail(String email);
}
