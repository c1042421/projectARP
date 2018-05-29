<%-- 
    Document   : beheer_bemanning
    Created on : 29-mei-2018, 12:55:57
    Author     : c1042421
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer bemanning</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center">
            <h1>Beheer luchthavens <hr></h1>
            <div class="grid-container grid-2-colums">
                <% ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) session.getAttribute("luchthavens");%>
                <% if (!luchthavens.isEmpty()) {
                    for (Luchthaven luchthaven : luchthavens) {%>
                    <div class="card"><h2><%= luchthaven.getLuchthavennaam()%></h2> <p class="text-center"><%= luchthaven.getLand().getLandnaam()%> - <%=luchthaven.getStad()%></p>  </div>
                <%}
                }%>
            </div>


        </div>
    </body>
</html>
