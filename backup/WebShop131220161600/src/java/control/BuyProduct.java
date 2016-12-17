/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderMapper;
import model.ProduktMapper;

/**
 *
 * @author sbh
 */
@WebServlet(name = "BuyProduct", urlPatterns = {"/BuyProduct"})
public class BuyProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            HttpSession session = request.getSession();
//            int produktid = Integer.parseInt(request.getParameter("produktid"));
//            String username = (String) session.getAttribute("username");
//            String orderID = (String) session.getAttribute("orderid");
//            
//                //Ny order oprettelse//
//                OrderMapper om = new OrderMapper();
//                
//                if (orderID == null){
//                
//                        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//
//                        try{
//                            Date orderDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
//                            om.newOrder(username,orderDate);
//                            int NewOrder = om.getOrderID(username);
//                            session.setAttribute("orderid", NewOrder);
//                            
//                            out.println("order id: "+NewOrder+" ");
//                            
//                            RequestDispatcher rd = request.getRequestDispatcher("produktside.jsp");
//                            rd.forward (request, response);
//                            
//                            //assign orderid in i session attribute//
//
//                        } catch (ParseException ex) {
//                            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        //end ny order oprettelse//
//                        
//                        out.println("Produkt valgt: "+produktid);
//                        out.println(" Usernavn: "+username);
//                        
//                }
//                else{
////                    out.println("i else loopdel");
//                    int idOrder = om.getOrderID(username);
//                    session.setAttribute("orderid", idOrder);
//                    RequestDispatcher rd = request.getRequestDispatcher("produktside.jsp");
//                            rd.forward (request, response);
//                }
//            
//            
//            
//        // mapper function for dette mangler 
//        // - der bliver opfanget det produkt der er valgt og username
//            
//            
//        }
//    }

    
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
//        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            int produktid = Integer.parseInt(request.getParameter("produktid")); 
            String username = (String) session.getAttribute("username");
            int orderID = (int) session.getAttribute("orderid");
            String idProduktString = request.getParameter("produktid");
            
                OrderMapper om = new OrderMapper();
                ProduktMapper pm = new ProduktMapper();
                
                        //for testing før if regler
                        out.println(produktid); 
                        out.println(username);
                        out.println(orderID+" statisk test af data <br/><br/> ");
                        // slut testing af parameter
                
                if (orderID == 0){
                        
                    //Ny order oprettelse//
                    
                        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

                        try{
                            Date orderDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                            om.newOrder(username,orderDate);
                            int NewOrder = om.getOrderID(username);
                            session.setAttribute("orderid", NewOrder);
                            String orderidasString = Integer.toString(NewOrder);
                            pm.placeProduktForPurchase(orderidasString, idProduktString);
                            out.println("order id: "+NewOrder+" ");
                            
                            session.setAttribute("besked", "Produkt "+idProduktString+" tilføjet til indkøbs kurv");
                            
                            RequestDispatcher rd = request.getRequestDispatcher("produktside.jsp");
                            rd.forward (request, response);
                            
                            //assign orderid in i session attribute//

                        } catch (ParseException ex) {
                            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //end ny order oprettelse//
                        
                        out.println("Produkt valgt: "+produktid);
                        out.println(" Usernavn: "+username);
                        
                }
                else{
                    out.println("  Du har valgt følgende produkt til din ordre: ");
                    int idOrder = om.getOrderID(username);
                    String orderidasString = Integer.toString(idOrder);
                    pm.placeProduktForPurchase(orderidasString, idProduktString);  // tilføjet produkt til produktorderliste i db
                    
                            //for testing
                            out.println("<br/> Ordre id integervalue: "+idOrder);
                            out.println("<br/> produkt som er valgt: "+idProduktString);
                            out.println("<br/> Ordre som String: "+orderidasString);
                            // testing slut
                            
                    session.setAttribute("orderid", idOrder);
                    session.setAttribute("besked", "Produkt "+idProduktString+" tilføjet til indkøbs kurv");
//                    
                    RequestDispatcher rd = request.getRequestDispatcher("produktside.jsp");
                            rd.forward (request, response);
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
