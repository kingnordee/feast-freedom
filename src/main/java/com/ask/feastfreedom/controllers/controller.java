package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.Order;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.entities.WorkingDays;
import com.ask.feastfreedom.repos.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class controller {

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

    //==========================================================================
//                    KITCHEN
//==========================================================================
    @GetMapping("/")
    public ResponseEntity<Iterable<Kitchen>> home() {
        try {
            return new ResponseEntity<>(kitchenRepo.findAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            System.out.println(e + " In home endpoint");
            return null;
        }
    }

    @GetMapping("/kitchen/{id}")
    public ResponseEntity<Kitchen> kitchen(@PathVariable Long id) {
        try {
            Kitchen kitchen = kitchenRepo.findById(id).get();
            return new ResponseEntity<>(kitchen, HttpStatus.FOUND);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/kitchen_registration")
    public ResponseEntity<Kitchen> kitchen_registration(@RequestBody Kitchen kitchen) {
        try {
            Kitchen newKitchen = kitchenRepo.save(kitchen);
            return new ResponseEntity<>(newKitchen, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //==========================================================================
//                    USER
//==========================================================================
    @PostMapping("/user_signup")
    public ResponseEntity<User> user_signup(@RequestBody User user) {
        try {
            User newUser = userRepo.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user_login")
    public ResponseEntity<User> user_login(@RequestBody Map<String, String> info) {
        try {
            User user = userRepo.userLogin(info.get("email"), info.get("password"));
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //==========================================================================
//                    WORKING DAYS
//==========================================================================
    @PostMapping("/add_day")
    public ResponseEntity<WorkingDays> add_day(@RequestBody WorkingDays day) {
        try {
            WorkingDays newDay = workingDaysRepo.save(day);
            return new ResponseEntity<>(newDay, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //==========================================================================
//                    ORDER
//==========================================================================
    @PostMapping("/place_order")
    public ResponseEntity<Order> place_order(@RequestBody Order order) {
        try {
            Order newOrder = orderRepo.save(order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
//==========================================================================
//                    MENU ITEMS
//==========================================================================
}
//    git checkout -t <name of remote>/test
