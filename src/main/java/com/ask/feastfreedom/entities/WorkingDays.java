package com.ask.feastfreedom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "_workingdays")
public class WorkingDays {
    public WorkingDays(Kitchen kitchen, String _day, String _from, String _to){
        this.kitchen = kitchen;
        this._day = _day;
        this._from = _from;
        this._to = _to;
    }

    public WorkingDays(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String _day;
    private String _from;
    private String _to;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kitchenid", nullable = false)
    private Kitchen kitchen;

//==========================================================================
//                    GETTERS AND SETTERS
//==========================================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return _day;
    }

    public void setDay(String day) {
        this._day = day;
    }

    public String getFrom() {
        return _from;
    }

    public void setFrom(String from) {
        this._from = from;
    }

    public String getTo() {
        return _to;
    }

    public void setTo(String to) {
        this._to = to;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}

