package com.rama.hotel.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rama.hotel.booking.model.UserProfile;
import com.rama.hotel.booking.repository.UserProfileRepository;

@Service("userProfileService")
@Transactional
public class UserProfileService {

    @Autowired
    UserProfileRepository dao;

    public UserProfile findById(int id) {
        Optional<UserProfile> tmp = dao.findById(id);
        return tmp.orElse(null);
    }

    public UserProfile findByType(String type) {
        return dao.findByType(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}
