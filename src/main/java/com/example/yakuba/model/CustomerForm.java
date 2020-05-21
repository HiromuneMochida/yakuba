package com.example.yakuba.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Formオブジェクトクラス
 */
@Data
public class CustomerForm {
	/** ID */
	@Getter
	@Setter
	private Long id;
	/** 名前_姓 */
	@Getter
	@Setter
	private String nameSei;
	/** 名前_名 */
	@Getter
	@Setter
	private String nameMei;
	/** 生年月日_年 */
	@Getter
	@Setter
	private String birthYear;
	/** 生年月日_月 */
	@Getter
	@Setter
	private String birthMonth;
	/** 生年月日_日 */
	@Getter
	@Setter
	private String birthDay;
	/** 都道府県 */
	@Getter
	@Setter
	private String prefecture;
	/** 住所 */
	@Getter
	@Setter
	private String residence;
	/** 性別 */
	@Getter
	@Setter
	private String gender;

	public Map<String, String> genderSelect() {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("1", "男");
		genderMap.put("2", "女");
		genderMap.put("3", "不明");
		return genderMap;
	}

}