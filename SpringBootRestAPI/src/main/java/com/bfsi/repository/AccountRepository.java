package com.bfsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfsi.model.Account;

public interface AccountRepository extends JpaRepository <Account,Long>{

}
