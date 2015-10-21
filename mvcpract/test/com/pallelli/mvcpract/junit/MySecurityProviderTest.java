package com.pallelli.mvcpract.junit;

import static org.junit.Assert.*;

import javax.naming.TimeLimitExceededException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pallelli.mvcpract.security.MySecurityProvider;
import com.pallelli.mvcpract.security.MySecurityProviderImpl;
import com.pallelli.mvcpract.security.SessionTimedOutException;
import com.pallelli.mvcpract.security.UserNotAutenticatedException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/junit-app-context.xml" })


public class MySecurityProviderTest {

	@Autowired
	MySecurityProviderImpl securityProvider;
	
	@Test
	public void test() {
		testGoodLogin();
		testBadPassword();
		testBaddUserName();
		testCheckGoodToken();
		testBadToken();
		testBadUser();
		testTimeout();
		
	}

	private void testGoodLogin() {
		String [] roles = { "*" };
		try {
			securityProvider.autheticate("admin", "HJKII", roles  );
		} catch (UserNotAutenticatedException e) {
			 fail();
		}
		
	}

	private void testBadPassword() {
		String [] roles = { "*" };
		try {
			securityProvider.autheticate("admin", "HJKI", roles  );
		} catch (UserNotAutenticatedException e) {
			return; // passed
		}
		
		fail();
	}

	private void testBaddUserName() {
		String [] roles = { "*" };
		try {
			securityProvider.autheticate("admn", "HJKII", roles  );
		} catch (UserNotAutenticatedException e) {
			return; // passed
		}
		
		fail();
	}

	private void testCheckGoodToken() {
		String [] roles = { "*" };
		String token;
		securityProvider.getSessionTimeout(5000L);
		try {
			token = securityProvider.autheticate("admin", "HJKII", roles  );
		} catch (UserNotAutenticatedException e) {
			 fail();
			 return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail();
			return;
		}

		try {
			securityProvider.checkSecurityToken("admin", token, "*");
		} catch (Exception e) {
			fail();
		}
	}

	private void testBadToken() {
		try {
			securityProvider.checkSecurityToken("admin", "badt token", "*");
		} catch (Exception e) {
			return; // passed;
		}
		fail();
		
	}

	private void testBadUser() {
		String [] roles = { "*" };
		String token;
		try {
			token = securityProvider.autheticate("admin", "HJKII", roles  );
		} catch (UserNotAutenticatedException e) {
			 fail();
			 return;
		}
		
		try {
			securityProvider.checkSecurityToken("admn", token, "*");
		} catch (UserNotAutenticatedException e) {
			return; // test passed
		} catch (SessionTimedOutException e) {
			fail();
		}
		
		fail();
	}

	private void testTimeout() {
		String [] roles = { "*" };
		securityProvider.getSessionTimeout(500L);
		String token;
		try {
			token = securityProvider.autheticate("admin", "HJKII", roles  );
		} catch (UserNotAutenticatedException e) {
			 fail();
			 return;
		}
		
		
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			fail();
			return;
		}
		
		try {
			securityProvider.checkSecurityToken("admin", token , "*"  );
		} catch (SessionTimedOutException e) {
			 return;
		} catch (UserNotAutenticatedException e) {
			fail();
		}
		fail();
		
	}

}
