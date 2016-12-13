/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author sbh
 */
public class ProductByOrder {
    private int orderid;
    private String username;
    private String produktname;
    private String pris;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public ProductByOrder(int orderid, String username, String produktname, String pris) {
        this.orderid = orderid;
        this.username = username;
        this.produktname = produktname;
        this.pris = pris;
    }
    public ProductByOrder(){
        
    }
}
