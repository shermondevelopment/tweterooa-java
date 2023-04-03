package com.tweteroo.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
    @NotBlank String username,
    @Pattern(regexp = "^(?i)(https?:/{2})([a-z0-9+&@#/%?=~_!:,.;-]+)(.[png|bmp|jpe?g|gif])$", message = "Invalid avatar URL") @NotBlank String avatar) {

}
