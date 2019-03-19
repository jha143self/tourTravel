package com.rama.trour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rama.trour.model.User;
import com.rama.trour.repository.UserRepository;
import com.rama.trour.service.UserService;

import java.util.List;

/**
 * @author Rakesh Jha
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByRegistrationConfirmationToken(String confirmationToken) {
        return userRepository.findByRegistrationConfirmationToken(confirmationToken);
    }

    @Override
    public List<User> getUserList(int page, int size,  Sort.Direction sort) {
        return userRepository.findAll(new PageRequest(page, size, sort, "username")).getContent();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findOne(userId);
    }
}
