package com.rama.api.resources;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.rama.api._internal.AbstractResource;
import com.rama.api._internal.RestApiConstants;
import com.rama.api.enums.UserProjections;
import com.rama.api.interfaces.CanDeleteResource;
import com.rama.api.model.UserApiData;

/**
 * @author Rakesh Jha
 */
public class UserResource extends AbstractResource<UserApiData> implements CanDeleteResource  {

    public UserResource(Link self, UserApiData data) {
        super(self, data);
    }

    @Override
    protected ParameterizedTypeReference<UserApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<UserApiData>() {
        };
    }

    public final UserResource useProjection(UserProjections projection) {
        return new UserResource(getProjectionLink(templatedSelfLink, projection.getName()), getApiData());
    }

    @Override
    protected Class<UserApiData> getResourceType() {
        return UserApiData.class;
    }

    @Override
    public void delete() throws RestClientException {
        super.deleteInternal(getApiData());
    }

    public ResponseEntity loggedIn() {
        Link loginLink = getLinkFor(useProjection(UserProjections.FULL_DATA).getResponseEntity(), RestApiConstants.LOGIN);
        if (loginLink == null) {
            throw new IllegalStateException("The user " + getApiData() + " can currently not log in.");
        }

        return restTemplate.postForEntity(loginLink.getHref(), null, ResponseEntity.class);
    }

    public UpdateUserResource getUpdateResource() {
        return new UpdateUserResource(getLinkFor(getResponseEntity(), RestApiConstants.UPDATE), getApiData());
    }
}
