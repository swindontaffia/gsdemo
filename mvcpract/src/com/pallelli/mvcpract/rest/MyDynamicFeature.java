package com.pallelli.mvcpract.rest;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDynamicFeature implements DynamicFeature {

    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
        if ("HelloWorldResource".equals(resourceInfo.getResourceClass().getSimpleName())
                && "getHello".equals(resourceInfo.getResourceMethod().getName())) {
            context.register(AuthorizationRequestFilter.class);
        }
    }
}