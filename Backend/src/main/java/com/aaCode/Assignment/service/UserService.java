package com.aaCode.Assignment.service;

import com.aaCode.Assignment.dao.UsersDAO;
import com.aaCode.Assignment.dto.TokenDTO;
import com.aaCode.Assignment.dto.UsersDTO;
import com.aaCode.Assignment.dto.requestDTO.RegistrationOrLoginAdminsDTO;
import com.aaCode.Assignment.entity.Users;
import com.aaCode.Assignment.mappers.TokenMapper;
import com.aaCode.Assignment.mappers.UsersMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersDAO usersDAO;
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final TokenMapper tokenMapper;
    private final AuthenticationManager authenticationManager;

    public UserService(UsersDAO usersDAO, UsersMapper usersMapper, PasswordEncoder passwordEncoder, JWTService jwtService, TokenMapper tokenMapper, AuthenticationManager authenticationManager) {
        this.usersDAO = usersDAO;
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenMapper = tokenMapper;
        this.authenticationManager = authenticationManager;
    }

    public TokenDTO createUsers(RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        Users admin = usersMapper.dtoToEntityForRegOrLogin(registrationOrLoginAdminsDTO);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole(registrationOrLoginAdminsDTO.role());
        Users createAdmin = usersDAO.createUsers(admin);

        return tokenMapper.tokenDTO(
                jwtService.generateToken(admin),
                createAdmin.getId(),
                createAdmin.getEmail(),
                createAdmin.getName(),
                createAdmin.getRole()
        );
    }

    public List<UsersDTO> getAllAdmins(){
        return usersDAO.getAllUsers().stream().map(usersMapper::EntityToDTO).toList();
    }

    public TokenDTO loginAdmin(RegistrationOrLoginAdminsDTO registrationOrLoginAdminsDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registrationOrLoginAdminsDTO.email(),
                        registrationOrLoginAdminsDTO.password()
                )
        );

        List<Users> admins = usersDAO.getAllUsersByEmail(registrationOrLoginAdminsDTO.email());
        String token = jwtService.generateToken(admins.get(0));

        return tokenMapper.tokenDTO(
                token,
                admins.get(0).getId(),
                admins.get(0).getEmail(),
                admins.get(0).getName(),
                admins.get(0).getRole()
        );
    }
}
