package com.pallelli.mvcpract;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.JerseyResourceContext;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.pallelli.mvcpract.rest.DietLoggerService;

public class DietLogApplication extends ResourceConfig {
 
    /**
	* Register JAX-RS application components.
	*/	
	public DietLogApplication(){
        register(RequestContextFilter.class);
        register(JerseyResourceContext.class);
        register(DietLoggerService.class);
        
        // Jackson JSON marshalling
        register(JacksonFeature.class);
	}
}
