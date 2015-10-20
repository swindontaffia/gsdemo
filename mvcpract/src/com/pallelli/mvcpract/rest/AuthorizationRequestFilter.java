package com.pallelli.mvcpract.rest;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

//@PreMatching
//@Priority(value = 3)
@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
	@Context
    private ResourceInfo resourceInfo;

	
    @Override
    public void filter(ContainerRequestContext requestContext)
                    throws IOException {
    	
    	Annotation[] annotations = resourceInfo.getResourceMethod().getDeclaredAnnotations();
    	if( Arrays.asList(annotations).stream().filter(a -> a.annotationType() == NoAutorizationCheckNeeded.class).count() > 0) return;
    	

        final SecurityContext securityContext =
                    requestContext.getSecurityContext();
        if (securityContext == null ||
                    !securityContext.isUserInRole("privileged")) {
 
                requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource.")
                    .build());
        }
    }
}