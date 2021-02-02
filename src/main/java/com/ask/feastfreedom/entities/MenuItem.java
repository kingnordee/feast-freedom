package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "MenuItemTable")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean veg;
    private float price;
    private String image;

    @ManyToOne
    @JsonIgnore
    private Kitchen kitchen;

    @ManyToOne
    @JsonIgnore
    private Order order;

    public MenuItem(Long id, String name, boolean veg, float price, String image) {
        super();
        this.id = id;
        this.name = name;
        this.veg = veg;
        this.price = price;
        this.image = image;
    }

    public MenuItem() {

    }

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

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
