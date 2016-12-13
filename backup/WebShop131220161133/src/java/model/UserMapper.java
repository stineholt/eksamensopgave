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

/**
 *
 * @author sbh
 */
public class UserMapper {
    
    public void createUser (String username, String password, String fornavn, String efternavn, String email, String mobil, String adresse, String postnr) throws PasswordStorage.CannotPerformOperationException{
        try{
            String hashed = PasswordStorage.createHash(password);
            String sql = "INSERT INTO user (username,password,FName,LName,email,mobil,adresse,postnr) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, username);
            pstmt.setString(2, hashed);
            pstmt.setString(3, fornavn);
            pstmt.setString(4, efternavn);
            pstmt.setString(5, email);
            pstmt.setString(6, mobil);
            pstmt.setString(7, adresse);
            pstmt.setString(8, postnr);
            
            pstmt.executeUpdate();
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }//end create user
    
    public boolean authenticateUser(String username, String password) throws model.PasswordStorage.CannotPerformOperationException, model.PasswordStorage.InvalidHashException{
        try {
            String sql = "select username,password from user where username = ?";
            Connection con = DB.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){  // vi vil gerne tjekke passwordet det gøres her i denne if
                String hash = rs.getString("password");
                if(PasswordStorage.verifyPassword(password, hash)){
                        return true;                    
                    }
            }
//                //før hash implementering
//                String passwordFromDB = rs.getString("password");
//                if (passwordFromDB.equals(password)){
//                    return true;
//                }
//                }else{
//                    return false;
//                }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
        
    }//end authenticateUser


////  TEST af outputtet fra de forskellige usermapper funktioner
//    public static void main(String[] args) {
//        UserMapper um = new UserMapper(); 
//        
//        um.createUser("brugersbh", "password", "fornavn", "efternavn", "email", "mobil", "adresse", "2300");
//    } //////  TEST af outputtet SLUT ///////
}// mapper slutter
