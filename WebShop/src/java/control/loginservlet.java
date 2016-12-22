/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataFacade;
import model.OrderMapper;
import model.PasswordStorage;
import model.UserMapper;

/**
 *
 * @author sbh
 */
@WebServlet(name = "loginservlet", urlPatterns = {"/loginservlet","/index.html"})
public class loginservlet extends HttpServlet {


    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataFacade df = new DataFacade();
        
//        if(request.getParameter("username") == null)
//            response.sendRedirect("login.jsp");
        
        String origin = request.getParameter("origin");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.getSession().setAttribute("besked", "Log ind her:");
        
        if (origin == null){
            response.sendRedirect("login.jsp");
            request.getSession().setAttribute("authenticated",null);
        }else{
            switch (origin){
                case "login" :
                    System.out.println("i login case");
                    {
                        try {
                            if(df.authenticateUser(username,password)){
                                request.getSession().setAttribute("username", username);
                                OrderMapper om = new OrderMapper();
                                int orderid = om.getOrderID(username);
                                request.getSession().setAttribute("orderid", orderid);
                                request.getSession().setAttribute("authenticated","true");

                                RequestDispatcher rd = request.getRequestDispatcher("showProducts");
                                rd.forward (request, response); 
                            }else{
                                request.getSession().setAttribute("besked", "Forkert brugernavn eller password");
                                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                                rd.forward (request, response); 
                            }
                        } catch (PasswordStorage.CannotPerformOperationException ex) {
                            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (PasswordStorage.InvalidHashException ex) {
                            Logger.getLogger(loginservlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }break;
                case "logout" :
                    System.out.println("i logout case");
                    
                    request.getSession().invalidate();
                    request.getSession().setAttribute("besked", "Logget ud");
                    request.getSession(true);
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                                rd.forward (request, response); 
                    break;
                default :
                    request.getSession().setAttribute("besked", "Forkert brugernavn eller password");
                    request.getRequestDispatcher("login.jsp").forward (request, response); 
//                    response.sendRedirect("login.jsp");
//                    request.getSession().setAttribute("authenticated",null);
                    break;
            }
                    
        }

    }
    
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
