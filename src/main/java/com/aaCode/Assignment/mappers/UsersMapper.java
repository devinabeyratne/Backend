package com.aaCode.Assignment.mappers;

import com.aaCode.Assignment.dto.UsersDTO;
import com.aaCode.Assignment.dto.requestDTO.RegistrationOrLoginAdminsDTO;
import com.aaCode.Assignment.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public Users dtoToEntityForRegOrLogin(RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        return new Users(
                registrationOrLoginAdminsDTO.email(),
                registrationOrLoginAdminsDTO.name(),
                registrationOrLoginAdminsDTO.password(),
                registrationOrLoginAdminsDTO.role()
        );
    }

    public UsersDTO EntityToDTO(Users user){
        return new UsersDTO(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }
}
