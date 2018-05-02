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
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <nav>
             <% if (persoon != null) { %>
                <p> Welkom <%= persoon.getVoornaam() %></p>
                 <a href ="login.jsp?loguit=true"><i class="fas fa-user"> </i> Log uit</a>
             <% } else {%>
                <a href ="login.jsp"><i class="fas fa-user"> </i> Log in</a>
            <% } %>
        </nav>
        <div class="container">
            <h1>HBOver the world</h1>
            <img id="logo" src="images/travel.svg" />
            <h2>Groep 6</h2>
        </div>
    </body>
</html>
