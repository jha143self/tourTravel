package com.rama.api.resources;
import com.rama.api._internal.AbstractResource;
import com.rama.api.model.*;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;

/**
 * @author Rakesh Jha
 */
public class ConfirmRegistrationResource extends AbstractResource<EmptyApiData> {

    ConfirmRegistrationResource(Link self) {
        super(self);
    }

    public final ResponseEntity confirmRegistration() {
        return restTemplate.postForEntity(self.getHref(), null, ResponseEntity.class);
    }

    @Override
    protected ParameterizedTypeReference<EmptyApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<EmptyApiData>() {
        };
    }

    @Override
    protected Class<EmptyApiData> getResourceType() {
        return EmptyApiData.class;
    }
}
