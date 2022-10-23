package com.eazy_bytes.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazy_bytes.project.model.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}