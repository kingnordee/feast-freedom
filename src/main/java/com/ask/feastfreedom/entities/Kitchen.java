package com.ask.feastfreedom.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "Kitchen123")
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "menu_item_id", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<MenuItem> menuItems;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<Order> orders;

    private String name;
    private String email;
    private String password;
    private Date working_days;

    public Kitchen() {
        this.menuItems = new HashSet<>();
        this.orders = new HashSet<>();
    }

    public Kitchen(Long id, String name, String email, String password,
                   Date working_days, String image) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.working_days = working_days;
        this.image = image;

    }

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

    public Date getWorking_days() {
        return working_days;
    }

    public void setWorking_days(Date working_days) {
        this.working_days = working_days;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

}
