package com.example.yakuba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.yakuba.entity.Account;
import com.example.yakuba.repository.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Account user = accountRepository.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User" + userName + "was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		GrantedAuthority authority = new SimpleGrantedAuthority("USER");

		grantList.add(authority);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails userDetails = (UserDetails) new User(user.getUserName(), encoder.encode(user.getPassword()),
				grantList);

		return userDetails;
	}

}
