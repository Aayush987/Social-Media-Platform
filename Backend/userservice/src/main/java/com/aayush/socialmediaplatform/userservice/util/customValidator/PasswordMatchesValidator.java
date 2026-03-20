package com.aayush.socialmediaplatform.userservice.util.customValidator;

import com.aayush.socialmediaplatform.userservice.dto.requestdto.UserRegistrationDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistrationDTO> {
    @Override
    public boolean isValid(UserRegistrationDTO dto, ConstraintValidatorContext context) {

        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return false;
        }

        boolean matches = dto.getPassword().equals(dto.getConfirmPassword());

        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return matches;
    }
}
