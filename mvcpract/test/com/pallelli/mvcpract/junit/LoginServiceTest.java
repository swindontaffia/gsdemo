package com.pallelli.mvcpract.junit;

import static org.junit.Assert.*;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pallelli.mvcpract.rest.LoginService;
import com.pallelli.mvcpract.security.LoginForm;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/junit-app-context.xml" })

public class LoginServiceTest {

	@Autowired
	private LoginService theService;
	
	@Test
	public void test() {
		testLoginOK();
		testBadPassword();
		testBadUserName();
	}

	private void testBadUserName() {
		LoginForm loginForm = new LoginForm();
		loginForm.setName("admn");
		loginForm.setPassword("HJKII");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 401);
		
	}

	private void testBadPassword() {
		LoginForm loginForm = new LoginForm();
		loginForm.setName("admin");
		loginForm.setPassword("HJKI");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 401);
	}

	private void testLoginOK() {
		LoginForm loginForm = new LoginForm();
		loginForm.setName("admin");
		loginForm.setPassword("HJKII");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 200);
	}

}
