package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.entities.WorkingDays;
import com.ask.feastfreedom.repos.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        try{
            return new ResponseEntity<>(kitchenRepo.findAll(), HttpStatus.FOUND);
        }catch (Exception e){
            System.out.println(e + " In home endpoint");
            return null;
        }
    }

    @GetMapping("/kitchen/{id}")
    public String kitchen(@PathVariable String id) {
        return "Kitchen: " + id;
    }

    @PostMapping("/kitchen_registration")
    public ResponseEntity<Kitchen> kitchen_registration(@RequestBody Kitchen kitchen) {
        try{
            Kitchen newKitchen = kitchenRepo.save(kitchen);
            return new ResponseEntity<>(newKitchen, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

//==========================================================================
//                    USER
//==========================================================================
    @PostMapping("/user_signup")
    public String user_signup(@RequestBody User user) {
        return "User Registration (auto logs in)";
    }

    @PostMapping("/user_login")
    public String user_login(@RequestBody Map<String, String> info) {
        return "User Login";
    }

//==========================================================================
//                    WORKING DAYS
//==========================================================================

//==========================================================================
//                    ORDER
//==========================================================================

//==========================================================================
//                    MENU ITEMS
//==========================================================================
}
//    git checkout -t <name of remote>/test
