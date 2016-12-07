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

/**
 *
 * @author sbh
 */
public class ProduktMapper {
    
    public ArrayList<Product> getAllProducts(){
        
        ArrayList<Product> listofProducts = new ArrayList<Product>();
        
        try{
            String sql = "SELECT id,name,size,pris,leveringstid FROM produkt;";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Product selectedProduct = new Product();
                
                selectedProduct.setId(rs.getInt("id"));
                selectedProduct.setProduktname(rs.getString("name"));
//                selectedProduct.getKategori(rs.getString("kategori"));
//                selectedProduct.getDescription(rs.getString("description"));
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
    

//////  TEST af outputtet fra de forskellige kajakmappers funktioner ////
//    public static void main(String[] args) {
//        ProduktMapper pm = new ProduktMapper();
//        
//        ArrayList<Product> producter = pm.getAllProducts();
//        for (Product product : producter) {
//            System.out.println(product.getProduktname());
//            System.out.println(product.getPris());
//            System.out.println(product.getSize());
//        }
//        
//    } 
//////  TEST Area END //////
    
}// mapper slutter
