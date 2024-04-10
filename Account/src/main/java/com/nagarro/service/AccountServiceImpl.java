package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagarro.dto.AccountDTO;
import com.nagarro.dto.CustomerEntity;
import com.nagarro.dto.TransactionRequest;
import com.nagarro.feign.AccountInterface;
import com.nagarro.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
 private final AccountRepository accountRepository;

 public AccountServiceImpl(AccountRepository accountRepository) {
     this.accountRepository = accountRepository;
 }
 @Autowired
  private AccountInterface accountInterface;

 @Override

 
@PostMapping("/create")
public void createAccount(@RequestBody AccountDTO request) {
  Long customerId = request.getCustomerId();
  AccountDTO account = new AccountDTO();
  account.setCustomerId(customerId);
  account.setBalance(request.getBalance());
  account.setAccountNumber(request.getAccountNumber());
  account.setIfsc_code(request.getIfsc_code());
  account.setBranchName(request.getBranchName());
  accountRepository.save(account);
}


 @Override
 public AccountDTO getAccountDetails(Long accountId) {
	
     AccountDTO acdt= accountRepository.findById(accountId).orElse(null);
     if(acdt!=null) {
    	// ResponseEntity<CustomerEntity> customerResponse=accountInterface.getSingleCustomer(acdt.getCustomerId()); 
//    	 
//    	 CustomerEntity customer= customerResponse.getBody();
//    	 acdt.setCustomer(customer);
//    	 return ResponseEntity.ok(acdt);
     return acdt;
	 
    
	 }
	return null;
	
     
 }


 @Override
 public AccountDTO addMoney(TransactionRequest request) {
     AccountDTO account = accountRepository.findByAccountIdAndAccountNumber(request.getAccountId(), request.getAccountNumber());
     
     if (account != null) {
    	 boolean isValidCustomer= validateCustomer(account.getCustomerId(),request.getCustomerName());
    	 if(isValidCustomer) {
         account.setBalance(account.getBalance() + request.getAmount());
         accountRepository.save(account);
         return account;
     }
    	 }
	return null;
 }

 @Override
 public AccountDTO withdrawMoney(TransactionRequest request) {
 AccountDTO account = accountRepository.findByAccountIdAndAccountNumber(request.getAccountId(), request.getAccountNumber());
     
     if (account != null) {
    	 boolean isValidCustomer= validateCustomer(account.getCustomerId(),request.getCustomerName());
    	 if(isValidCustomer) {
         account.setBalance(account.getBalance() - request.getAmount());
         accountRepository.save(account);
         return account;
     }
    	 }
	return null;
   
 }


 @Override
 public List<AccountDTO> getAllAccounts() {
     return accountRepository.findAll();
 }


@Override
public boolean validateCustomer(Long customerId, String customerName) {
	ResponseEntity<Boolean> responseEntity=accountInterface.validateCustomer(customerId, customerName);
	
	return responseEntity.getBody()!=null && responseEntity.getBody();
}

@Transactional
@Override
public ResponseEntity<String> deleteAccountByCustomerId(Long customerId) {
	 
	
		 
	     List<AccountDTO> linked_accounts= accountRepository.findByCustomerId(customerId);
	     if(!linked_accounts.isEmpty()) {
	    	 System.out.print("working");
	    	
	    		 for(AccountDTO account:linked_accounts) {
	    			 accountRepository.deleteById(account.getAccountId());
	    		 }
	    		 return ResponseEntity.ok("Account deleted successfully");
	    	 
	    	 
	     }
		return null;
	 }

 
}
