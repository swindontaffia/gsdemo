package com.pallelli.mvcpract.rest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MySecurityProviderImpl implements MySecurityProvider {

	static final long SESSION_TIMEOUT = 5*60*1000;
	private class SecurityDetails {
		String userName;
		Set<String> roles;
		long expiryTime;
		
		SecurityDetails(String userName, String [] roles) {
			this.userName = userName;
			this.roles = new HashSet<String>(Arrays.asList(roles));
			expiryTime = System.currentTimeMillis() + SESSION_TIMEOUT;
		}
	}

	private Map<String, SecurityDetails> securityDetailsMap = new HashMap<>();
	
	private Random random = new Random(System.currentTimeMillis());

	@Override
	public String autheticate(String user, String hashedPassword, String[] requestedUserRoles) throws UserNotAutenticatedException {
		if(!(user.equals("admin") && hashedPassword.equals("HJKII"))) {
			throw new UserNotAutenticatedException();
		}
		
		String token = Long.valueOf(random.nextLong()).toString();
		securityDetailsMap.put(token, new SecurityDetails(user, requestedUserRoles));
		
		return token;
	}

	@Override
	public void checkSecurityToken(String user, String token, String role) throws UserNotAutenticatedException, SessionTimedOutException  {
		
		SecurityDetails securityDetails = securityDetailsMap.get(token);
		
		if(securityDetails == null || 
				securityDetails.userName.equals(user) == false || 
				securityDetails.roles.contains(role) == false)  throw new UserNotAutenticatedException();
		
		if(securityDetails.expiryTime < System.currentTimeMillis()) throw new SessionTimedOutException();
		
		securityDetails.expiryTime = System.currentTimeMillis() + SESSION_TIMEOUT;
	}

}
