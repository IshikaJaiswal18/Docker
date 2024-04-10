package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.Repository.CustomerRepo;
import com.nagarro.dao.CustomerEntity;
import com.nagarro.feign.CustomerInterface;

import jakarta.transaction.Transactional;
@Service
public class CustomerServiceImpl implements CustomerService {
	 @Autowired
	 private CustomerRepo customerRepo;
	 
	 CustomerInterface customerInterface;

	@Override
	public CustomerEntity create(CustomerEntity customer) {
	
		
		
		return customerRepo.save(customer);
	}

	@Override
	public CustomerEntity getSingleCustomer(Long id) {
	CustomerEntity customer=customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer Not Found"));
		return customer;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	

	@Override
	public CustomerEntity update(CustomerEntity customer, Long id) {
		CustomerEntity customer2=customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer Not Found"));
		customer2.setCustomerEmail(customer.getCustomerEmail());
		customer2.setMobileNo(customer.getMobileNo());
		customer2.setCustomerName(customer.getCustomerName());
		customer2.setDob(customer.getDob());
		
		
		return customerRepo.save(customer2);
	}
	
	 @Override
	    public ResponseEntity<Boolean> validate(Long customerId, String customerName) {
	        Optional<CustomerEntity> optionalCustomer = customerRepo.findById(customerId);

	        if (optionalCustomer.isPresent()) {
	            CustomerEntity customer = optionalCustomer.get();
	            return ResponseEntity.ok(customer.getCustomerName().equals(customerName));
	        }

	        return ResponseEntity.badRequest().body(false);
	    }
	 @Override
	 @Transactional
	 public ResponseEntity<String> deleteCustomer(Long customerId) {
		    Optional<CustomerEntity> optionalCustomer = customerRepo.findById(customerId);

		    if (optionalCustomer.isPresent()) {
		        // Delete customer
		        customerRepo.deleteById(customerId);
		        //customerInterface.deleteAccountByCustomerId(customerId);
		    }
//		        try {
//		            // Attempt to delete associated accounts
//		            ResponseEntity<String> accountDeleteResponse = customerInterface.deleteAccountByCustomerId(customerId);
//		            return ResponseEntity.ok("Customer deleted successfully");
//		        } catch (Exception ex) {
//		            // Handle case where no accounts were found for the customer
//		            return ResponseEntity.ok("Customer deleted successfully. No accounts found for customer.");
//		        } 
			return ResponseEntity.ok("Customer deleted successfully");
		}

	   

	}


