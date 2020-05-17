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
	/** 名前 */
	@Getter
	@Setter
	private String name;
	/** 年齢 */
	@Getter
	@Setter
	private Integer age;
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
