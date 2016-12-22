<%-- 
    Document   : Purchasekurv
    Created on : 12-12-2016, 20:51:00
    Author     : sbh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, model.ProduktMapper, model.UserMapper, model.entity.Product, model.entity.ProductByOrder, model.entity.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlakatShop - Indkøbskurv</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        
        <div class="navbar navbar-default">
            <div class="form-group" style="float: left; padding-left: 10px;"><h1> Plakat Webshop</h1></div>
            <div class="form-group" style="float: right;">   
            <form action="loginservlet" method="POST">
                Logget ind som: <%= session.getAttribute("username") %>
                        <%  // Tjekker at bruger er logget ind //
                        if(session.getAttribute("authenticated") == null){
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                            return; }
                        %>
                        
                <input type="hidden" name="origin" value="logout">
                <input type="submit" value="Logout" class="btn btn-default">
            </form>
            </div>
        </div>

        
        <input type="hidden" name="udername" value="<%= session.getAttribute("username") %>" />
        <input type="hidden" name="orderid" value="<%= session.getAttribute("orderid") %>" />
        
        
        <div style="margin: auto; width: 1000px; height: 100%; float: inside; padding: 10px; border: gray solid 1px;">
            
                
                    <table class="table table-striped">
                        <tbody>
                            <tr>
                                <th></th>
                                <th>Produkt name</th>
                                <th>Pris</th>
                                
                            </tr>
                    <%
                        List<ProductByOrder> purchasedProducts = (List<ProductByOrder>)session.getAttribute("PurshasedProducts");
                        for (ProductByOrder product : purchasedProducts){
                    %>
        
                <form action="placeOrder" method="POST">
                    <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
                            <tr>
                                <td></td>
                                <td><%= product.getProduktname() %></td>
                                <td><%= product.getPris() %> kr.</td>
                                
                            </tr>
                    
                    <% } %>
                    
                    <tr>
                        <td></td>
                        <td><h3>Samlet Pris</td></h3>
                        <td><h3>Kr. <%=  session.getAttribute("SamletPris") %></h3>
                            <br><input type="submit" name="submit" value="Bestil ordre" class="btn btn-default">
                        </td>
                    </tr>
                    </tbody>
                    </table>
                    
                    
                </form>
                        <form action="produktside.jsp" method="POST">
                        <input type="submit" name="submit" value="Tilbage" class="btn btn-default" >
                        </form>
                 </div>
                        
        
        
        
        
    </body>
</html>
