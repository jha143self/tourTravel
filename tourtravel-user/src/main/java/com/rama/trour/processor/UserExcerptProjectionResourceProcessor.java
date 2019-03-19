package com.rama.trour.processor;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Rakesh Jha
 */
@Component
public class UserExcerptProjectionResourceProcessor implements ResourceProcessor<Resource<UserExcerptProjection>> {
    @Override
    public Resource<UserExcerptProjection> process(Resource<UserExcerptProjection> resource) {
        resource.add(ControllerLinkBuilder
                .linkTo(UpdateUserRestController.class)
                .slash(resource.getContent())
                .withRel(RestApiConstants.UPDATE));
        return resource;
    }
}