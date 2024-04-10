package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.dao.CustomerEntity;
import com.nagarro.feign.CustomerInterface;
import com.nagarro.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerInterface customerInterface;
	
	@PostMapping
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
		
		CustomerEntity customerObtained = customerService.create(customer);
		return ResponseEntity.ok(customerObtained);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getSingleCustomer(@PathVariable Long id) {
		
		CustomerEntity customerObtained = customerService.getSingleCustomer(id);
		return ResponseEntity.ok(customerObtained);
		
	}
	@GetMapping("/all")
	public ResponseEntity <List<CustomerEntity>> getAllCustomer() {
		
		List<CustomerEntity> customerObtained = customerService.getAllCustomers();
		return ResponseEntity.ok(customerObtained);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerEntity customer,@PathVariable Long id) {
		
		CustomerEntity customerObtained = customerService.update(customer,id);
		return ResponseEntity.ok(customerObtained);
		
	}

	  @GetMapping("/validate/{customerId}/{customerName}")
	    public ResponseEntity<Boolean> validateCustomer(@PathVariable Long customerId, @PathVariable String customerName) {
	        ResponseEntity<Boolean> isValid = customerService.validate(customerId, customerName);
	        return isValid;
	    }
	  @DeleteMapping("/{customerId}")
	  public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
	      customerService.deleteCustomer(customerId);
	      customerInterface.deleteAccountByCustomerId(customerId);
	      return  ResponseEntity.ok("Accounts associated with customer deleted successfully!");
	  }

}