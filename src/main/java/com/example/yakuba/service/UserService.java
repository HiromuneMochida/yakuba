package com.example.yakuba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.yakuba.model.User;
import com.example.yakuba.repository.UserDao;

@Transactional
@Service
public class UserService {

	@Autowired
	@Qualifier("UserDaoJdbcImpl")
	UserDao dao;

	public List<User> selectMany() {
		return dao.selectMany();

	}

}
