package com.nagarro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nagarro.dao.CustomerEntity;


public interface CustomerService {
	CustomerEntity create(CustomerEntity customer);
	
	CustomerEntity getSingleCustomer(Long id);
	List<CustomerEntity> getAllCustomers();
	CustomerEntity update(CustomerEntity customer, Long id);
	//CustomerEntity delete(CustomerEntity customer);

	ResponseEntity<Boolean> validate(Long customerId, String customerName);
	ResponseEntity<String> deleteCustomer(Long customerId);

}
