package com.rama.api.resources;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.client.RestClientException;

import com.rama.api._internal.AbstractPagedResource;
import com.rama.api._internal.RestApiConstants;
import com.rama.api.enums.SortDirection;
import com.rama.api.enums.UserProjections;
import com.rama.api.enums.UsersSort;
import com.rama.api.interfaces.CanDelete;
import com.rama.api.interfaces.CanUpdate;
import com.rama.api.model.UserApiData;

/**
 * @author Rakesh Jha
 */
public class UsersResource extends AbstractPagedResource<UserApiData, UsersResource> implements
        CanUpdate<UserApiData>, CanDelete<UserApiData> {

    UsersResource(Link self) {
        this(self, self);
    }

    UsersResource(Link templatedBaseLink, Link self) {
        super(templatedBaseLink, self);
    }

    public final UsersResource sort(UsersSort sortBy, SortDirection direction) {
        return sort(getSortByProperty(sortBy), direction);
    }

    public final UsersResource useProjection(UserProjections projection) {
        return new UsersResource(getProjectionLink(templatedSelfLink, projection.getName()));
    }

    public final UsersResource goToPageSorted(Integer page, Integer size, UsersSort sortBy, SortDirection
            direction) {
        return goToPageSorted(page, size, getSortByProperty(sortBy), direction);
    }

    public final UsersSearchResource search() {
        return new UsersSearchResource(getLinkFor(getResponseEntity(), RestApiConstants.SEARCH_RESOURCE));
    }

    @Override
    protected UsersResource createResourceInstance(Link self) {
        return new UsersResource(self);
    }

    @Override
    protected Class<UserApiData> getResourceType() {
        return UserApiData.class;
    }

    @Override
    protected ParameterizedTypeReference<PagedResources<UserApiData>> getParameterizedTypeReferencePaged() {
        return new ParameterizedTypeReference<PagedResources<UserApiData>>() {
        };
    }

    @Override
    protected ParameterizedTypeReference<UserApiData> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<UserApiData>() {
        };
    }

    @Override
    public void delete(UserApiData entity) throws RestClientException {
        deleteInternal(entity);
    }

    @Override
    public void update(UserApiData entity) throws RestClientException {
        updateInternal(entity);
    }

    private String getSortByProperty(UsersSort sortBy) {
        return sortBy == null ? null : sortBy.getProperty();
    }
}
