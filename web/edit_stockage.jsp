<%-- 
    Document   : edit_stockage
    Created on : Jun 4, 2018, 9:53:49 PM
    Author     : jelmarvanaert
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Stockage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Stockage</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <% 
            Stockage stockage = (Stockage) session.getAttribute("editStockage");
            ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) session.getAttribute("vliegtuigen");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        %>
        
        <div class="flex-container-top-center">
            <h1>Pas stockage <%= stockage.getHangar().getHangarnaam() %> aan<hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= stockage.getId()%>"/></p>
                    <input type="text" name="hangar_id" hidden value="<%= stockage.getHangar_id()%>"/></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_stockage"/>
                    <p><label>Reden: </label>
                        <input name="reden" type="text" value="<%=stockage.getReden() %>"/></p>
                    <p><label>Land: </label>
                    <select name="vliegtuig_id">
                        <% for(Vliegtuig vliegtuig : vliegtuigen) { 
                            if (vliegtuig.getId() == stockage.getVliegtuig_id()) {
                        %>
                        <option selected value="<%=vliegtuig.getId() %>"><%= vliegtuig.getVliegtuigtype().getTypenaam() %> - <%= vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam() %> </option>
                        <%} else {%>
                            <option value="<%=vliegtuig.getId() %>"><%= vliegtuig.getVliegtuigtype().getTypenaam() %> - <%= vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam() %></option>
                        <%}}%>
                    </select></p>
                    <p>
                        <label>
                           Van:
                        </label>
                        <input name="van" type="date" value="<%= stockage.getVandatum().toLocalDate().format(dateFormatter) %>"/></p>
                    </p>
                    <p>
                        <label>
                           Tot:
                        </label>
                        <input name="tot" type="date" value="<%= stockage.getTotdatum().toLocalDate().format(dateFormatter) %>"/></p>
                    </p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_stockage"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
