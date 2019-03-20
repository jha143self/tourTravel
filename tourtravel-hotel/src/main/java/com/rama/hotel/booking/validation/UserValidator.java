package com.rama.hotel.booking.validation;

import static com.rama.hotel.booking.utils.InputValidatorHelpers.isHtmlSafe;

//import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rama.hotel.booking.model.User;

@Component("userValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports( Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate( Object target,  Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "user.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "user.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.empty");

        // check for field injection
        if (isHtmlSafe(user.getFirstName())) {
            errors.rejectValue("firstName", "field.notallowed");
        }
        if (isHtmlSafe(user.getLastName())) {
            errors.rejectValue("lastName", "field.notallowed");
        }
        if (isHtmlSafe(user.getUsername())) {
            errors.rejectValue("username", "field.notallowed");
        }
//        if (isHtmlSafe(user.getEmail())) {
//            errors.rejectValue("email", "field.notallowed");
//        }
        if (!user.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email", "user.email.invalid");
        }
    }
}
