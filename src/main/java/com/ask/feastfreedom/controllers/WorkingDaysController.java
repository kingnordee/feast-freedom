package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.entities.*;
import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            return workingDaysRepo.save(
                    new WorkingDays(kitchen, day.get("_day"), day.get("_from"), day.get("_to")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/add_days/{kitchenId}")
    public HttpStatus add_days(@RequestBody List<Map<String, String>> day, @PathVariable Long kitchenId) {
        try {
            Kitchen kitchen = kitchenRepo.findById(kitchenId).get();
            for(Map<String, String> d : day){
                workingDaysRepo.save(
                        new WorkingDays(
                                kitchen, d.get("_day"), d.get("_from"), d.get("_to")
                        ));
            }
            return HttpStatus.CREATED;
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.EXPECTATION_FAILED;
        }
    }

}
//    git checkout -t <name of remote>/test
