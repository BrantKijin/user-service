package com.example.userservice.dto;

import java.util.Date;
import java.util.List;

import com.example.userservice.vo.ResponseOrder;

public class UserDto {
	private String email;
	private String name;
	private String pwd;
	private String userId;
	private Date createdAt;

	private String encryptedPwd;

	private List<ResponseOrder> orders;

	public List<ResponseOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ResponseOrder> orders) {
		this.orders = orders;
	}

	public UserDto() {
	}

	public UserDto(String email, String name, String pwd, String userId, Date createdAt, String encryptedPwd) {
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.userId = userId;
		this.createdAt = createdAt;
		this.encryptedPwd = encryptedPwd;
	}

	public String getEncryptedPwd() {
		return encryptedPwd;
	}

	public void setEncryptedPwd(String encryptedPwd) {
		this.encryptedPwd = encryptedPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
