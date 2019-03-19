package com.rama.api;

import org.springframework.hateoas.Link;

import com.rama.api.resources.UserService;

public final class UserServiceAPI {

    private UserServiceAPI() {
    }

    /**
     * Initialize the client with the user service's URL. Only this base URL needs to be known to be able to use the
     * service. All of the service's resources can be reached through the fluent API provided by the returned
     * {@link UserService} object.
     * <p/>
     * The service's base URL can also be dynamically provided by a
     * {@link info.rolandkrueger.userservice.api.service.UserMicroserviceEndpointProvider}.
     *
     * @param targetURI base URL of the user micro-service
     * @return a {@link UserService} object that provides access to the service's resources
     * @see info.rolandkrueger.userservice.api.service.UserMicroserviceEndpointProvider
     */
    public static UserService init(String targetURI) {
        UserService userService = new UserService(new Link(targetURI));
        userService.init();

        return userService;
    }
}
