package com.example.yakuba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yakuba.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
