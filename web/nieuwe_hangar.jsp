<%-- 
    Document   : nieuwe_hangar
    Created on : 5-jun-2018, 15:40:19
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe hangar</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <%
            ArrayList<Hangar> hangars = (ArrayList<Hangar>) session.getAttribute("hangars");
        %>

        <div class="flex-container-top-center">
            <h1>Nieuwe hangar<hr/></h1>

            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="0"/></p>
                    <p><label> Hangar: </label>
                        <select name="hangar_id">
                            <% for (Hangar hangar : hangars) {%>
                            <option value="<%=hangar.getId()%>"><%= hangar.getHangarnaam()%></option>
                            <%}%>
                        </select></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_hangar"/>
                    
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_nieuwe_hangar"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>