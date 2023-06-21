package com.example.Call.Data.Record.CDR.Management.System.Services;

import com.example.Call.Data.Record.CDR.Management.System.Models.User;
import com.example.Call.Data.Record.CDR.Management.System.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }

    public User getLastAddedUser() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return users.get(users.size() - 1);
        } else {
            throw new NoSuchElementException("No users found");
        }
    }
}
