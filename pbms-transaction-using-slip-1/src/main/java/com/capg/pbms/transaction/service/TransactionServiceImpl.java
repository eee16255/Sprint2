package com.capg.pbms.transaction.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.capg.pbms.transaction.exception.AccountNotFoundException;
import com.capg.pbms.transaction.exception.InsufficientBalanceException;
import com.capg.pbms.transaction.exception.InvalidAmountException;
import com.capg.pbms.transaction.model.AccountManagement;

import com.capg.pbms.transaction.repo.TransactionRepository;
@Service
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	TransactionRepository  Repo;
	public List<AccountManagement> findAll()
	{
		return Repo.findAll();
	}
    
	public AccountManagement getOne(String accountId)
	{
        return Repo.getOne(accountId);
	}
	
	@Transactional
	public AccountManagement save(AccountManagement bean)
	{
		return Repo.save(bean);
	}
	
	@Transactional
	public boolean deleteById(String accountId)
	{
		  Repo.deleteById(accountId);
		return !Repo.existsById(accountId);
	}
	
	@Transactional
	public AccountManagement updateProduct(AccountManagement newAccount)
	{
		AccountManagement oldAccount=getOne(newAccount.getAccountId());
		oldAccount.setAccountId(newAccount.getAccountId());
		oldAccount.setAccountBalance(newAccount.getAccountBalance());
		Repo.save(oldAccount);
		return oldAccount;
	}

	@Override
	public double getAccountBalance(String accountId) {
		AccountManagement b=Repo.getOne(accountId);
		return (double) b.getAccountBalance();
	}

	@Override
	public AccountManagement deposit(String accountId, double amount) {
		if(!Repo.existsById(accountId)) {
			throw new AccountNotFoundException("no account found"); 
		}
		if(amount<100||amount>100000) {
			 throw new InvalidAmountException("invalid amount");
			 
		 }
		AccountManagement acc=Repo.getOne(accountId);
		acc.setAccountBalance(acc.getAccountBalance()+amount);
		return acc;
	}
	

	@Override
	public AccountManagement withdraw(String accountId, double amount) {
		if(!Repo.existsById(accountId)) {
			throw new AccountNotFoundException("no account found"); 
		}
		if(getAccountBalance(accountId)<amount) {
			throw new InsufficientBalanceException("insufficient balance");
		 }
	
		AccountManagement acc=Repo.getOne(accountId);
		acc.setAccountBalance(acc.getAccountBalance()-amount);
		return acc;
	}

	public AccountManagement CreditUsingSlip(String string, String accountId, double amount) {
		 if(amount<100||amount>100000) {
			 System.out.println("invalid amount");
		 }
	
		AccountManagement c = deposit( accountId, amount) ;
	System.out.println("Deposited "+amount+".rs Successfully "+"\n"+"Total amount "+getAccountBalance( accountId)+".Rs");
	 
	return c;
	}
	

	
	public AccountManagement DebitUsingSlip(String string, String accountId, double amount) {
		if(getAccountBalance(accountId)<amount) {
			System.out.println("invalid id");
		 }
	
		AccountManagement c=	withdraw(accountId, amount);
	System.out.println("withdrawn "+amount+".rs Successfully "+"\n"+"Total amount "+  getAccountBalance( accountId)+".Rs");
	
	 return c;
		
	}

	
	}

	


 
