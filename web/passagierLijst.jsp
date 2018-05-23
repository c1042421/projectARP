<%-- 
    Document   : passagierLijst
    Created on : 22-mei-2018, 14:56:06
    Author     : c1042410
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passagier Lijst</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        
         <nav>
            <div class="flex-container-center-center flex-row">
                <img class="nav-logo left-margin" src="images/travel.svg" /> 
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
            </div>

            <div class="flex-container-center-center flex-row" >
                <% if (persoon != null) {%>
                <p><%= persoon.getVoornaam()%></p>
                <form action="InlogServlet">
                    <button type="submit" name="loguit"><i class="fas fa-sign-out-alt"> </i> Log uit</button>
                </form>
                <% }%>
            </div>
        </nav>
            
            
            
        <div class="flex-container flex-row">
            <div class="flex-container section">
                <div class="customCard">
                <% ArrayList<Passagier> lijstPassagier = (ArrayList<Passagier>)session.getAttribute("lijstPassagiers");
                    for (Passagier pasg : lijstPassagier) {%>
                    <p><%= pasg.getId() + ". " + pasg.getPersoon().getFamilienaam() + " " +  pasg.getPersoon().getVoornaam() + ", " + pasg.getPersoon().getLand() %></p>
                    <%}%>
                </div>
            </div>
        </div>
           
            
            
    </body>
</html>
