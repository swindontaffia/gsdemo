package com.pallelli.mvcpract.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;

@Path("login")
@Component

public class LoginService {

	@Context
    private ResourceInfo resourceInfo;

	@NoAutorizationCheckNeeded
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doLogin(LoginForm loginForm) {
		return  Response.ok("authenticated").status(200).build();
	}
}
