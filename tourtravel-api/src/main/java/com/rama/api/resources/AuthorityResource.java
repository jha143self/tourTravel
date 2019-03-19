package com.rama.api.resources;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.web.client.RestClientException;

import com.rama.api._internal.AbstractResource;
import com.rama.api.interfaces.CanDeleteResource;
import com.rama.api.interfaces.CanUpdateResource;
import com.rama.api.model.AuthorityApiData;

/**
 * @author Rakesh Jha
 */
public class AuthorityResource extends AbstractResource<AuthorityApiData> implements CanUpdateResource,
        CanDeleteResource {

    public AuthorityResource(Link self, AuthorityApiData data) {
        super(self, data);
    }

    @Override
    protected ParameterizedTypeReference<AuthorityApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<AuthorityApiData>() {
        };
    }

    @Override
    protected Class<AuthorityApiData> getResourceType() {
        return AuthorityApiData.class;
    }

    @Override
    public void delete() throws RestClientException {
        super.deleteInternal(getApiData());
    }

    @Override
    public void update() throws RestClientException {
        super.updateInternal(getApiData());
    }
}
