package com.example.yakuba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer") //Todo -> customer
public class Customer {
	@Id
	@Column(name = "customer_id") //Todo -> customer
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_sei")
	private String nameSei;
	@Column(name = "name_mei")
	private String nameMei;
	@Column(name = "birth_year")
	private String birthYear;
	@Column(name = "birth_month")
	private String birthMonth;
	@Column(name = "birth_day")
	private String birthDay;
	@Column(name = "prefecture")
	private String prefecture;
	@Column(name = "residence")
	private String residence;
	@Column(name = "gender")
	private String gender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameSei() {
		return nameSei;
	}

	public void setNameSei(String nameSei) {
		this.nameSei = nameSei;
	}

	public String getNameMei() {
		return nameMei;
	}

	public void setNameMei(String nameMei) {
		this.nameMei = nameMei;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Custmoer [id=" + id + ", nameSei=" + nameSei + ", nameMei=" + nameMei + ",birthYear=" + birthYear
				+ ", birthMonth=" + birthMonth + ", birthDay=" + birthDay + ", prefecture=" + prefecture + ", residence="
				+ residence + ", gender=" + gender + "]";
	}
}