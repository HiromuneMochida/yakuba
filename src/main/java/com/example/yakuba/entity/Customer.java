package com.example.yakuba.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name_sei")
	private String nameSei;
	@Column(name = "name_mei")
	private String nameMei;
	@Column(name = "birth_day")
	private String birthDay;
	@Column(name = "prefecture")
	private String prefecture;
	@Column(name = "residence")
	private String residence;
	@Column(name = "gender")
	private String gender;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", updatable = false)
	private Date updatedAt;
	@Column(name = "user_name")
	private String userName;

	/* ユーザー情報_名前 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/* ID */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* 名前_姓 */
	public String getNameSei() {
		return nameSei;
	}

	public void setNameSei(String nameSei) {
		this.nameSei = nameSei;
	}

	/* 名前_名 */
	public String getNameMei() {
		return nameMei;
	}

	public void setNameMei(String nameMei) {
		this.nameMei = nameMei;
	}

	/* 生年月日 */
	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/* 都道府県 */
	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	/* 住所 */
	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	/* 性別 */
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/* 最終更新日 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PrePersist
	public void prePersist() {
		this.updatedAt = new Date();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}