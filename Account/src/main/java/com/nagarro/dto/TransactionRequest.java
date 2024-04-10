package com.nagarro.dto;
public class TransactionRequest {

    private Long accountId;

    private String customerName;

    private Long accountNumber;

    private double amount;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public TransactionRequest(Long accountId, String customerName, Long accountNumber, double amount) {
		super();
		this.accountId = accountId;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}