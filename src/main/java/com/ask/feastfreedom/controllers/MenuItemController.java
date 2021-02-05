package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MenuItemController {

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

    @PostMapping("/add_menu_item/{kitchenId}")
    public MenuItem add_menu_item(@RequestBody MenuItem menuItem, @PathVariable Long kitchenId){
        try {
            Kitchen kitchen = kitchenRepo.findById(kitchenId).get();
            menuItem.setKitchen(kitchen);
            return menuItemRepo.save(menuItem);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
