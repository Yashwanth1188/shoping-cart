package com.jsp.hibernate.shoping_cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
	
	@Id
	private int userId;
	private String userName;
	private String userEmail;
	private String location;
	private long mobileNo;
	
	@OneToOne
	private Cart cart;
	
	public User() {
		
	}
	public User(int userId, String userName, String userEmail, String location, long mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.location = location;
		this.mobileNo = mobileNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
