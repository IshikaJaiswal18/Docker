package com.nagarro.repository;

import java.util.List;

//AccountRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.dto.AccountDTO;

public interface AccountRepository extends JpaRepository<AccountDTO, Long> {
 // Additional custom queries can be added if needed
	AccountDTO findByAccountIdAndAccountNumber(Long accountId, Long accountNumber);
	List<AccountDTO> findByCustomerId(Long customerId);
}

