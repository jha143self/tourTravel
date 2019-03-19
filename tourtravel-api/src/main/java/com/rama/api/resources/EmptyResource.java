package com.rama.api.resources;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;

import com.rama.api._internal.AbstractResource;
import com.rama.api.model.EmptyApiData;

/**
 * Resource class which does not manage any real resource but which maintain a list of links to other resources.
 *
 * @author Rakesh Jha
 * @see EmptyApiData
 */
public class EmptyResource extends AbstractResource<EmptyApiData> {

    public EmptyResource(Link self) {
        super(self);
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
