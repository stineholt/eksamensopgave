/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import model.entity.Product;
import model.entity.ProductByOrder;

/**
 *
 * @author sbh
 */
public class DataFacade {
    
    UserMapper um = new UserMapper();
    OrderMapper om = new OrderMapper();
    ProduktMapper pm = new ProduktMapper();

    
    public void createUser (String username, String password, String fornavn, String efternavn, String email, String mobil, String adresse, String postnr) throws PasswordStorage.CannotPerformOperationException{
        um.createUser(username, password, fornavn, efternavn, email, mobil, adresse, postnr);
    }
    
    public boolean authenticateUser(String username, String password) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException{
        return um.authenticateUser(username, password);
    }
    
    public void newOrder(String username, Date date){
        om.newOrder(username, date);
    }
    
    public int getOrderID (String username){
        return om.getOrderID(username);
    }
    
    public void closeOrder (String orderid){
        om.closeOrder(orderid);
    }
    
    public ArrayList<Product> getAllProducts(){
        return pm.getAllProducts();
    }
    
    public void placeProduktForPurchase(String orderid, String produktid) {
        pm.placeProduktForPurchase(orderid, produktid);
    }
    
    public ArrayList<Product> getProductDetails(String produktid){
        return pm.getProductDetails(produktid);
    }
    
    public ArrayList<ProductByOrder> getAllPurchaseByUser(String username, String orderid){
        return pm.getAllPurchaseByUser(username, orderid);
    }
    
    public String getPrisForPurchase(String username, String orderid){
        return pm.getPrisForPurchase(username, orderid);
    }
    
    
    
}
