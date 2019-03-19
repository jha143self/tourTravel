package com.rama.api.interfaces;

import org.springframework.web.client.RestClientException;

/**
 * Interface to indicate that a resource supports deleting existing entities via DELETE.
 *
 * @author Rakesh Jha
 */
public interface CanDeleteResource {

    /**
     * Deletes this resource.
     *
     * @throws RestClientException when an error has occurred while communicating with the service
     */
    void delete() throws RestClientException;
}
