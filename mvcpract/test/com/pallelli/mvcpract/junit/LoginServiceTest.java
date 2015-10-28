package com.pallelli.mvcpract.junit;

import static org.junit.Assert.*;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pallelli.mvcpract.security.LoginDetails;
import com.pallelli.mvcpract.security.LoginService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/junitTestsAppContext.xml" })

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
		LoginDetails loginForm = new LoginDetails();
		loginForm.setName("admn");
		loginForm.setPassword("NCB");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 401);
		
	}

	private void testBadPassword() {
		LoginDetails loginForm = new LoginDetails();
		loginForm.setName("admin");
		loginForm.setPassword("HJKI");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 401);
	}

	private void testLoginOK() {
		LoginDetails loginForm = new LoginDetails();
		loginForm.setName("admin");
		loginForm.setPassword("NCB");
		Response response = theService.doLogin(loginForm);
		assertTrue(response.getStatus() == 200);
	}

}
