package com.capg.pbms.accountmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.pbms.accountmanagement.model.Customer;
import com.capg.pbms.accountmanagement.model.LoanRequest;
import com.capg.pbms.accountmanagement.model.Transaction;
import com.capg.pbms.accountmanagement.service.IAccountManagementService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired(required=false)
	IAccountManagementService service;
	@PostMapping("/add")
	public ResponseEntity<Customer> addAccount(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(service.addAccount(customer),HttpStatus.CREATED);
	}
	@GetMapping("/id/{accountId}")
	public ResponseEntity<Customer> getAccount(@PathVariable("accountId") long accountId)
	{	
		return new ResponseEntity<Customer>(service.getAccount(accountId),HttpStatus.OK); 		
    }
	
	@PutMapping("/updateName/id/{accountId}")
	public ResponseEntity<Customer> updateCustomerName(@PathVariable("accountId") long accountId,@RequestBody Customer customer)
	{
	  return new ResponseEntity<Customer>(service.updateCustomerName(accountId,customer),HttpStatus.OK);
	}
	
	@PutMapping("/updateContact/id/{accountId}")
	public ResponseEntity<Customer> updateCustomerContact(@PathVariable("accountId") long accountId,@RequestBody Customer customer)
	{
	  return new ResponseEntity<Customer>(service.updateCustomerContact(accountId,customer),HttpStatus.OK);
	}
	
	@PutMapping("/updateAddress/id/{accountId}")
	public ResponseEntity<Customer> updateCustomerAddress(@PathVariable("accountId") long accountId,@RequestBody Customer customer)
	{
	  return new ResponseEntity<Customer>(service.updateCustomerAddress(accountId,customer),HttpStatus.OK);
	}
//	@PutMapping("/updateDetails/id/{accountId}")
//	public Customer updateDetails(@PathVariable("accountId") long accountId,@RequestBody Customer customer)
//	{
//		return service.updateDetails(accountId, customer);
//	  //return new ResponseEntity<Customer>(service.updateDetails(accountId,customer),HttpStatus.OK);
//	}
	@DeleteMapping("/delete/id/{accountId}")
    public boolean deleteAccount(@PathVariable("accountId") long accountId)
    {
		return service.deleteAccount(accountId);
    }
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllAccounts()
	{
		return new ResponseEntity<List<Customer>>(service.getAllAccounts(),HttpStatus.OK);
	}
	@PostMapping("/creditUsingCheque/id/{accountId}/amount/{amount}")
	public Transaction creditUsingCheque(@PathVariable("accountId") long accountId,@PathVariable("amount") double amount,@RequestBody Transaction transaction) {
		return service.creditUsingCheque(accountId, amount, transaction);
	}
	@PostMapping("/debitUsingCheque/id/{accountId}/amount/{amount}")
	public Transaction debitUsingCheque(@PathVariable("accountId") long accountId,@PathVariable("amount") double amount,@RequestBody Transaction transaction) {
		return service.debitUsingCheque(accountId, amount, transaction);
	}
	@PostMapping("/creditUsingSlip/id/{accountId}/amount/{amount}")
	public Transaction creditUsingSlip(@PathVariable("accountId") long accountId,@PathVariable("amount") double amount,@RequestBody Transaction transaction) {
		return service.creditUsingSlip(accountId, amount,transaction);
	}
	@PostMapping("/debitUsingSlip/id/{accountId}/amount/{amount}")
	public Transaction debitUsingSlip(@PathVariable("accountId") long accountId,@PathVariable("amount") double amount,@RequestBody Transaction transaction) {
		return service.debitUsingSlip(accountId, amount,transaction);
	}
	@GetMapping("/allTransactionsById/id/{accountId}")
	public List<Transaction> getTransactionById(@PathVariable("accountId") long accountId) {
		return service.getTransactionById(accountId);
	}
	@GetMapping("/getBalanceById/id/{id}")
	public double getBalanceById(@PathVariable("id") long accountId) {
		return service.getBalanceById(accountId);
	}
	@PostMapping("/requestLoan/id/{id}/creditScore/{creditScore}/amount/{amount}")
	public LoanRequest addLoan(@PathVariable("id") long accountId,@PathVariable("creditScore") int creditScore, @PathVariable("amount") double loanAmount,@RequestBody LoanRequest loanrequest) {
		return service.addLoan(accountId, creditScore, loanAmount, loanrequest);
	}
	@GetMapping("/printpassbook/id/{id}")
	public List<Transaction> printpassbook(@PathVariable("id") long accountId) {
		return service.printpassbook(accountId);
	}
		
	
}
	

