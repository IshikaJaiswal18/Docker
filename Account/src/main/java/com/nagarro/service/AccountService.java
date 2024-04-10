package com.nagarro.service;

//AccountService.java
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.dto.AccountDTO;
import com.nagarro.dto.TransactionRequest;

public interface AccountService {
 
	void createAccount(AccountDTO account);
 AccountDTO getAccountDetails(Long accountId);
 boolean validateCustomer(Long customerId, String customerName);


 //AccountDTO addMoney(Long accountId, double amount);

 //AccountDTO withdrawMoney(Long accountId, double amount);

 //void deleteAccount(Long accountId);

 List<AccountDTO> getAllAccounts(); // Optionally, if you need to retrieve all accounts
AccountDTO addMoney(TransactionRequest request);
ResponseEntity<String> deleteAccountByCustomerId(Long customerId);
AccountDTO withdrawMoney(TransactionRequest request);

}

