package com.tweteroo.tweteroo.dtos;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
        @NotBlank String username, @NotBlank String tweet) {

}
