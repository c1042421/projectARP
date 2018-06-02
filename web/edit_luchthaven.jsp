<%-- 
    Document   : edit_luchthaven
    Created on : May 29, 2018, 9:39:46 PM
    Author     : jelmarvanaert
--%>

<%@page import="hbo5.it.www.beans.Land"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <% 
            Luchthaven l = (Luchthaven) session.getAttribute("editLuchthaven");
            ArrayList<Land> landen = (ArrayList<Land>) session.getAttribute("landen");
        %>
        
        <div class="flex-container-top-center">
            <h1> <%= l.getLuchthavennaam() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= l.getId()%>"/></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_luchthavens"/>
                    <p><label>Luchthavennaam: </label>
                        <input name="luchthavennaam" type="text" value="<%=l.getLuchthavennaam() %>"/></p>
                    <p><label>Land: </label>
                    <select name="land_id">
                        <% for(Land land : landen) { 
                            if (land.getId() == l.getLand_id() ) {
                        %>
                            <option selected value="<%=land.getId() %>"><%= land.getLandnaam() %></option>
                        <%} else {%>
                            <option value="<%=land.getId() %>"><%= land.getLandnaam() %></option>
                        <%}}%>
                    </select></p>
                    <p>
                        <label>
                           Stad:
                        </label>
                        <input name="stad" type="text" value="<%= l.getStad() %>"/></p>
                    </p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_luchthaven"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
