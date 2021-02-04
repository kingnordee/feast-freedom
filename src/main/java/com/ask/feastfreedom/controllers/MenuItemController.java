package com.ask.feastfreedom.controllers;

import com.ask.feastfreedom.repos.*;
import org.springframework.beans.factory.annotation.Autowired;

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

}
