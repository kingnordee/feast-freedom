package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class WorkingDays {
    public WorkingDays(Kitchen kitchen, String day, String from, String to){
        this.kitchen = kitchen;
        this.day = day;
        this.from = from;
        this.to = to;
    }

    public WorkingDays(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String day;
    String from;
    String to;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Kitchen kitchen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

}

