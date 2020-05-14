package com.example.yakuba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yakuba.entity.Customer;
import com.example.yakuba.repository.CustomerDao;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer findById(Long id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer.get();
	}

	public Customer saveAndFlush(Customer customer) {
		return customerDao.saveAndFlush(customer);
	}

	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}

}
