package com.capg.pbms.transaction.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.springframework.format.annotation.DateTimeFormat;
    @Entity
	
	public class AccountManagement {
		@Id
		@Max(value=12)
		private String accountId;
		private String accountHolderId;
		private String accountBranchId;
		private String accountType;
		private String accountStatus;
		private double accountBalance;
		private double accountIntrest;
		@DateTimeFormat(pattern="yyyy/MM/dd")
		private LocalDate lastUpdated;
		public AccountManagement(String accountId, String accountHolderId, String accountBranchId, String accountType,
				String accountStatus, double accountBalance, double accountIntrest, LocalDate lastUpdated) {
			super();
			this.accountId = accountId;
			this.accountHolderId = accountHolderId;
			this.accountBranchId = accountBranchId;
			this.accountType = accountType;
			this.accountStatus = accountStatus;
			this.accountBalance = accountBalance;
			this.accountIntrest = accountIntrest;
			this.lastUpdated = lastUpdated;
		}
		public AccountManagement() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getAccountHolderId() {
			return accountHolderId;
		}
		public void setAccountHolderId(String accountHolderId) {
			this.accountHolderId = accountHolderId;
		}
		public String getAccountBranchId() {
			return accountBranchId;
		}
		public void setAccountBranchId(String accountBranchId) {
			this.accountBranchId = accountBranchId;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getAccountStatus() {
			return accountStatus;
		}
		public void setAccountStatus(String accountStatus) {
			this.accountStatus = accountStatus;
		}
		public double getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}
		public double getAccountIntrest() {
			return accountIntrest;
		}
		public void setAccountIntrest(double accountIntrest) {
			this.accountIntrest = accountIntrest;
		}
		public LocalDate getLastUpdated() {
			return lastUpdated;
		}
		public void setLastUpdated(LocalDate lastUpdated) {
			this.lastUpdated = lastUpdated;
		}
		
		
		
		 
}
