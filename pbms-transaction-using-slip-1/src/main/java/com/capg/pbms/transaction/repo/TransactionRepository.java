package com.capg.pbms.transaction.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.pbms.transaction.model.AccountManagement;
@Repository
public interface TransactionRepository extends JpaRepository<AccountManagement, String>{

	

}

