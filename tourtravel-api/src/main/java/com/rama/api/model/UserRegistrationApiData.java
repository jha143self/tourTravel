package com.rama.api.model;

import com.google.common.base.MoreObjects;
import com.rama.api._internal.model.AbstractBaseApiData;
import com.rama.api.resources.UserRegistrationsResource;

import org.springframework.hateoas.Link;

/**
 * Client-side representation of a pending (non-confirmed) user registration. Such a user registration object can be
 * obtained from the service for any given registration confirmation token if that token is still valid. For tokens
 * that have timed out no user registration object will be provided.
 *
 * @author Rakesh Jha
 */
public class UserRegistrationApiData extends AbstractBaseApiData<UserRegistrationsResource> {
    private String username;
    private String password;
    private String email;
    private String registrationConfirmationToken;

    public String getRegistrationConfirmationToken() {
        return registrationConfirmationToken;
    }

    public void setRegistrationConfirmationToken(String registrationConfirmationToken) {
        this.registrationConfirmationToken = registrationConfirmationToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected UserRegistrationsResource createNewResource(Link self) {
        return new UserRegistrationsResource(self);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(UserRegistrationApiData.class)
                .add("username", username)
                .add("email", email)
                .toString();
    }
}
