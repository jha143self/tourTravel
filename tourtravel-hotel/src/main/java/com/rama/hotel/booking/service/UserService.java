package com.rama.hotel.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rama.hotel.booking.model.User;
import com.rama.hotel.booking.repository.UserRepository;
import com.rama.hotel.booking.utils.Constant;

@Service("UserService")
@Transactional
public class UserService {

    @Autowired
    private UserRepository dao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

   
    public User findById(final int id) {
        Optional<User> tmp = dao.findById(id);
        return tmp.orElse(null);
    }

    public User findByUsername(String username) {
        return dao.findByUsername(username).orElse(null);
    }

    public User findByEmail(String email) {
        return dao.findByEmail(email).orElse(null);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        Optional<User> entity = dao.findById(user.getId());
        if (entity.isPresent()) {
            user.setId(entity.get().getId());
            dao.save(user);
        }
    }

    public void deleteUserByUsername(String username) {
        dao.deleteByUsername(username);
    }

    public List<User> findAllUsers() {
        return dao.findAll();
    }

    public boolean isUserUsernameUnique(Integer id, String username) {
        User user = findByUsername(username);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    public boolean isUserEmailUnique(Integer id, String email) {
        User user = findByEmail(email);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    public List<User> findAllManagers() {
        List<Integer> ids = dao.findByRole(Constant.USER_ROLE.MANAGER);
        List<User> users = new ArrayList<>();
        for (Integer id : ids) users.add(findById(id));
        return users;
    }

    public List<User> findAllCustomers() {
        List<Integer> ids = dao.findByRole(Constant.USER_ROLE.VERIFIED);
        List<User> users = new ArrayList<>();
        for (Integer id : ids) users.add(findById(id));
        return users;
    }

    public List<User> findAllAdmins() {
        List<Integer> ids = dao.findByRole(Constant.USER_ROLE.ADMIN);
        List<User> users = new ArrayList<>();
        for (Integer id : ids) users.add(findById(id));
        return users;
    }

//    public static User fromSocialUserProfile(@NotNull UserProfile userProfile) {
//        User user = new User();
//        user.setEmail(userProfile.getEmail());
//        user.setFirstName(userProfile.getFirstName());
//        user.setLastName(userProfile.getLastName());
//        return user;
//    }
}
