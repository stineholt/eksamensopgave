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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <input type="text" name="" value="<%= session.getAttribute("username") %>" />
        <input type="text" name="" value="<%= session.getAttribute("orderid") %>" />
        
        
        
    </body>
</html>
