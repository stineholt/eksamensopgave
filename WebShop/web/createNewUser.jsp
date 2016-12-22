<%-- 
    Document   : createNewUser
    Created on : 01-12-2016, 20:19:58
    Author     : sbh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlakatShop - New user</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <style>
            td {padding: 5px}
            div {width: 300px; padding: 10px; margin: auto;}
        </style>
    </head>
    <body>
        <div class="navbar navbar-default">
            
        <form action="createNewUserServlet" method="POST" >
            <input type="hidden" value="registre" name="origin" />
            <h3>Udfyld for at oprette bruger:</h3>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="" class="form-control"/></td>
                </tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td></td></tr>
                <tr>
                    <td>Fornavn</td>
                    <td><input type="text" name="fornavn" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Efternavn</td>
                    <td><input type="text" name="efternavn" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>E-Mail</td>
                    <td><input type="email" name="email" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Mobil</td>
                    <td><input type="tel" name="mobil" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Adresse</td>
                    <td><input type="text" name="adresse" value="" class="form-control"/></td>
                </tr>
                <tr>
                    <td>Post nr</td>
                    <td><input type="number" name="postnr" value="" class="form-control"/></td>
                </tr>
                <tr><td></td><td></td></tr>
                <tr><td></td><td></td></tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create New User" class="btn btn-default"/></td></tr>
            </table>
        </form>
            </div>
    </body>
</html>
