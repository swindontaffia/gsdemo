package com.pallelli.mvcpract.rest;

import com.pallelli.mvcpract.security.SessionTimedOutException;
import com.pallelli.mvcpract.security.UserNotAutenticatedException;

public interface MySecurityProvider {
	
	static final String TOKEN_HEADER = "X-Auth-Token";
	static final String USER_HEADER = "X-Auth-User";
	
	/**
	 * Authenticate the user and return a security token if the user has been authenticated.   
	 * 
	 * @param user
	 * @param hashedPassword
	 * @param requestedUserRoles
	 * 
	 * @return a security token
	 */
	String autheticate(String user, String hashedPassword, String [] requestedUserRoles) throws UserNotAutenticatedException;
	void checkSecurityToken(String user, String token, String role) throws UserNotAutenticatedException, SessionTimedOutException;

}
