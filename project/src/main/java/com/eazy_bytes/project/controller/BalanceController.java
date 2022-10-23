package com.eazy_bytes.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eazy_bytes.project.model.AccountTransactions;
import com.eazy_bytes.project.model.Customer;
import com.eazy_bytes.project.repo.AccountsTransactionRepo;

public class BalanceController {

	@Autowired
	private AccountsTransactionRepo accTransRepo;

	@PostMapping("/myBalance")
	public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
		List<AccountTransactions> accountTransactions = accTransRepo
				.findByCustomerIdOrderByTransactionDt(customer.getId());
		if (accountTransactions != null) {
			return accountTransactions;
		} else {
			return null;
		}
	}

}
