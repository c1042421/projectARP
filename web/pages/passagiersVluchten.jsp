<%-- 
    Document   : mijnVluchten
    Created on : 2-mei-2018, 11:27:38
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mijn Vluchten</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <nav>
            <div class="flex-container-center-center">
                <a class="left-margin flex-container-center-center flex-row home" href="index.jsp">
                    <img class="nav-logo left-margin" src="images/travel.svg" /> 
                    <p>Home</p>
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
        <div class="flex-container-top-center">
            <h2>Mijn vluchten <hr/></h2>
            
                <% ArrayList<Passagier> passagiers = (ArrayList<Passagier>) session.getAttribute("passagiers"); 
                if (passagiers != null) {
                    for (Passagier passagier : passagiers) {
                    Vlucht vlucht = passagier.getVlucht(); %>
                    <div class="card flex-container flex-row" >
                        <div>
                            <h3>Van</h3>
                            <p><%= vlucht.getVertrekLuchthaven().getLuchthavennaam() %> - <%= vlucht.getVertrekLuchthaven().getStad() %></p>
                             <p> <%= vlucht.getVertrekLuchthaven().getLand().getLandnaam() %></p>
                        </div>
                        <div><img src="images/ic_plane.svg" /></div>
                        <div>
                            <h3>Naar</h3>
                            <p><%= vlucht.getAankomstLuchthaven().getLuchthavennaam() %> - <%= vlucht.getAankomstLuchthaven().getStad() %></p>
                            <p> <%= vlucht.getAankomstLuchthaven().getLand().getLandnaam() %></p>
                        </div>
                    </div>
                    <%}
                } else {%>
                    <p>Geen vluchten</p>
                <%}%>
            

        </div>


    </body>
</html>
