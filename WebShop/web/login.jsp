<%-- 
    Document   : login
    Created on : 01-12-2016, 20:19:58
    Author     : sbh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WEBSHOP</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    </head>
    <body>
            <% 
            if(session.getAttribute("username") == null){
                session.setAttribute("username", "Insæt username");
            }
            %>   
        <div>
        <nav class="navbar navbar-default" style="padding: 10px; width: 300px; margin: auto;">
            <h1>Webshopname</h1>
        <div class="form-group">
        <form action="loginservlet" method="POST">
            <h3>Log in her:</h3>
            <input type="text" name="username" placeholder="Brugernavn" value="<%= session.getAttribute("username")%>"  class="form-control"/><br>
            <input type="text" name="password" placeholder="Password" class="form-control"/><br>
            <input type="submit" value="Log in" class="btn btn-default"/><br><br>
        </form>
        <form action="createNewUser.jsp" method="GET">
            <input type="submit" value="Sign up" class="btn btn-default"/>
        </form>
        </div>
        </nav>
        </div>
    </body>
</html>
