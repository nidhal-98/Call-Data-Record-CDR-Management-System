package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.User;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }
}
