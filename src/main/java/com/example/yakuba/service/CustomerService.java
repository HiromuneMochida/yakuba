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

	/** 顧客一覧 **/
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

	/** 顧客削除 */
	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}
	/** 顧客検索 */
	public List<Customer> findCustomers(String keyword) {
		List<Customer> list = customerDao.findCustomers(keyword);
		return list;
	}

}
