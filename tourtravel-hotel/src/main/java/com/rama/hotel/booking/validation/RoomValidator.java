package com.rama.hotel.booking.validation;

import static com.rama.hotel.booking.utils.InputValidatorHelpers.isHtmlSafe;

//import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rama.hotel.booking.model.Room;

@Component("roomValidator")
public class RoomValidator implements Validator {

    @Override
    public boolean supports( Class<?> clazz) {
        return Room.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate( Object target,  Errors errors) {
        Room room = (Room) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "room.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "price", "room.price.empty");
        ValidationUtils.rejectIfEmpty(errors, "capacity", "room.capacity.empty");

        // check for field injection
        if (isHtmlSafe(room.getDescription())) {
            errors.rejectValue("description", "field.notallowed");
        }
        if (isHtmlSafe(room.getName())) {
            errors.rejectValue("name", "field.notallowed");
        }
        //room.getBed().toString()
        Integer ids=room.getBed();

        if (isHtmlSafe(ids.toString())) {
            errors.rejectValue("bed", "field.notallowed");
        }
        //room.getCapacity().toString()
        Integer bed=room.getBed();
        if (isHtmlSafe(bed.toString())) {
            errors.rejectValue("capacity", "field.notallowed");
        }
        //room.getPrice().toString()
        Integer price=room.getBed();
        if (isHtmlSafe(price.toString())) {
            errors.rejectValue("price", "field.notallowed");
        }
    }
}
