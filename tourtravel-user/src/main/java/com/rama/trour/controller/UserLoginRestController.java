package com.rama.trour.controller;
import com.rama.api._internal.RestApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rama.trour.model.User;
import com.rama.trour.service.UserService;

import java.time.LocalDateTime;

/**
 * @author Rakesh Jha
 */
@RestController
@RequestMapping("/" + RestApiConstants.LOGIN_USER_RESOURCE)
public class UserLoginRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userId}", method = RequestMethod.POST)
    public ResponseEntity loginUser(@PathVariable Long userId) {
        User user = userService.findById(userId);

        if (user == null ||
                !user.isEnabled() ||
                !user.isAccountNonExpired() ||
                !user.isAccountNonLocked() ||
                !user.isCredentialsNonExpired()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        user.setLastLogin(LocalDateTime.now());
        userService.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }
}
