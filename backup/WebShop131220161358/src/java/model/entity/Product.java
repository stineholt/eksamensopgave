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
public class Product {
    private int id;
    private String produktname;
    private String kategori;
    private String description;
    private String size;
    private String pris;
    private String leveringstid;
    
    public Product() {
    }

    public Product(int id, String produktname, String kategori, String description, String size, String pris, String leveringstid) {
        this.id = id;
        this.produktname = produktname;
        this.kategori = kategori;
        this.description = description;
        this.size = size;
        this.pris = pris;
        this.leveringstid = leveringstid;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public String getLeveringstid() {
        return leveringstid;
    }

    public void setLeveringstid(String leveringstid) {
        this.leveringstid = leveringstid;
    }
    
    
    
}
