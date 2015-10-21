package com.pallelli.mvcpract.rest;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Autowired
	private MySecurityProvider securityProvider;

	@Override
	public void filter(ContainerRequestContext requestContext) {

		Annotation[] annotations = resourceInfo.getResourceMethod().getDeclaredAnnotations();
		if (Arrays.asList(annotations).stream().filter(a -> a.annotationType() == AutorizationNotRequired.class)
				.count() > 0)
			return;

		try {
			MultivaluedMap<String, String> headers = requestContext.getHeaders();
			List<String> tokens = headers.get(MySecurityProvider.TOKEN_HEADER);
			List<String> users = headers.get(MySecurityProvider.USER_HEADER);
			if (tokens == null || tokens.size() == 0 || users == null || users.size() == 0) {
				throw new UserNotAutenticatedException();
			}

			String user = users.get(0);
			String token = tokens.get(0);

			String role =  "*" ;
			securityProvider.checkSecurityToken(user, token, role);
			return;
		} catch (UserNotAutenticatedException nae) {

			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Not authorized").build());
		} catch (SessionTimedOutException ste) {
			requestContext.abortWith(Response.status(Response.Status.REQUEST_TIMEOUT).entity("Session timed out").build());
		}

	}
}