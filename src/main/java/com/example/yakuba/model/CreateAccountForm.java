package com.example.yakuba.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/** アカウント作成 Formクラス */
@Data
public class CreateAccountForm {
	@Getter
	@Setter
	private Long userId;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String userName;
}
