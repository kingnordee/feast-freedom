package com.ask.feastfreedom.entities;

import javax.persistence.*;

@Entity
//@Table(name = "User123")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String image;
    private String securityQ;
    private int phone;
    private float cart;

    public User(Long id, String fname, String lname, String email, String password, String image, String securityQ,
                int phone, float cart) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.image = image;
        this.securityQ = securityQ;
        this.phone = phone;
        this.cart = cart;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSecurityQ() {
        return securityQ;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ = securityQ;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public float getCart() {
        return cart;
    }

    public void setCart(float cart) {
        this.cart = cart;
    }

}