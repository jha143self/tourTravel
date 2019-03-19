package com.rama.trour.processor;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.rama.api._internal.RestApiConstants;
import com.rama.trour.controller.UpdateUserRestController;
import com.rama.trour.model.User;

/**
 * @author Rakesh Jha
 */
@Component
public class UserResourceProcessor implements ResourceProcessor<Resource<User>> {
    @Override
    public Resource<User> process(Resource<User> resource) {
        resource.add(ControllerLinkBuilder
                .linkTo(UpdateUserRestController.class)
                .slash(resource.getContent())
                .withRel(RestApiConstants.UPDATE));
        return resource;
    }
}