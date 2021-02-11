package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.entities.Order;
import com.ask.feastfreedom.entities.User;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
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
    public Order place_order(@RequestBody Map<String, String> info)  {
        try {
            Kitchen kitchen = kitchenRepo.findById(Long.parseLong(info.get("kitchenId"))).get();
            User user = userRepo.findById(Long.parseLong(info.get("userId"))).get();
            String[] menuItemsIds = info.get("menuItemsIds").split(",");
            System.out.println(Arrays.toString(menuItemsIds));
            System.out.println(info.get("menuItemsIds"));

            List<MenuItem> menuItems = new ArrayList<>();
            float orderTotal = 0.0f;

            for(String id : menuItemsIds){
                Long numId = Long.parseLong(id);
                MenuItem menuItem = menuItemRepo.findById(numId).get();
                menuItems.add(menuItem);
                orderTotal += menuItem.getPrice();
            }

            Order order = new Order(kitchen,user,new Date(),menuItems, orderTotal);
            return orderRepo.save(order);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @GetMapping("/get_order/{userId}")
//    public List<Order> place_order(@PathVariable Long userId)  {
//        try {
////            User user = userRepo.findById(userId).get();
//            return orderRepo.findByUserId(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @GetMapping("/get_order/{userId}")
    public Set<Order> place_order(@PathVariable Long userId)  {
        try {
            return userRepo.findById(userId).get().getOrder();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
