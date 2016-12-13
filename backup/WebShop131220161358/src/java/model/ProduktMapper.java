/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.ProductByOrder;

/**
 *
 * @author sbh
 */
public class ProduktMapper {
    
    public ArrayList<Product> getAllProducts(){
        
        ArrayList<Product> listofProducts = new ArrayList<Product>();
        
        try{
            String sql = "SELECT id,name,kategori,description,size,pris,leveringstid FROM produkt";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product selectedProduct = new Product();
                
                selectedProduct.setId(rs.getInt("id"));
                selectedProduct.setProduktname(rs.getString("name"));
                selectedProduct.setKategori(rs.getString("kategori"));
                selectedProduct.setDescription(rs.getString("description"));
                selectedProduct.setSize(rs.getString("size"));
                selectedProduct.setPris(rs.getString("pris"));
                selectedProduct.setLeveringstid(rs.getString("leveringstid"));
                
                listofProducts.add(selectedProduct);
            }
            
        }catch (SQLException ex) {
                ex.printStackTrace();
            }
        return listofProducts;
        
    }//end of getAllProducts
    
    public void placeProduktForPurchase(String orderid, String produktid) {
        try{
        
            String sql = "INSERT INTO produktONorder(orderid,produktid) values (?,?)";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, orderid);
            pstmt.setString(2, produktid);

            pstmt.executeUpdate();
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        
    } //end 
    
    public ArrayList<Product> getProductDetails(String produktid){
        
        ArrayList<Product> valgtProdukt = new ArrayList<Product>();
        
        try{
            String sql = "select id,name,kategori,description,size,pris,leveringstid from produkt where id = ?";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, produktid);
                    
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                Product produktet = new Product();
                
                produktet.setId(rs.getInt("id"));
                produktet.setProduktname(rs.getString("name"));
                produktet.setKategori(rs.getString("kategori"));
                produktet.setDescription(rs.getString("description"));
                produktet.setSize(rs.getString("size"));
                produktet.setPris(rs.getString("pris"));
                produktet.setLeveringstid(rs.getString("leveringstid"));
                
                valgtProdukt.add(produktet);
            }
        }catch (SQLException ex) {
                ex.printStackTrace();
        }
        
        return valgtProdukt;
        
    }// end getProductDetails
            
    public ArrayList<ProductByOrder> getAllPurchaseByUser(String username, String orderid){
        
        ArrayList<ProductByOrder> PurchaseByUserList = new ArrayList<ProductByOrder>();
        
        try{
            String sql = "SELECT ordertable.orderid,user.username,produkt.name,produkt.pris FROM ordertable INNER JOIN produktONorder ON ordertable.orderid = produktONorder.orderid INNER JOIN produkt ON produktONorder.produktid = produkt.id INNER JOIN user ON ordertable.username = user.username WHERE user.username = ? AND ordertable.orderid = ?";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, username);
            pstmt.setString(2, orderid);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                ProductByOrder produkt = new ProductByOrder();
                
                produkt.setOrderid(rs.getInt("ordertable.orderid"));
                produkt.setUsername(rs.getString("user.username"));
                produkt.setProduktname(rs.getString("produkt.name"));
                produkt.setPris(rs.getString("produkt.pris"));
                
                PurchaseByUserList.add(produkt);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return PurchaseByUserList;
    } // end
    
    public String getPrisForPurchase(String username, String orderid){
        
        String SamletPris = new String();
                
        try{
            String sql = "select SUM(pris) as samletpris from ordertable INNER JOIN produktONorder ON ordertable.orderid = produktONorder.orderid INNER JOIN produkt ON produktONorder.produktid = produkt.id INNER JOIN user ON ordertable.username = user.username WHERE user.username = ? AND ordertable.orderid = ?";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, orderid);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                
                String pris = rs.getString("samletpris");
                return pris;
            }
                
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }//end
    

//////  TEST af outputtet fra de forskellige kajakmappers funktioner ////
//    public static void main(String[] args) {
//        ProduktMapper pm = new ProduktMapper();
//        
////        ArrayList<Product> producter = pm.getAllProducts();
////        for (Product product : producter) {
////            System.out.println(product.getProduktname());
////            System.out.println(product.getPris());
////            System.out.println(product.getSize());
////            System.out.println(product.getDescription());
////            System.out.println(product.getKategori());
////        }
////        
////        pm.placeProduktForPurchase("4", "1");
//
////        ArrayList<ProductByOrder> produkter = pm.getAllPurchaseByUser("admin", "1");
////        for (ProductByOrder product : produkter) {
////            System.out.println(product.getOrderid());
////            System.out.println(product.getUsername());
////            System.out.println(product.getProduktname());
////            System.out.println(product.getPris());
////        }
//        
////        String pris = pm.getPrisForPurchase("admin", "1");
////        System.out.println(pris);
//        
//        
////        ArrayList<Product> producter = pm.getProductDetails("2");
////        for (Product product : producter) {
////            System.out.println(product.getProduktname());
////            System.out.println(product.getPris());
////            System.out.println(product.getSize());
////            System.out.println(product.getDescription());
////            System.out.println(product.getKategori());
////        }
//        
//    } 
//////  TEST Area END //////
    
}// mapper slutter
