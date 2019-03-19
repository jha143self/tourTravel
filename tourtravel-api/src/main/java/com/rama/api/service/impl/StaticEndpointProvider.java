package com.rama.api.service.impl;

import org.springframework.stereotype.Service;

import com.rama.api.service.UserMicroserviceEndpointProvider;

/**
 * Default implementation for the {@link UserMicroserviceEndpointProvider} that simply provides a static, predefined
 * user service endpoint URL.
 *
 * @author Rakesh Jha
 */
@Service
public class StaticEndpointProvider implements UserMicroserviceEndpointProvider {

    private String endpoint;

    protected StaticEndpointProvider() {
    }

    /**
     * Creates a new StaticEndpointProvider for the given static endpoint URL.
     *
     * @param endpoint static endpoint address for the user micro-service
     */
    public StaticEndpointProvider(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Returns the fixed user service endpoint address passed in through the constructor.
     */
    @Override
    public String getUserMicroserviceEndpoint() {
        return endpoint;
    }
}
