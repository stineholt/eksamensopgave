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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbh
 */
public class OrderMapper {
//    public void newOrder(String username){
//        try{
//            String sql = "INSERT INTO ordertable(username,orderdate,ordrebestilt) VALUES (?, ?, false);";
//            Connection con = DB.getConnection();
//            PreparedStatement pstmt = con.prepareCall(sql);
//                        
//            pstmt.setString(1, username);
//            pstmt.setDate(2, new java.sql.Date(date.getTime()));
//            
//            pstmt.executeUpdate();
//
//        }catch(SQLException ex) {
//            ex.printStackTrace();
//        }
                
//    }//end newOrder()
    
    public int getOrder (String username, Date date){
        try {
            String sql = "select orderid,username,orderdate,ordrebestilt from ordertable where username = ? and orderdate = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setDate(2, date);
            ResultSet rs = pstmt.executeQuery();
            int orderid = 0;
            
            if(rs.next()){
                String usernameDB = rs.getString("username");
                //Date date = rs.getDate("ordredate");
                if (usernameDB.equalsIgnoreCase(username)){
                rs.getInt("orderid");
                return orderid;
            }
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
//      //////// TEST AREA ////////
    public static void main(String[] args) {
        OrderMapper om = new OrderMapper();
//        try{
//            Date orderDate = new SimpleDateFormat("dd-MM-yyyy").parse("25-11-2016");
//            om.newOrder("bruger1",orderDate);
//        } catch (ParseException ex) {
//            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        om.getOrder("bruger1");
        
    }// TEST AREA END //


}// end class
