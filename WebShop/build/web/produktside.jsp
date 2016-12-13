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
        
        <div style="float: right; text-align: center; padding-right: 10px;">
            <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
            <a style="color: red"><%=  session.getAttribute("besked") %></a>

            <form action="showPurchaseServlet" method="POST">
                <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
                <input type="hidden" name="username" value="<%= session.getAttribute("username") %>">
                <input type="submit" value="Inkøbskurv" class="btn btn-default"/>
                <br/><br/>
            </form>
        </div>
        
                <table class="table table-striped">
                    <tbody>
                        <%  
                            List<Product> produktliste = (List<Product>)session.getAttribute("ProductListe");
                            for (Product product : produktliste){
                         %>

                        <form action="BuyProduct" method="POST">

                        
                        <div style="float: left; padding: 10px; border: gray solid 1px;">
                                <input type="hidden" name="origin" value="AlleProdukter">
                                <input type="hidden" name="produktid" value="<%= product.getId() %>">
                                <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
                                <img src="https://1369994046.rsc.cdn77.org/bilder/artiklar/750<%=product.getId() %>.jpg" style="width: 250px">
                                <br/><br/>
                                <h3><%= product.getProduktname() %></h3>
                                <%= product.getKategori() %>
                                <br/><br/>

                                <%= product.getPris() %> kr.<br/><br/>
                            <input type="submit" name="submit" value="Tilføj inkøbskurv" class="btn"></form>
                            <form action="ProductDetail" method="POST" style="float: right;">
                                <input type="hidden" name="produktid" value="<%= product.getId() %>">
                                <input type="submit" name="submit" value="Se mere" class="btn btn-default">
                            </form>  

                        </div>
                            
                        
                
                    <%-- almindelig table format
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
                                        <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
                                    </td>
                                    <td><%= product.getProduktname() %></td>
                                    <td><%= product.getKategori() %></td>
                                    <td>Beskrivelse:<br/><%= product.getDescription() %><br/>LEVERINGSTID:<br/>Forventet til <%= product.getLeveringstid() %> dage</td>
                                    <td><%= product.getSize() %> cm</td>
                                    <td><%= product.getPris() %> kr.</td>
                                    <td><input type="submit" name="submit" value="Tilføj inkøbskurv"></td>
                                </tr>
                            </form>--%>
                        
                    <% } %>
                
                
            </tbody>
        </table>
        
        
    </body>
</html>
