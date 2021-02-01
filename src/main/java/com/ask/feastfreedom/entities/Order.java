package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.Set;

@Entity
//@Table(name = "Order123")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    Set<MenuItem> menuItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Kitchen kitchen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    User user;

    private Date orderTime;
    private float amountPaid;
}
