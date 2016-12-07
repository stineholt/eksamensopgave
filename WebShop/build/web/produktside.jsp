<%-- 
    Document   : produktside
    Created on : 02-12-2016, 10:51:41
    Author     : sbh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, model.ProduktMapper, model.UserMapper, model.entity.Product, model.entity.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEBSHOP - Produkt liste</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="navbar navbar-default">
            <div class="form-group" style="float: left; padding-left: 10px;"><h1> Plakat Webshop</h1></div>
            <div class="form-group" style="float: right;">   
            <form action="Login" method="POST">
                Logget ind som: <%= session.getAttribute("username") %>
                        <%  // Tjekker at bruger er logget ind //
                        //if(session.getAttribute("username") == null){
                          //  request.getRequestDispatcher("login.jsp").forward(request, response);
                            //return; }
                        %> 
                <input type="hidden" name="origin" value="logout">
                <input type="submit" value="Logout" class="btn btn-default">
            </form>
            </div>
        </div>     

        <h1></h1>
        
        <table class="table table-striped">
            <tbody>
                <%  
                    List<Product> produktliste = (List<Product>)session.getAttribute("ProductListe");
                    for (Product product : produktliste){
                        %>
                    
            <form action="BuyProduct" method="POST">
                <tr>
                    <td>
                        <input type="hidden" name="produktid" value="<%= product.getId() %>">
                        <%--<input type="hidden" name="orderid" value="<%=  %>">--%>
                    </td>
                    <td><%= product.getProduktname() %></td>
                    <td>kategori</td>
                    <td>Beskrivelse af produktet.<br/><br/>LEVERINGSTID:<br/>Forventet til <%= product.getLeveringstid() %> dage</td>
                    <td><%= product.getSize() %> cm</td>
                    <td><%= product.getPris() %> kr.</td>
                    <td><input type="submit" name="submit" value="Tilføj inkøbskurv"></td>
                </tr>
            </form>
                        
                    <% } %>
                
                
            </tbody>
        </table>
        
        
    </body>
</html>
