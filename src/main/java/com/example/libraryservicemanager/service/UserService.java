package com.example.libraryservicemanager.service;


import com.example.libraryservicemanager.model.RoleEntity;
import com.example.libraryservicemanager.model.enumeration.LoginType;

import java.util.*;

public interface UserService {

    void createUser(String firstname,String lastname,String email,String password);

    RoleEntity getRoleName(String name);

    void verifyAccount(String key);

    void updateLoginAttempt(String email, LoginType loginType);
}
