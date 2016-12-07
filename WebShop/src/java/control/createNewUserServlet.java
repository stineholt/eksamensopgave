/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserMapper;

/**
 *
 * @author sbh
 */
@WebServlet(name = "createNewUserServlet", urlPatterns = {"/createNewUserServlet"})
public class createNewUserServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet createNewUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createNewUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserMapper um = new UserMapper();
        
        String usernameForm = request.getParameter("username");
        String passwordForm = request.getParameter("password");
        String fornavnForm = request.getParameter("fornavn");
        String efternavnForm = request.getParameter("efternavn");
        String emailForm = request.getParameter("email");
        String mobilForm = request.getParameter("mobil");
        String adresseForm = request.getParameter("adresse");
        String postnrForm = request.getParameter("postnr");
        
        um.createUser(usernameForm, passwordForm, fornavnForm, efternavnForm, emailForm, mobilForm, adresseForm, postnrForm);
        
            //Test udprint//
            PrintWriter out = response.getWriter(); 
            out.print("Oprettet succesfully med: "+usernameForm+" "+passwordForm+" "+fornavnForm+" "+efternavnForm+" "+emailForm+" "+mobilForm+" "+adresseForm+" "+postnrForm);
            
            HttpSession session = request.getSession();
            session.setAttribute("username", usernameForm);
            
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward (request, response);
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
