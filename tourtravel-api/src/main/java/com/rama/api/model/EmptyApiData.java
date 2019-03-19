package com.rama.api.model;


import org.springframework.hateoas.Link;

import com.rama.api._internal.model.AbstractBaseApiData;
import com.rama.api.resources.EmptyResource;

/**
 * Empty API data class with no data fields. Used as dummy data type by {@link EmptyResource}s.
 *
 * @author Rakesh Jha
 * @see EmptyResource
 */
public class EmptyApiData extends AbstractBaseApiData<EmptyResource> {
    @Override
    protected EmptyResource createNewResource(Link self) {
        return new EmptyResource(self);
    }
}
