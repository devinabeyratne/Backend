package com.aaCode.Assignment.mappers;

import com.aaCode.Assignment.dto.TokenDTO;
import com.aaCode.Assignment.entity.Roles;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public TokenDTO tokenDTO(String token, Long id, String email, String name, Roles role){
        return new TokenDTO(
                token,
                id,
                email,
                name,
                role
        );
    }
}
