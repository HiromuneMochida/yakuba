package com.example.yakuba.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.yakuba.model.User;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<User> selectUser() throws DataAccessException {

		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM user");

		List<User> userList = new ArrayList<>();

		for (Map<String, Object> map : getList) {

			User user = new User();

			user.setUserId((int) map.get("user_id"));
			user.setPassword((String) map.get("password"));
			user.setUserName((String) map.get("user_name"));
			userList.add(user);
		}
		return userList;
	}

}
