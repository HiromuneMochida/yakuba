package com.example.yakuba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yakuba.entity.Custmoer;
import com.example.yakuba.repository.CustmoerDao;

@Service
public class CustmoerService {
	@Autowired
	private CustmoerDao custmoerDao;

	public List<Custmoer> findAll() {
		return custmoerDao.findAll();
	}

	public Custmoer findById(Long id) {
		Optional<Custmoer> custmoer = custmoerDao.findById(id);
		return custmoer.get();
	}

	public Custmoer saveAndFlush(Custmoer custmoer) {
		return custmoerDao.saveAndFlush(custmoer);
	}

	public void deleteById(Long id) {
		custmoerDao.deleteById(id);
	}

}
