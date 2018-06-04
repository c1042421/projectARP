<%-- 
    Document   : beheer_stockage
    Created on : Jun 4, 2018, 9:14:05 PM
    Author     : jelmarvanaert
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Stockage"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer Stockage</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
       <jsp:include page="navigatieBalk.jsp" />
       <div class="flex-container-top-center padding-bottom">
            <h1>Beheer Stockage<hr></h1>
            <div class="grid-container grid-2-colums">
                <form action="BeheerServlet">
                    <input type="text" hidden name="beheerpagina" value="nieuwe_stockage"/>
                    <input type="text" hidden name="objectType" value="stockage"/>
                    <button name="nieuw" class="card card-hover" type="submit"><i class="fas fa-plus"> </i> Nieuwe stockage</button>
                </form>
                <% 
                    ArrayList<Stockage> stockages = (ArrayList<Stockage>) session.getAttribute("stockages");
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                %>
                <% if (!stockages.isEmpty()) {
                        for (Stockage stockage : stockages) {%>
                <div class="card">
                    <h2><%= stockage.getHangar().getHangarnaam() %></h2>
                    <p class="text-center"><%= stockage.getVliegtuig().getVliegtuigtype().getTypenaam() %> <i class="fas fa-plane middle-icon"> </i>  <%= stockage.getVliegtuig().getLuchtvaartmaatschappij().getLuchtvaartnaam()%> </p>
                    <p class="text-center"><i class="fas fa-info"> </i>  <%= stockage.getReden() %> </p>
                    <p class="text-center"><%= stockage.getVandatum().toLocalDate().format(dateFormatter) %>  <i class="fas fa-calendar-alt middle-icon"> </i> <%= stockage.getTotdatum().toLocalDate().format(dateFormatter) %></p> 
                    <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=stockage.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_stockage"/>
                            <input type="text" hidden name="objectType" value="stockage"/>
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
