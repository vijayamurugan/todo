package com.todo.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.todo.config.ServiceConfig;
import com.todo.entity.User;
import com.todo.services.UserDataService;

/**
 * User Data Spooling unit test cases
 * @author Vijayamurugan D
 *
 */
public class UserDataImplTest {

	ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceConfig.class);
	UserDataService uds = (UserDataService) context
			.getBean(UserDataService.class);

	@Test
	public void getAllUsers() {
		Assert.assertNotNull(uds);
		List<User> users = uds.getAllUsers();
		for (User user : users) {
			Assert.assertNotNull(user.getName());
			Assert.assertNotNull(user.getJoinedDate());
			Assert.assertNotNull(user.getUserType());

		}
	}

	@Test
	public void getUserbyId() {

		User user = uds.getUserById(100);
		Assert.assertNotNull(user.getName());
		Assert.assertNotNull(user.getJoinedDate());
		Assert.assertNotNull(user.getUserType());

	}

}
