package com.aaCode.Assignment.dao;

import com.aaCode.Assignment.entity.Users;
import com.aaCode.Assignment.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDAO {

    private final UserRepo userRepo;

    //constructor parameter
    public UsersDAO(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Users createUsers(Users admin){
        return userRepo.save(admin);
    }

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

    public List<Users> getAllUsersByEmail(String email){
        return userRepo.findByEmail(email);
    }
}
