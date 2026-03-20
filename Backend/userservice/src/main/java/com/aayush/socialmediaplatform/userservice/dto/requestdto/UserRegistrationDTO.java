package com.aayush.socialmediaplatform.userservice.dto.requestdto;

import com.aayush.socialmediaplatform.userservice.entity.enums.Gender;
import com.aayush.socialmediaplatform.userservice.util.customValidator.PasswordMatches;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PasswordMatches
public class UserRegistrationDTO {
    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Size(min = 6, message = "Username must be at least 6 characters")
    @Size(max = 24, message = "Username must not exceed 24 characters")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z0-9]*$",
            message = "Username must contain only letters and numbers and first character should be capital letter"
    )

    private String userName;
    @NotBlank(message = "Email is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
    private String email;
    private Date dob;
    private Gender gender;
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Size(max = 14, message = "Password must not exceed 14 characters")
    @Pattern(
            regexp = "^[a-zA-Z0-9]+$",
            message = "Password must contain only letters and numbers"
    )
    private String password;
    private String confirmPassword;



}
