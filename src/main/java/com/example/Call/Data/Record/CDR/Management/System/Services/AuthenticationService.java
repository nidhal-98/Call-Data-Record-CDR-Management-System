package com.example.Call.Data.Record.CDR.Management.System.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username,String password) {
        boolean isValidUserName = username.equalsIgnoreCase("john");
        boolean isValidPassword = password.equalsIgnoreCase("1234");


        return isValidUserName && isValidPassword;
    }
}
