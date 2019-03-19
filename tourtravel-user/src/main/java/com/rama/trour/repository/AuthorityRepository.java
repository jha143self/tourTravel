package com.rama.trour.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import com.rama.api._internal.RestApiConstants;
import com.rama.trour.model.Authority;

public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {
    Authority findByAuthority(@Param(RestApiConstants.AUTHORITY_PARAM) String authority);

    @RestResource(exported = false)
    @Override Iterable<Authority> findAll();
}
