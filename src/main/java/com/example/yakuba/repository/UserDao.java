package com.example.yakuba.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.yakuba.model.User;

public interface UserDao {

    public List<User> selectUser() throws DataAccessException;

}
