package com.nagarro.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//AccountController.java
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dto.AccountDTO;
import com.nagarro.dto.CustomerAccountDetail;
import com.nagarro.dto.CustomerEntity;
import com.nagarro.dto.TransactionRequest;
import com.nagarro.feign.AccountInterface;
import com.nagarro.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
 private final AccountService accountService;
 @Autowired
 private AccountInterface accountInterface;

 public AccountController(AccountService accountService) {
     this.accountService = accountService;
 }

 @PostMapping("/create")
 public void createAccount(@RequestBody AccountDTO actdt) {
     accountService.createAccount(actdt);
 }

 @GetMapping("/details/{accountId}")
 public ResponseEntity<CustomerAccountDetail> getAccountDetails(@PathVariable Long accountId) {
	 
      AccountDTO ac=accountService.getAccountDetails(accountId);
      
      CustomerEntity customer=accountInterface.getSingleCustomer(ac.getCustomerId());
      CustomerAccountDetail customerAccountDetail=new CustomerAccountDetail();
      customerAccountDetail.setAccountDTO(ac);
      customerAccountDetail.setCustomerEntity(customer);
      return ResponseEntity.ok(customerAccountDetail);
 }

 
 @PutMapping("/add-money")
 public ResponseEntity<AccountDTO> addMoney(@RequestBody TransactionRequest request) {
     AccountDTO updatedAccount = accountService.addMoney(request);
     if (updatedAccount != null) {
         return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or any other appropriate status
     }
 }

 @PutMapping("/withdraw-money/{accountId}")
 public ResponseEntity<AccountDTO> withdrawMoney(@RequestBody TransactionRequest request) {
     AccountDTO updatedAccount = accountService.withdrawMoney(request);
     if (updatedAccount != null) {
         return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND); // or any other appropriate status
     }
 }

 @DeleteMapping("/customer/{customerId}")
 public ResponseEntity<String> deleteAccountByCustomerId(@PathVariable Long customerId) {
    return accountService.deleteAccountByCustomerId(customerId);
 }
}
