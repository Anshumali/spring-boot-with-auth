package com.boot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
  
  public Account findByUsername(String username);

}