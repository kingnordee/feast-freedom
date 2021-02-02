package com.ask.feastfreedom.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "UserTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String lname;
    private String email;
    private String password;
    private String image;
    private Long phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<Order> order;

    public User(String fname, String lname, String email, String password, String image, Long phone) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.image = image;
        this.phone = phone;
    }

    public User() {

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
