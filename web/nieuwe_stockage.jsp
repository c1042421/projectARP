<%-- 
    Document   : nieuwe_stockage
    Created on : Jun 4, 2018, 10:43:00 PM
    Author     : jelmarvanaert
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe stockage</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <%
            ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) session.getAttribute("vliegtuigen");
            ArrayList<Hangar> hangars = (ArrayList<Hangar>) session.getAttribute("hangars");
        %>

        <div class="flex-container-top-center">
            <h1>Nieuwe stockage<hr/></h1>

            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="0"/></p>
                    <p><label> Hangar: </label>
                        <select name="hangar_id">
                            <% for (Hangar hangar : hangars) {%>
                            <option value="<%=hangar.getId()%>"><%= hangar.getHangarnaam()%></option>
                            <%}%>
                        </select></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_stockage"/>
                    <p><label>Reden: </label>
                        <input name="reden" type="text" /></p>
                    <p><label>Land: </label>
                        <select name="vliegtuig_id">
                            <% for (Vliegtuig vliegtuig : vliegtuigen) {%>
                            <option value="<%=vliegtuig.getId()%>"><%= vliegtuig.getVliegtuigtype().getTypenaam()%> - <%= vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></option>
                            <%}%>
                        </select></p>
                    <p>
                        <label>
                            Van:
                        </label>
                        <input name="van" type="date"/></p>
                    </p>
                    <p>
                        <label>
                            Tot:
                        </label>
                        <input name="tot" type="date"/></p>
                    </p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_nieuwe_stockage"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>
