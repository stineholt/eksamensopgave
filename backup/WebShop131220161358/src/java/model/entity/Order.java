/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author sbh
 */
public class Order {
    private int id;
    private String username;
    private Date date;
    private boolean bestilt;

    public Order(int id, String username, Date date, boolean bestilt) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.bestilt = bestilt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isBestilt() {
        return bestilt;
    }

    public void setBestilt(boolean bestilt) {
        this.bestilt = bestilt;
    }
    
    
    
}
