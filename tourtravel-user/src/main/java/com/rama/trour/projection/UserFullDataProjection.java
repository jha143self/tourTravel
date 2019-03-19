package com.rama.trour.projection;
import com.rama.api.enums.UserProjections;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.hateoas.Identifiable;

import com.rama.trour.model.Authority;
import com.rama.trour.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author Rakesh Jha
 */
@Projection(name = UserProjections.Values.USER_FULL_DATA, types = User.class)
public interface UserFullDataProjection extends Identifiable<Long> {

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();

    String getUsername();

    String getRememberMeToken();

    String getRegistrationConfirmationToken();

    LocalDate getRegistrationDate();

    LocalDateTime getLastLogin();

    String getEmail();

    String getPassword();

    Collection<Authority> getAuthorities();
}
