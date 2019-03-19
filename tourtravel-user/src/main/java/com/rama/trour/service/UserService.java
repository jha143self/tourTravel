package com.rama.trour.service;

import org.springframework.data.domain.Sort;

import com.rama.trour.model.User;

import java.util.List;

/**
 * @author Rakesh Jha
 */
public interface UserService {

    User findUserByUsername(String username);

    User findByRegistrationConfirmationToken(String confirmationToken);

    List<User> getUserList(int page, int size, Sort.Direction sort);

    void delete(Long id);

    User save(User user);

    User findById(Long userId);
}
