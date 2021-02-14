package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class KitchenController {

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
    public Kitchen kitchen(@PathVariable Long id) {
        try {
            return kitchenRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/kitchen/{id}/menu_items")
    public Set<MenuItem> kitchen_menu_items(@PathVariable Long id) {
        try {
            return kitchenRepo.findById(id).get().getMenuItems();
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

    @PostMapping("/kitchen_login")
    public Kitchen user_login(@RequestBody Map<String, String> info) {
        try {
            Kitchen kitchen =  kitchenRepo.kitchenLogin(info.get("email"), info.get("password"));
            return kitchen;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/delete_kitchen/{kitchenId}")
    public HttpStatus delete_user(@PathVariable Long kitchenId) {
        try {
            kitchenRepo.deleteById(kitchenId);
            return HttpStatus.GONE;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

    @GetMapping("/kitchen_name/{menuItemId}")
    public String kitchen_name(@PathVariable Long menuItemId) {
        try {
            return menuItemRepo.findById(menuItemId).get().getKitchen().getName();
        } catch (Exception e) {
            return null;
        }
    }

}
