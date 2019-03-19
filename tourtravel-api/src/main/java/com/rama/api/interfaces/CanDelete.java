package com.rama.api.interfaces;


import org.springframework.web.client.RestClientException;

import com.rama.api._internal.model.AbstractBaseApiData;

/**
 * Interface to indicate that a paged resource ({@link info.rolandkrueger.userservice.api._internal.AbstractPagedResource})
 * supports deleting existing entities via DELETE.
 *
 * @param <T> the entity type which must be a subclass of {@link AbstractBaseApiData}
 * @author Rakesh Jha
 */
public interface CanDelete<T extends AbstractBaseApiData> {
    /**
     * Deletes an existing entity.
     *
     * @param entity entity to be deleted
     * @throws RestClientException when an error has occurred while communicating with the service
     */
    void delete(T entity) throws RestClientException;
}
