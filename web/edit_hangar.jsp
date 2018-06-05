<%-- 
    Document   : edit_hangar
    Created on : 5-jun-2018, 15:13:37
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
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
            Hangar hg = (Hangar) session.getAttribute("editHangar");
        %>
        
        <div class="flex-container-top-center">
            <h1> <%= hg.getHangarnaam() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= hg.getId()%>"/></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_hangar"/>
                    <p><label>Hangarnaam: </label>
                        <input name="hangarnaam" type="text" value="<%=hg.getHangarnaam() %>"/></p>
                    
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_hangar"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
