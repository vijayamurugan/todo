package com.todo.services;

import java.util.List;

import com.todo.entity.User;

/**
 * 
 * @author Vijayamurugan D
 *
 */
public interface UserDataService {

	public List<User> getAllUsers();

	public User getUserById(int user_id);

}
