package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class KitchenControl {

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

    @GetMapping("/")
    public Iterable<Kitchen> home() {
        try {
            return kitchenRepo.findAll();
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

}
