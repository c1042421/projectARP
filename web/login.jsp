<%-- 
    Document   : login
    Created on : 24-apr-2018, 13:41:31
    Author     : c1042421
--%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center">
            <form action="InlogServlet" method="post">

                <h2>Login</h2>

                <div class="card">
                    <div class="center"> <img class="loginImg" src="images/travel.svg"> </div>
                    <p><label>Gebruikersnaam: </label> <br> <input autofocus type="text" name="gebruikersnaam" placeholder="vb. jelmar"/></p>
                    <p><label>Wachtwoord: </label> <br> <input type="password" name="password"/></p>
                    <p class="text-center"><button type="submit" class="button" > <i class="fas fa-sign-in-alt"> </i> Inloggen </button></p>
                </div>
            </form>
        </div>
    </body>
</html>