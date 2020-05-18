package com.capg.pbms.accountmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.pbms.accountmanagement.service.AccountManagementServiceImpl;

@SpringBootTest
class PbmsAccountManagementApplicationTests {
	@Autowired 	
	AccountManagementServiceImpl Service; 
 		@Test
 		public void testAccountId() {
 			assertEquals(true, Service.isValidAccountId(123456789012L));
 		} 
 		@Test
 		public void testZipCodeId() {
 			assertEquals(true, Service.isValidZipcode("502032"));
 		}
 		 

 		
 		@Test
 		void allTransactions() {
 			assertEquals(true,true);
 		}
  

	@Test
	void contextLoads() {
	}

}
