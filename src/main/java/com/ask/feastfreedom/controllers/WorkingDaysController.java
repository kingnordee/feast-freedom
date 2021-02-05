package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.*;
import com.ask.feastfreedom.entities.MenuItem;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/add_day/{kitchenId}")
    public WorkingDays add_day(@RequestBody Map<String, String> day, @PathVariable Long kitchenId) {
        try {
            Kitchen kitchen = kitchenRepo.findById(kitchenId).get();
//            day.setKitchen(kitchen);
            return workingDaysRepo.save(
                    new WorkingDays(kitchen, day.get("_day"), day.get("_from"), day.get("_to")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
//    git checkout -t <name of remote>/test
