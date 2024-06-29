package com.ps.demo2.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotBlank(message = "{username.required}")
    @Size(min = 3, max = 50, message = "{username.valid}")
    private String username;

    @NotBlank(message = "{password.required}")
    @Size(min = 8, message = "{password.size}")
    // @Pattern(regexp =
    // "^.(?=.{8,})(?=..[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=]).$", message =
    // "{password.valid}")
    private String password;

    @NotBlank(message = "{firstName.required}")
    @Size(min = 1, max = 50, message = "{firstName.valid}")
    private String firstName;

    @NotBlank(message = "{lastName.required}")
    @Size(min = 1, max = 50, message = "{lastName.valid}")
    private String lastName;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.valid}")
    private String email;

    @NotBlank(message = "{phoneNumber.required}")
    @Pattern(regexp = "(\\+\\d{1,3}[-.\\s]?)?(\\(?\\d{1,4}\\)?[-.\\s]?)?(\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9})", message = "{phoneNumber.valid}")
    private String phoneNumber;

}