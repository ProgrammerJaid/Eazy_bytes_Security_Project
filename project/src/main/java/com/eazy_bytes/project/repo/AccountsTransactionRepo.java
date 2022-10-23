package com.eazy_bytes.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eazy_bytes.project.model.AccountTransactions;

@Repository
public interface AccountsTransactionRepo extends JpaRepository<AccountTransactions, Long> {

	List<AccountTransactions> findByCustomerIdOrderByTransactionDt(int customerId);
	
}
