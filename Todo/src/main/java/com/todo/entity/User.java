package com.todo.entity;

import java.util.Date;
/**
 * User Entity
 * @author Vijayamurugan D
 */
public class User {

	private String name;
	
	private UserType userType;
	
	private int userId;
	
	private Date joinedDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	
	
	
	
}
