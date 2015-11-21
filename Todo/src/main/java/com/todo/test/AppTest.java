package com.todo.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.todo.config.ServiceConfig;
/**
 * Context Initialization test
 * @author Vijayamurugan D
 *
 */
public class AppTest {

	@Test
	public void contextIntializationTest() {
		

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ServiceConfig.class);
		Assert.assertNotNull(context);
	}

}
