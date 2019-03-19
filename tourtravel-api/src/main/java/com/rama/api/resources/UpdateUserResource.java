package com.rama.api.resources;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.web.client.RestClientException;

import com.rama.api._internal.AbstractResource;
import com.rama.api.interfaces.CanUpdateResource;
import com.rama.api.model.AuthorityApiData;
import com.rama.api.model.UserApiData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rakesh Jha
 */
public class UpdateUserResource extends AbstractResource<UserApiData> implements CanUpdateResource {

    UpdateUserResource(Link templatedBaseLink, UserApiData data) {
        super(templatedBaseLink, data);
    }

    @Override
    public void update() throws RestClientException {
        super.updateInternal(self, getApiData());
    }

    public void addAuthorities(String... authorities) {
        Arrays.asList(authorities)
                .stream()
                .forEach(
                        authority -> getApiData()
                                .getAuthorities()
                                .add(new AuthorityApiData(authority, null)));
        update();
    }

    public void removeAuthorities(String... authorities) {
        List<String> removedAuthorities = Arrays.asList(authorities);
        getApiData().setAuthorities(
                getApiData().getAuthorities().stream().filter(
                        authority -> removedAuthorities
                                .stream()
                                .noneMatch(removedAuthority -> removedAuthority.equals(authority.getAuthority()))
                ).collect(Collectors.toList())
        );
        update();
    }

    public void clearAuthorities() {
        getApiData().getAuthorities().clear();
        update();
    }

    @Override
    protected ParameterizedTypeReference<UserApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<UserApiData>() {
        };
    }

    @Override
    protected Class<UserApiData> getResourceType() {
        return UserApiData.class;
    }
}
