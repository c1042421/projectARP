<%-- 
    Document   : index
    Created on : 18-apr-2018, 9:19:05
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <nav>
            <div class="flex-container-center-center flex-row"> <img class="nav-logo left-margin" src="images/travel.svg" /> 
                <a class="left-margin flex-container-center-center flex-row menu" href="index.jsp">
                    <i class="fas fa-home"> </i>
                    <p>Home</p>
                </a>
                <a class="left-margin flex-container-center-center flex-row menu" href="passagiersVluchten.jsp">
                    <i class="fas fa-plane"> </i>
                    <p>Mijn Vluchten</p>
                </a>
                <a class="left-margin flex-container-center-center flex-row menu" href="bemanningsVluchten.jsp">
                    <i class="fas fa-plane"> </i>
                    <p>Mijn Reisschema</p>
                </a>
            </div> </div>
            <div class="flex-container-center-center flex-row">
             <% if (persoon != null) { %>
                <p> Welkom <%= persoon.getVoornaam() %></p>
                <form action="InlogServlet">
                    <button type="submit" name="loguit"><i class="fas fa-sign-out-alt"> </i> Log uit</button>
                </form>
             <% } else {%>
                <a href="login.jsp" class="button"><i class="fas fa-sign-in-alt"> </i> Log in</a>
            <% } %>
                <a href="registratie.jsp" class="button"><i class="fas fa-user-plus"> </i> Registreer</a>
            </div>
        </nav>
        <div class="flex-container-center-center ">
            <h1>HBOver the world</h1>
            <img id="logo" src="images/travel.svg" />
            <h2>Groep 6</h2>
        </div>
    </body>
</html>
