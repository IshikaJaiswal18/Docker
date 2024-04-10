package com.nagarro.dto;

public class CustomerAccountDetail {
 private AccountDTO accountDTO;
 private CustomerEntity customerEntity;
public AccountDTO getAccountDTO() {
	return accountDTO;
}
public void setAccountDTO(AccountDTO accountDTO) {
	this.accountDTO = accountDTO;
}
public CustomerEntity getCustomerEntity() {
	return customerEntity;
}
public void setCustomerEntity(CustomerEntity customerEntity) {
	this.customerEntity = customerEntity;
}
public CustomerAccountDetail(AccountDTO accountDTO, CustomerEntity customerEntity) {
	super();
	this.accountDTO = accountDTO;
	this.customerEntity = customerEntity;
}
public CustomerAccountDetail() {
	
}
 
 
}
