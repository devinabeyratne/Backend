package com.aaCode.Assignment.dto;

import com.aaCode.Assignment.entity.Roles;

public record TokenDTO(String token, Long id, String email, String name, Roles role) {
}
