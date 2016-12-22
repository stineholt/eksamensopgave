<%-- 
    Document   : ProduktDetails
    Created on : 13-12-2016, 13:31:32
    Author     : sbh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, model.ProduktMapper, model.UserMapper, model.entity.Product, model.entity.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlakatShop - Produkt Side</title>
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
        
        <%
            List<Product> productDetails = (List<Product>)session.getAttribute("productdetails");
            for (Product product : productDetails){
        %>
        <form action="BuyProduct" method="POST">
            <div style="margin: auto; width: 1000px; height: 600px; float: inside; padding: 10px; border: gray solid 1px;">
                    
                <div style="float: left; width: 50%;">
                    <table>
                    <input type="hidden" name="origin" value="Produktdetailjer">
                    <input type="hidden" name="produktid" value="<%= product.getId() %>">
                    <input type="hidden" name="orderid" value="<%=  session.getAttribute("orderid") %>">
                    <img src="https://1369994046.rsc.cdn77.org/bilder/artiklar/750<%=product.getId() %>.jpg" style="width: 400px">
                    <br/><br/>
                    </table>
                </div>
                    <div style="float: left; width: 40%;">
                            <h3><%= product.getProduktname() %></h3>
                            <%= product.getKategori() %>
                            <br/><br/>

                            BESKRIVELSE:<br/>
                            <%= product.getDescription() %>
                            <br/><br/>
                            <br/>LEVERINGSTID:<br/>Forventet til <%= product.getLeveringstid() %> dage
                            <br/><br/>
                            STØRRELSE:<br/> <%= product.getSize() %>cm
                            <br/><br/>
                            <h4 style="float: right;"><%= product.getPris() %> kr.</h4><br/><br/>
                            <br/><br/>
                        <input type="submit" name="submit" value="Tilføj inkøbskurv" class="btn"></form>
                        <form action="produktside.jsp" method="POST" style="float: right;">
                            <input type="hidden" name="produktid" value="<%= product.getId() %>">
                            <input type="submit" name="submit" value="Tilbage" class="btn btn-default">
                        </form>  
                    </div>

            </div>
                            
        
        <% } %>
    </body>
</html>
