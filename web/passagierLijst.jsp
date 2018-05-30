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
        <title>Passagierlijst</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        
        
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>

        
        <div class="flex-container flex-row">
            <div class="flex-container section">
                <div class="customCard">
                <% ArrayList<Passagier> lijstPassagier = (ArrayList<Passagier>)session.getAttribute("lijstPassagiers");
                    for (int i = 0; i < lijstPassagier.size() ; i++) {
                    Passagier pasg = lijstPassagier.get(i); %>
                    <p><%= i + 1 + ". " + pasg.getPersoon().getFamilienaam() + " " +  pasg.getPersoon().getVoornaam() + ", " + pasg.getPersoon().getLand()%></p>
                    <%if (pasg.getIngecheckt()) {%>
                        <p class="groen"><i class="fas fa-check"></i> <%=pasg.toString()%></p>
                    <%}else{%>
                    <p class="rood"><i class="fas fa-times"></i> <%=pasg.toString()%></p>
                    <%}%>
                    <%}%>
                </div>
            </div>
        </div>    
    </body>
</html>
