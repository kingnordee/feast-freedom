package com.ask.feastfreedom.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KitchenTable")
public class Kitchen {
    public Kitchen(String name, String email, String password, String image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
        this.orders = new HashSet<>();
        this.menuItems = new HashSet<>();
        this.working_days = new HashSet<>();
    }

    public Kitchen() {
        this.orders = new HashSet<>();
        this.menuItems = new HashSet<>();
        this.working_days = new HashSet<>();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String image;

    @OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<WorkingDays> working_days;

    @OneToMany(mappedBy = "kitchen", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<MenuItem> menuItems;

//==========================================================================
//                    GETTERS AND SETTERS
//==========================================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<WorkingDays> getWorking_days() {
        return working_days;
    }

    public void setWorking_days(Set<WorkingDays> working_days) {
        this.working_days = working_days;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
