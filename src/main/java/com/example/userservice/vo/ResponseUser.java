package com.example.userservice.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
	private String email;
	private String name;
	private String userId;

	private List<ResponseOrder> orders;

	public List<ResponseOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ResponseOrder> orders) {
		this.orders = orders;
	}

	public ResponseUser(String email, String name, String userId) {
		this.email = email;
		this.name = name;
		this.userId = userId;
	}

	public ResponseUser() {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}