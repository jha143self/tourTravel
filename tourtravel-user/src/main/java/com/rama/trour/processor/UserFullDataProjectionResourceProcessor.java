package com.rama.trour.processor;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.rama.api._internal.RestApiConstants;
import com.rama.trour.controller.UpdateUserRestController;
import com.rama.trour.controller.UserLoginRestController;
import com.rama.trour.projection.UserFullDataProjection;

/**
 * @author Rakesh Jha
 */
@Component
public class UserFullDataProjectionResourceProcessor implements ResourceProcessor<Resource<UserFullDataProjection>> {
    @Override
    public Resource<UserFullDataProjection> process(Resource<UserFullDataProjection> resource) {
        UserFullDataProjection userData = resource.getContent();
        resource.add(ControllerLinkBuilder
                .linkTo(UpdateUserRestController.class)
                .slash(userData)
                .withRel(RestApiConstants.UPDATE));

        if (userData.isEnabled() &&
                userData.isAccountNonExpired() &&
                userData.isAccountNonLocked() &&
                userData.isCredentialsNonExpired()) {
            resource.add(ControllerLinkBuilder
                    .linkTo(UserLoginRestController.class)
                    .slash(userData)
                    .withRel(RestApiConstants.LOGIN));
        }
        return resource;
    }
}
