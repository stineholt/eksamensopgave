/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author sbh
 */
public class OrderMapper {
    public void newOrder(String username, Date date){
        try{
            String sql = "INSERT INTO ordertable(username,orderdate,ordrebestilt) VALUES (?, ?, false);";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareCall(sql);
                        
            pstmt.setString(1, username);
            pstmt.setDate(2, new java.sql.Date(date.getTime()));
            
            pstmt.executeUpdate();

        }catch(SQLException ex) {
            ex.printStackTrace();
        }
                
    }//end newOrder()
    
    public int getOrderID (String username){
        try {
            String sql = "select orderid,username,orderdate,ordrebestilt from ordertable where username = ? and ordrebestilt = false";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
//            pstmt.setDate(2, (java.sql.Date) date);
            ResultSet rs = pstmt.executeQuery();
//            int orderid = 0;
            
            if(rs.next()){
                System.out.println("vi er nu i loopet");
                String usernameDB = rs.getString("username");
//                Date dateDB = rs.getDate("ordredate");
                    if (usernameDB.equalsIgnoreCase(username)){
                    int orderid = rs.getInt("orderid");
                    return orderid;
                    }
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("loopet endte uden resultat");
        return 0;
    } //end getOrderID

    public void closeOrder (String orderid){
        try{
            String sql = "UPDATE ordertable SET ordrebestilt = TRUE WHERE orderid = ?";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareCall(sql);
            
            pstmt.setString(1, orderid);
            
            pstmt.executeUpdate();
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }//end closeOrder
//    
//    
//    
////      //////// TEST AREA ////////
//    public static void main(String[] args) throws ParseException {
//        OrderMapper om = new OrderMapper();
//        
//        //tester new order oprettelse
////        try{
////            Date orderDate = new SimpleDateFormat("dd-MM-yyyy").parse("25-11-2016");
////            om.newOrder("bruger1",orderDate);
////        } catch (ParseException ex) {
////            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        
//        // tester get order id via brugernavn og at ordren ikke er købt
//            System.out.println(om.getOrderID("bruger1"));
//            
////            om.closeOrder("4");
//        
//    }// TEST AREA END //


}// end class
