package com.eazy_bytes.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.model.Loans;
import com.eazy_bytes.project.repo.LoanRepository;

@RestController
public class LoanController {

	@Autowired
	private LoanRepository loanRepository;

	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
		if (loans != null)
			return loans;
		else
			return null;
	}
}
