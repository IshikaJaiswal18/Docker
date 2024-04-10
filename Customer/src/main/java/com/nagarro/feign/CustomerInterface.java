package com.nagarro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="AccountService")
public interface CustomerInterface {


	 @DeleteMapping("/accounts/customer/{customerId}")
	 public ResponseEntity<String> deleteAccountByCustomerId(@PathVariable Long customerId);

}
