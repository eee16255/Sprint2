package com.capg.pbms.transaction.service;

import com.capg.pbms.transaction.model.AccountManagement;

public interface ITransactionService {
  
	
	public AccountManagement CreditUsingSlip(String string, String accountId,double amount);
	
	public AccountManagement DebitUsingSlip(String string, String accountId,double amount);
	
	public double getAccountBalance(String accountId);

	public AccountManagement deposit(String accountId, double amount) ;

	public AccountManagement withdraw(String accountId, double amount);
}
