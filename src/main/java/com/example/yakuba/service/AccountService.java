package com.example.yakuba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.yakuba.entity.Account;
import com.example.yakuba.entity.Customer;
import com.example.yakuba.repository.AccountRepository;
import com.example.yakuba.repository.CustomerDao;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerDao customerDao;
	/** ユーザー認証 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Account user = accountRepository.findByUserName(userName);

		if (user == null || "".equals(userName)) {
			throw new UsernameNotFoundException("Account" + userName + "was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().toString());
		grantList.add(authority);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserDetails userDetails = (UserDetails) new User(user.getUsername(),encoder.encode(user.getPassword()),grantList);

		return userDetails;
	}

	/** ログインユーザー顧客情報検索 */
	public List<Customer> findCreateUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		List<Customer> customer = customerDao.findByUserName(userName);

		return customer;
	}

	/** ログインユーザー名表示 */
	public String displayUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();

		return userName;
	}

}
