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
        <link rel="stylesheet" type="text/css" href="../style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <nav>
            <div class="flex-container-center-center">
                <a class="left-margin flex-container-center-center flex-row home" href="../index.jsp">
                    <img class="nav-logo left-margin" src="../images/travel.svg" /> 
                    <p>Home</p>
                </a>
            </div>

            <div class="flex-container-center-center" >
                <% if (persoon != null) {%>
                <p><%= persoon.getVoornaam()%></p>
                <% }%></div>

        </nav>
        <div class="flex-container-top-center">
            <form action="../InlogServlet">

                <h2>Login</h2>

                <div class="card">
                    <div class="center"> <img class="loginImg" src="../images/travel.svg"> </div>
                    <p><label>Gebruikersnaam: </label> <br> <input autofocus type="text" name="gebruikersnaam" placeholder="vb. jelmar"/></p>
                    <p><label>Wachtwoord: </label> <br> <input type="password" name="password"/></p>
                    <p class="text-center"><button type="submit" > <i class="fas fa-sign-in-alt"> </i> Inloggen </button></p>
                </div>
            </form>
        </div>
    </body>
</html>