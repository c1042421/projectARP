<%-- 
    Document   : beheer_bemanning
    Created on : 29-mei-2018, 12:55:57
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
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
            <h1>Beheer Bemanning<hr></h1>
            <div class="grid-container grid-2-colums">
                <% ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) session.getAttribute("bemanning");%>
                <% if (!bemanningsleden.isEmpty()) {
                        for (Bemanningslid lid : bemanningsleden) {%>
                <div class="card">
                    <h2><%= lid.getPersoon().getVolledigeNaam()%> </h2>
                    <p class="text-center"><%= lid.getFunctie().getFunctienaam() %></p>
                    <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=lid.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_bemanning"/>
                            <input type="text" hidden name="objectType" value="bemanningslid"/>
                            <button name="pasaan" class="button edit" type="submit"><i class="far fa-edit"></i> Pas aan</button>
                            <button name="verwijder" class="button" type="submit"><i class="fas fa-trash-alt"></i> Verwijder</button>
                        </div>
                    </form> 
                </div>
                <%}
                    }%>
            </div>
        </div>
    </body>
</html>
