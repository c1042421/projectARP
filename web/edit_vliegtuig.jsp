<%-- 
    Document   : edit_vliegtuig
    Created on : 30-mei-2018, 11:22:55
    Author     : c1042410
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
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
            Vliegtuig vl = (Vliegtuig) session.getAttribute("editVliegtuig");
        %>
        
        <div class="flex-container-top-center">
            <h1> <%= vl.getVliegtuigtype().getTypenaam() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= vl.getId()%>"/></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_vliegtuigen"/>
                    <p><label>Vliegtuignaam: </label>
                        <input name="vliegtuignaam" type="text" value="<%=vl.getVliegtuigtype().getTypenaam() %>"/></p>
                    
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_luchthaven"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
                    
    </body>
</html>
