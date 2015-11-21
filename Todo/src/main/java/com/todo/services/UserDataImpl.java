package com.todo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.entity.User;
import com.todo.entity.UserType;
import com.todo.util.Util;

/**
 * User data Simulation it can be later mapped to the storage
 * 
 * @author Vijayamurugan D
 * 
 *
 */

@Service
public class UserDataImpl implements UserDataService {

	@Override
	public List<User> getAllUsers() {

		List<User> result = new ArrayList<User>();
		User user = new User();
		user.setName("Vijay");
		user.setUserId(100);
		user.setUserType(UserType.CUSTOMER);
		user.setJoinedDate(Util.getOldDate());

		result.add(user);

		User user1 = new User();
		user1.setName("Vinay");
		user1.setUserId(101);
		user1.setUserType(UserType.EMPLOYEE);
		result.add(user1);
		user1.setJoinedDate(Util.getOldDate());

		User user2 = new User();
		user2.setName("Berner Lee");
		user2.setUserId(102);
		user2.setUserType(UserType.AFFILIATE);
		user2.setJoinedDate(new Date());

		result.add(user2);

		User user3 = new User();
		user3.setName("Barton");
		user3.setUserId(103);
		user3.setUserType(UserType.CUSTOMER);
		user3.setJoinedDate(new Date());

		result.add(user3);

		return result;
	}

	public User getUserById(int user_id) {
		User result = null;
		for (User user : getAllUsers()) {
			if (user.getUserId() == user_id) {
				result = user;
				break;
			}

		}
		return result;
	}

}
