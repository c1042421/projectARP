<%-- 
    Document   : bemanningsVluchten
    Created on : 2-mei-2018, 11:32:22
    Author     : c1042410
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="hbo5.it.www.beans.VluchtBemanning"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanningsvluchten</title>
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
            
            
            
            
            <div class="flex-container-top-center">
                <h2>Mijn Reisschema <hr/></h2>
            
                <% ArrayList<VluchtBemanning> bemanningsleden = (ArrayList<VluchtBemanning>) session.getAttribute("vluchtbemanning"); 
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                        //DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                if (bemanningsleden != null && bemanningsleden.size() > 0) {
                    for (VluchtBemanning vlubem : bemanningsleden) {
                    Vlucht vlucht = vlubem.getVlucht(); 
                    LocalDate localdate = vlucht.getAankomsttijd().toLocalDate(); %>
                    <div class="vlucht card flex-container" >
                        <div>
                            <h3> Vlucht <%= vlucht.getCode() %> </h3>
                        </div>
                        <div class="flex-container flex-row">
                            <div class="flex-container section">
                                <h3>Van</h3>
                                <p> <%= vlucht.getVertrekLuchthaven().getLand().getLandnaam() %> - <%= vlucht.getVertrekLuchthaven().getStad() %><br/>
                                    <%= vlucht.getVertrekLuchthaven().getLuchthavennaam() %> <br/>
                                    op: <%= vlucht.getVertrektijd().toLocalDate().format(dateFormatter) %>
                                </p>
                            </div>
                            <div class="flex-container middle">
                                <img src="images/ic_plane.svg" />
                            </div>
                            <div class="flex-container section">
                                <h3>Naar</h3>
                                <p> <%= vlucht.getAankomstLuchthaven().getLand().getLandnaam() %>  - <%= vlucht.getAankomstLuchthaven().getStad()%><br/>
                                <%= vlucht.getAankomstLuchthaven().getLuchthavennaam() %><br/>
                                op: <%= vlucht.getAankomsttijd().toLocalDate().format(dateFormatter) %><br/>
                                </p>
                               

                            </div>
                        </div>
                        <div class="flex-container flex-row">
                            <a href="#" class="button"><i class="fas fa-plane"> </i> Details </a>
                        </div>
                    </div>
                    <%}
                } else {%>
                    <p>Geen reisschema beschikbaar.</p>
                <%}%>
            </div>

            
            
            
    </body>
</html>
