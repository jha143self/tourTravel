package com.rama.api.resources;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;

import com.rama.api._internal.AbstractResource;
import com.rama.api._internal.RestApiConstants;
import com.rama.api.interfaces.CanCreate;
import com.rama.api.model.UserRegistrationApiData;

/**
 * @author Rakesh Jha
 */
public class UserRegistrationsResource extends AbstractResource<UserRegistrationApiData> implements
        CanCreate<UserRegistrationApiData> {

    public UserRegistrationsResource(Link self) {
        super(self);
    }

    public ResponseEntity<UserRegistrationApiData> create(String username, String password, String email) throws RestClientException {
        UserRegistrationApiData entity = new UserRegistrationApiData();
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setEmail(email);
        return create(entity);
    }

    @Override
    public ResponseEntity<UserRegistrationApiData> create(UserRegistrationApiData entity) throws RestClientException {
        return super.createInternal(entity);
    }

    public final UserRegistrationSearchResultResource findByToken(String token) {
        return new UserRegistrationSearchResultResource(getLinkFor(getResponseEntity(), RestApiConstants
                .SEARCH_RESOURCE).expand(token));
    }

    @Override
    protected ParameterizedTypeReference<UserRegistrationApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<UserRegistrationApiData>() {
        };
    }

    @Override
    protected Class<UserRegistrationApiData> getResourceType() {
        return UserRegistrationApiData.class;
    }

    public class UserRegistrationSearchResultResource extends AbstractResource<UserRegistrationApiData> {

        public UserRegistrationSearchResultResource(Link self) {
            super(self);
        }

        public final boolean exists() {
            try {
                read();
            } catch (HttpStatusCodeException exc) {
                return false;
            }
            return true;
        }

        public final ResponseEntity confirmRegistration() {
            return restTemplate.postForEntity(getLinkFor(getResponseEntity(), RestApiConstants.CONFIRM).getHref(), null, ResponseEntity.class);
        }

        @Override
        protected ParameterizedTypeReference<UserRegistrationApiData> getParameterizedTypeReference() {
            return new ParameterizedTypeReference<UserRegistrationApiData>() {
            };
        }

        @Override
        protected Class<UserRegistrationApiData> getResourceType() {
            return UserRegistrationApiData.class;
        }
    }
}
