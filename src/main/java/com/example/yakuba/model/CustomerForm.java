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

	/** 都道府県選択 */
	public Map<String, String> prefectureSelect() {
		Map<String, String> prefectureMap = new LinkedHashMap<String, String>();
		prefectureMap.put("1", "北海道");
		prefectureMap.put("2", "青森県");
		prefectureMap.put("3", "岩手県");
		prefectureMap.put("4", "宮城県");
		prefectureMap.put("5", "秋田県");
		prefectureMap.put("6", "山形県");
		prefectureMap.put("7", "福島県");
		prefectureMap.put("8", "茨城県");
		prefectureMap.put("9", "栃木県");
		prefectureMap.put("10", "群馬県");
		prefectureMap.put("11", "埼玉県");
		prefectureMap.put("12", "千葉県");
		prefectureMap.put("13", "東京都");
		prefectureMap.put("14", "神奈川県");
		prefectureMap.put("15", "新潟県");
		prefectureMap.put("16", "富山県");
		prefectureMap.put("17", "石川県");
		prefectureMap.put("18", "福井県");
		prefectureMap.put("19", "山梨県");
		prefectureMap.put("20", "長野県");
		prefectureMap.put("21", "岐阜県");
		prefectureMap.put("22", "静岡県");
		prefectureMap.put("23", "愛知県");
		prefectureMap.put("24", "三重県");
		prefectureMap.put("25", "滋賀県");
		prefectureMap.put("26", "京都府");
		prefectureMap.put("27", "大阪府");
		prefectureMap.put("28", "兵庫県");
		prefectureMap.put("29", "奈良県");
		prefectureMap.put("30", "和歌山県");
		prefectureMap.put("31", "鳥取県");
		prefectureMap.put("32", "島根県");
		prefectureMap.put("33", "岡山県");
		prefectureMap.put("34", "広島県");
		prefectureMap.put("35", "山口県");
		prefectureMap.put("36", "徳島県");
		prefectureMap.put("37", "香川県");
		prefectureMap.put("38", "愛媛県");
		prefectureMap.put("39", "高知県");
		prefectureMap.put("40", "福岡県");
		prefectureMap.put("41", "佐賀県");
		prefectureMap.put("42", "長崎県");
		prefectureMap.put("43", "熊本県");
		prefectureMap.put("44", "大分県");
		prefectureMap.put("45", "宮崎県");
		prefectureMap.put("46", "鹿児島県");
		prefectureMap.put("47", "沖縄県");
		return prefectureMap;
	}

}