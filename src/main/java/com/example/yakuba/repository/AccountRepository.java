package com.example.yakuba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.yakuba.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

	public Account findByUserName(String userName);

	public Account findByUserId(Long userId);

}
