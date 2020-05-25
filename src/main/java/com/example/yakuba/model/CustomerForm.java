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
	/** 生年月日 */
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

	/** 性別選択 */
	public Map<String, String> genderSelect() {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("1", "男");
		genderMap.put("2", "女");
		genderMap.put("3", "不明");
		return genderMap;
	}

	/** 性別選択 */
	public Map<String, String> prefectureSelect() {
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		genderMap.put("1", "北海道");
		genderMap.put("2", "青森県");
		genderMap.put("3", "岩手県");
		genderMap.put("4", "宮城県");
		genderMap.put("5", "秋田県");
		genderMap.put("6", "山形県");
		genderMap.put("7", "福島県");
		genderMap.put("8", "茨城県");
		genderMap.put("9", "栃木県");
		genderMap.put("10", "群馬県");
		genderMap.put("11", "埼玉県");
		genderMap.put("12", "千葉県");
		genderMap.put("13", "東京都");
		genderMap.put("14", "神奈川県");
		genderMap.put("15", "新潟県");
		genderMap.put("16", "富山県");
		genderMap.put("17", "石川県");
		genderMap.put("18", "福井県");
		genderMap.put("19", "山梨県");
		genderMap.put("20", "長野県");
		genderMap.put("21", "岐阜県");
		genderMap.put("22", "静岡県");
		genderMap.put("23", "愛知県");
		genderMap.put("24", "三重県");
		genderMap.put("25", "滋賀県");
		genderMap.put("26", "京都府");
		genderMap.put("27", "大阪府");
		genderMap.put("28", "兵庫県");
		genderMap.put("29", "奈良県");
		genderMap.put("30", "和歌山県");
		genderMap.put("31", "鳥取県");
		genderMap.put("32", "島根県");
		genderMap.put("33", "岡山県");
		genderMap.put("34", "広島県");
		genderMap.put("35", "山口県");
		genderMap.put("36", "徳島県");
		genderMap.put("37", "香川県");
		genderMap.put("38", "愛媛県");
		genderMap.put("39", "高知県");
		genderMap.put("40", "福岡県");
		genderMap.put("41", "佐賀県");
		genderMap.put("42", "長崎県");
		genderMap.put("43", "熊本県");
		genderMap.put("44", "大分県");
		genderMap.put("45", "宮崎県");
		genderMap.put("46", "鹿児島県");
		genderMap.put("47", "沖縄県");
		return genderMap;
	}

}