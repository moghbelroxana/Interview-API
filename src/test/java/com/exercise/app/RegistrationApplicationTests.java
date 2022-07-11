package com.exercise.app;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistrationApplicationTests {
	private UsersController usersController = new UsersController();
	@Test
	void contextLoads() {
	}

	//Test that password is more than 8 char
	@Test
	void passwordIsLessThan8Chars(){
		assertFalse(usersController.isValid("Pa$$1"));
	}

	//Test that password is 8 char
	@Test
	void passwordIs8Chars(){
		assertTrue(usersController.isValid("Pa$$wor1"));
	}

	//Test that password is greater than 8 char
	@Test
	void passwordIsGreaterThan8Chars(){
		assertTrue(usersController.isValid("Pa$$word1"));
	}

	//Test that password doesn't have uppercase
	@Test
	void passwordNoUpper(){
		assertFalse(usersController.isValid("pa$$word1"));
	}

	//Test that password has uppercase
	@Test
	void passwordUpper(){
		assertTrue(usersController.isValid("Pa$$wOrd1"));
	}

	//Test that password doesn't accept symbols not on list
	@Test
	void passwordBadSym(){
		assertFalse(usersController.isValid("P@$$wOrd1"));
	}

	//Test that password doesn't accept no sym
	@Test
	void passwordNoSym(){
		assertFalse(usersController.isValid("PasswOrd1"));
	}

	//Test that password doesn't accept no number
	@Test
	void passwordNoNum(){
		assertFalse(usersController.isValid("Pa$$wOrd"));
	}
	
	@Test
	void candaLocation() throws Exception{
		User user= new User();
		user.setIpAddress("100.42.255.255");
		assertTrue(usersController.validLocation(user));
	}

	@Test
	void americaLocation() throws Exception{
		User user= new User();
		user.setIpAddress("47.230.207.129");
		assertFalse(usersController.validLocation(user));
	}

	@Test
	void mexicoLocation() throws Exception{
		User user= new User();
		user.setIpAddress("103.14.26.0");
		assertFalse(usersController.validLocation(user));
	}


}
