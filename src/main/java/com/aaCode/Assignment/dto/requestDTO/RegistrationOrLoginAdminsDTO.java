package com.aaCode.Assignment.dto.requestDTO;

import com.aaCode.Assignment.entity.Roles;

public record RegistrationOrLoginAdminsDTO(String email, String name, String password, Roles role) {
}
