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
        <title>PlakatShop</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    </head>
    <body>
            <% 
            if(session.getAttribute("username") == null){
                session.setAttribute("username", "Insæt username");
                session.setAttribute("besked","");
            }
            %>   
        <div>
        <nav class="navbar navbar-default" style="padding: 10px; width: 300px; margin: auto;">
            <h1>PlakatShop</h1>
        <div class="form-group">
        <form action="loginservlet" method="POST">
            
            <h3>Log in her:</h3>
            <input type="hidden" value="login" name="origin" />
            <input type="text" name="username" placeholder="Brugernavn" value="<%= session.getAttribute("username")%>"  class="form-control"/><br>
            <input type="password" name="password" placeholder="Password" class="form-control"/><br>
            
            <input type="submit" value="Log in" class="btn btn-default"/> <br><a style="color: red"><%=  session.getAttribute("besked") %></a><br><br>
        </form>
        <form action="createNewUser.jsp" method="GET">
            <input type="submit" value="Opret ny bruger" class="btn"/>
        </form>
        </div>
        </nav>
        </div>
    </body>
</html>
