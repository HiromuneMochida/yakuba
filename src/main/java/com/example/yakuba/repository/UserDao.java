package com.example.yakuba.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.yakuba.model.User;

public interface UserDao {

    // Userテーブルの全データを取得.
    public List<User> selectMany() throws DataAccessException;

}
