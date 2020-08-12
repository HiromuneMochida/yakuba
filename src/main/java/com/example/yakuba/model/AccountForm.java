package com.example.yakuba.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountForm {
	@Getter
	@Setter
	private int userId;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String userName;

}
