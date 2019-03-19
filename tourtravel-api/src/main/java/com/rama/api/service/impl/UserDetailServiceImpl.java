package com.rama.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.google.common.base.Preconditions;
import com.rama.api.UserServiceAPI;
import com.rama.api.enums.UserProjections;
import com.rama.api.model.UserApiData;
import com.rama.api.resources.UserService;
import com.rama.api.service.UserMicroserviceEndpointProvider;

/**
 * Implementation of the {@link UserDetailsService} interface which accesses the user micro-service to obtain {@link UserDetails}
 * objects. The user details services uses a {@link UserMicroserviceEndpointProvider} instance to get the user service's
 * endpoint URL.
 *
 * @author Rakesh Jha
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserMicroserviceEndpointProvider endpointProvider;

    /**
     * Constructor which is autowired with an instance of {@link UserMicroserviceEndpointProvider}.
     */
    @Autowired
    public UserDetailServiceImpl(UserMicroserviceEndpointProvider endpointProvider) {
        Preconditions.checkNotNull(endpointProvider);
        this.endpointProvider = endpointProvider;
    }

    /**
     * Load a {@link UserDetails} object from the user micro-service for the specified username. Note that this method
     * in addition to a {@link UsernameNotFoundException} throws an unchecked {@link RestClientException} to indicate
     * errors that occurred during the communication process with the remote user micro-service.
     *
     * @param username name of the user to be loaded
     * @return a {@link UserDetails} object
     * @throws UsernameNotFoundException when the given username is not known to the service
     * @throws RestClientException when some error occurred while calling the REST service
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, RestClientException {
        UserService userService = UserServiceAPI.init(endpointProvider.getUserMicroserviceEndpoint());
        Optional<UserApiData> loadedUser = userService.users().search().findByUsername(username).getData().stream().findFirst();
        if (!loadedUser.isPresent()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return loadedUser.get().getResource().useProjection(UserProjections.FULL_DATA).read();
    }
}
