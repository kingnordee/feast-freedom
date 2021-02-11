package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "_order")
public class Order {//CLASS BEGINS
    public Order(Kitchen kitchen, User user, Date orderTime, float amountPaid){
        this.kitchen = kitchen;
        this.user = user;
        this.orderTime = orderTime;
        this.amountPaid = amountPaid;
        this.menu_items = new ArrayList<>();
    }

    public Order(Kitchen kitchen, User user, Date orderTime, List<MenuItem>menuItems, float amountPaid){
        this.kitchen = kitchen;
        this.user = user;
        this.orderTime = orderTime;
        this.amountPaid = amountPaid;
        this.menu_items = menuItems;
    }

    public Order(){
        this.menu_items = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "_order_menuitem_",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<MenuItem> menu_items;

    @ManyToOne
    @JsonIgnore
    private Kitchen kitchen;

    @ManyToOne
    @JsonIgnore
    private User user;

    private Date orderTime;
    private float amountPaid;

//==========================================================================
//                    GETTERS AND SETTERS
//==========================================================================

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public List<MenuItem> getMenuItems() {
        return menu_items;
    }

    public void setMenuItems(MenuItem menuItem) {
        this.menu_items.add(menuItem);
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }
}
