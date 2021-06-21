package com.anand.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = 5118627799133336513L;
	private String fullName;
	private String email;
	private String password;
	private String phone;
	private String education;
	private String address;
	private String picture;
	private String pictureExtensions;
	private String serialNumber;
	private String registrationDate;
	private String userType;
	
	

	private String url;
	private String buttonLevel;

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getButtonLevel() {
		return buttonLevel;
	}

	public void setButtonLevel(String buttonLevel) {
		this.buttonLevel = buttonLevel;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPictureExtensions() {
		return pictureExtensions;
	}

	public void setPictureExtensions(String pictureExtensions) {
		this.pictureExtensions = pictureExtensions;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
