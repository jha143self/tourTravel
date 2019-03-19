package com.rama.api.enums;

/**
 * Enum to specify sort-by semantics for the user resource.
 *
 * @author Rakesh Jha
 */
public enum UsersSort {
    USERNAME("username"), EMAIL("email"), FULLNAME("fullname");

    private String property;

    /**
     * @param property name of the {@link com.rama.api.model.UserApiData} property to sort after
     */
    UsersSort(String property) {
        this.property = property;
    }

    /**
     * Resolves enum constant to domain type property.
     */
    public String getProperty() {
        return property;
    }
}
