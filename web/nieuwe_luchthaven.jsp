<%-- 
    Document   : nieuwe_luchthaven
    Created on : 30-mei-2018, 9:18:29
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Land"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <% 
            ArrayList<Land> landen = (ArrayList<Land>) session.getAttribute("landen");
        %>
        
        <div class="flex-container-top-center">
            <h1> Nieuwe Luchthaven<hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="beheerpagina" hidden value="beheer_luchthavens"/>
                    <p><label>Luchthavennaam: </label>
                        <input name="luchthavennaam" type="text" placeholder="bv. Zaventem"/></p>
                    <p><label>Land: </label>
                    <select name="land_id">
                        <% for(Land land : landen) {%>
                            <option value="<%=land.getId() %>"><%= land.getLandnaam() %></option>
                        <%}%>
                    </select></p>
                    <p>
                        <label>
                           Stad:
                        </label>
                        <input name="stad" type="text" placeholder="bv. Brussel"/></p>
                    </p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_nieuwe_luchthaven"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>