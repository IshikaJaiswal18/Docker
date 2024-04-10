package com.nagarro.dao;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "customer")
public class CustomerEntity {

	


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "customer_id")
		private Long customerId;
	 
		@Column(name = "customer_name")
		private String customerName;
		
		@Column(name = "customer_email")
		private String customerEmail;
	 
		@Column(name = "mobile_no")
		private Long mobileNo;
	 
		@Column(name = "dob")
		@Temporal(TemporalType.DATE)
		private Date dob;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public Long getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(Long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}
		
		
		
		
		
	 
	}
	

