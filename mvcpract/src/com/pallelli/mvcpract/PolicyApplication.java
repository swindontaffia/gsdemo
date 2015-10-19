package com.pallelli.mvcpract;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.JerseyResourceContext;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.pallelli.mvcpract.rest.RiskService;

public class PolicyApplication extends ResourceConfig {
 
    /**
	* Register JAX-RS application components.
	*/	
	public PolicyApplication(){
        register(RequestContextFilter.class);
        register(JerseyResourceContext.class);
        register(RiskService.class);
        
        // Jackson JSON marshalling
        register(JacksonFeature.class);
	}
}
