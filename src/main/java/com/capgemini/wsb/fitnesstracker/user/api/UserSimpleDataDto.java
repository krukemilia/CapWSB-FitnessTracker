package com.capgemini.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

public record UserSimpleDataDto(@Nullable Long id, String firstName, String lastName, String email) {
}
