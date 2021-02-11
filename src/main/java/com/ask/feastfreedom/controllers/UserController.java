package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class UserController {

    @Autowired
    KitchenRepo kitchenRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MenuItemRepo menuItemRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    WorkingDaysRepo workingDaysRepo;

    @PostMapping("/user_signup")
    public User user_signup(@RequestBody User user) {
        try {
            return userRepo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/user_login")
    public User user_login(@RequestBody Map<String, String> info) {
        try {
            User user =  userRepo.userLogin(info.get("email"), info.get("password"));
            System.out.println(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
