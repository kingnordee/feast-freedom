package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OrderTable")
public class Order {//CLASS BEGINS
    public Order(Kitchen kitchen, User user, Date orderTime, float amountPaid){
        this.kitchen = kitchen;
        this.user = user;
        this.orderTime = orderTime;
        this.amountPaid = amountPaid;
        this.menuItems = new HashSet<>();
    }

    public Order(){
        this.menuItems = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<MenuItem> menuItems;

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

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
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
