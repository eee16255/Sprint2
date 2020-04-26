package com.capg.pbms.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.pbms.transaction.model.AccountManagement;

import com.capg.pbms.transaction.service.TransactionServiceImpl;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionServiceImpl  service;
	
	@GetMapping("/all")
	public List<AccountManagement>  findAll()
	{
		  return service.findAll();
	}

	@GetMapping("/account/id/{accountId}")
	public AccountManagement getOne(@PathVariable String accountId) 
	{
		  return service.getOne(accountId);
	}
	
	
	@PostMapping("/add")
	public AccountManagement  save(@RequestBody AccountManagement bean)
	{
		return  service.save(bean);
	}
	
	@DeleteMapping("/account/id/{accountId}")
	public boolean  deleteById(@PathVariable String accountId)
	{
		return  service.deleteById(accountId);
	}

	@PutMapping("/account")
	public AccountManagement  updateProduct(@RequestBody AccountManagement bean)
	{
		return  service.updateProduct(bean);
	}
	
	@GetMapping("/account/deposit/{accountId}/{amount}")  
	public String deposit(@PathVariable String accountId, @PathVariable double amount) throws Exception {
		AccountManagement b = service.deposit(accountId, amount);

		if (b == null) {
			throw new Exception("Invalid id");
		}
		return "Hello " + "xyz" + "\n Your Amount is Deposited Succesfully\n"
				+ "Your Current Account Balance is " + b.getAccountBalance();
		
	}

    @GetMapping("/account/withdraw/{accountId}/{amount}") 
public String withdraw(@PathVariable String accountId, @PathVariable double amount) throws Exception {
	AccountManagement b = service.withdraw(accountId, amount);

	if (b == null) {
		throw new Exception("Invalid id");
	}
	return "Hello " + "xyz" + "\n Your Amount is Withdrawn Succesfully\n"
	+ "Your Current Account Balance is " +  b.getAccountBalance();
	
    }
}

		
