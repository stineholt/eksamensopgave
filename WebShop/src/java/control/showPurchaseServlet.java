/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProduktMapper;
import model.entity.ProductByOrder;

/**
 *
 * @author sbh
 */
@WebServlet(name = "showPurchaseServlet", urlPatterns = {"/showPurchaseServlet"})
public class showPurchaseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            String usernameSession = (String) session.getAttribute("username");
            String orderidSession = (String) session.getAttribute("orderid");
            String orderidRequest = (String) request.getAttribute("orderid");
            
            ProduktMapper pm = new ProduktMapper();
//            List<ProductByOrder> purchasedProducts = pm.getAllPurchaseByUser(usernameSession, orderidSession);
//            String SamletPris = pm.getPrisForPurchase(usernameSession, orderidSession);
            String SamletPristest = pm.getPrisForPurchase("bruger1", "4");
            
            request.setAttribute("SamletPris", SamletPristest);
//            session.setAttribute("SamletPris", SamletPris);
//            session.setAttribute("PurshasedProducts", purchasedProducts);
            
            out.println(usernameSession);
            out.println(orderidSession);
            out.println(orderidRequest);
            out.println(SamletPristest);
//            out.println(SamletPris);
//            out.println(purchasedProducts);
            
//            RequestDispatcher rd = request.getRequestDispatcher("Purchasekurv.jsp");
//            rd.forward (request, response);
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
