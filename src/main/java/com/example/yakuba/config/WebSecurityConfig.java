package com.example.yakuba.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.yakuba.service.AccountService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests().antMatchers("/**").hasRole("USER")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/customer/index", true)
				.failureUrl("/login?error")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}
}
