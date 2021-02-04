package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.*;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class WorkingDaysController {

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
//    @GetMapping("/")
//    public Iterable<Kitchen> home() {
//        try {
//            return kitchenRepo.findAll();
//        } catch (Exception e) {
//            System.out.println(e + " In home endpoint");
//            return null;
//        }
//    }
//
//    @GetMapping("/kitchen/{id}")
//    public ResponseEntity<Kitchen> kitchen(@PathVariable Long id) {
//        try {
//            Kitchen kitchen = kitchenRepo.findById(id).get();
//            return new ResponseEntity<>(kitchen, HttpStatus.FOUND);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @PostMapping("/kitchen_registration")
//    public ResponseEntity<Kitchen> kitchen_registration(@RequestBody Kitchen kitchen) {
//        try {
//            Kitchen newKitchen = kitchenRepo.save(kitchen);
//            return new ResponseEntity<>(newKitchen, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

//==========================================================================
//                    USER
//==========================================================================
//    @PostMapping("/user_signup")
//    public ResponseEntity<User> user_signup(@RequestBody User user) {
//        try {
//            User newUser = userRepo.save(user);
//            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping("/user_login")
//    public ResponseEntity<User> user_login(@RequestBody Map<String, String> info) {
//        try {
//            User user = userRepo.userLogin(info.get("email"), info.get("password"));
//            return new ResponseEntity<>(user, HttpStatus.FOUND);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

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
//    @PostMapping("/place_order")
//    public ResponseEntity<Order> place_order(@RequestBody Map<String, String> info)  {
//        try {
//            Kitchen kitchen = kitchenRepo.findById(Long.parseLong(info.get("kitchenId"))).get();
//            User user = userRepo.findById(Long.parseLong(info.get("userId"))).get();
//            String[] menuItemsIds = info.get("menuItemsIds").split(",");
//
//            Set<MenuItem> menuItems = new HashSet<>();
//            float orderTotal = 0.0f;
//
//            for(String id : menuItemsIds){
//                Long numId = Long.parseLong(id);
//                MenuItem menuItem = menuItemRepo.findById(numId).get();
//                menuItems.add(menuItem);
//                orderTotal += menuItem.getPrice();
//            }
//
//            Order order = new Order(kitchen,user,new Date(),menuItems, orderTotal);
//            orderRepo.save(order);
//
//            return new ResponseEntity<>(order, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//==========================================================================
//                    MENU ITEMS
//==========================================================================
//    @PostMapping("/add_menu_item/{kitchenId}")
//    public ResponseEntity<MenuItem> add_menu_item(@RequestBody MenuItem menuItem, @PathVariable Long kitchenId){
//        try {
//            Kitchen kitchen = kitchenRepo.findById(kitchenId).get();
//            menuItem.setKitchen(kitchen);
//            MenuItem newMenuItem = menuItemRepo.save(menuItem);
//            return new ResponseEntity<>(newMenuItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/order_items/{orderId}")
//    public ResponseEntity<Set<MenuItem>> order_items(@PathVariable Long orderId){
//        try {
//            Set<MenuItem> menuItems = orderRepo.findById(orderId).get().getMenuItems();
//            return new ResponseEntity<>(menuItems, HttpStatus.FOUND);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
}
//    git checkout -t <name of remote>/test
