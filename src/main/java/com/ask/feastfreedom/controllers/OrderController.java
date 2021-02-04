package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.entities.Order;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrderController {
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

    @PostMapping("/place_order")
    public ResponseEntity<Order> place_order(@RequestBody Map<String, String> info)  {
        try {
            Kitchen kitchen = kitchenRepo.findById(Long.parseLong(info.get("kitchenId"))).get();
            User user = userRepo.findById(Long.parseLong(info.get("userId"))).get();
            String[] menuItemsIds = info.get("menuItemsIds").split(",");

            Set<MenuItem> menuItems = new HashSet<>();
            float orderTotal = 0.0f;

            for(String id : menuItemsIds){
                Long numId = Long.parseLong(id);
                MenuItem menuItem = menuItemRepo.findById(numId).get();
                menuItems.add(menuItem);
                orderTotal += menuItem.getPrice();
            }

            Order order = new Order(kitchen,user,new Date(),menuItems, orderTotal);
            orderRepo.save(order);

            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
