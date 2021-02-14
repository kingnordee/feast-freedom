package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.Kitchen;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
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
//    public MenuItem add_menu_item(@RequestBody Map<String,String> menu, @PathVariable Long kitchenId){
//        try {
//            Kitchen kitchen = kitchenRepo.findById(kitchenId).get();
//
//            MenuItem menuItem = new MenuItem(kitchen, menu.get("name"), Boolean.parseBoolean(menu.get("veg")),
//                    Float.parseFloat(menu.get("price")), menu.get("image"));
//
//            return menuItemRepo.save(menuItem);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
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

    @GetMapping("/get_menu_items/{kitchenId}")
    public Kitchen get_menu_items(@PathVariable Long kitchenId){
        try {
            return kitchenRepo.findById(kitchenId).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
