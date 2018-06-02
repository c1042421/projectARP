<%-- 
    Document   : statistieken
    Created on : Jun 2, 2018, 11:15:46 AM
    Author     : jelmarvanaert
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistieken</title>
        <jsp:include page="imports.jsp" />    
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center">
            <h1>Statistieken<hr/></h1>
            <div class="grid-container grid-2-colums">
                <div class="card">
                    <h2>Gemiddelde leeftijd<hr/></h2>
                        <%
                            int gemiddeldeLeeftijd = (Integer) session.getAttribute("gemiddeldeLeeftijd");
                            ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) session.getAttribute("luchthavens");
                            int luchthavenID = (Integer) session.getAttribute("luchthavenID");
                        %>
                    <form>
                        <label>Voor aankomstluchthaven: </label>
                        <select name="luchthaven_id" onchange="this.form.submit();">
                            <% for (Luchthaven luchthaven : luchthavens) {
                                    if (luchthavenID == luchthaven.getId()) {%>
                            <option value="<%=luchthaven.getId()%>" selected><%= luchthaven.getLuchthavennaam()%></option>
                            <%} else {%>
                            <option value="<%=luchthaven.getId()%>"><%= luchthaven.getLuchthavennaam()%></option>
                            <%}
                                }%>
                        </select>
                    </form>
                    <p class="text-center">
                        <% if (gemiddeldeLeeftijd == 0) { %>
                        Er zijn nog geen passagiers op deze vlucht.
                        <%} else {%>
                        <%= gemiddeldeLeeftijd%> jaar.
                        <%}%>
                    </p>
                </div>

                <div class="card">
                    <h2>Aantal passagiers <hr/></h2>
                        <%
                            ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute("vluchten");
                            int vluchtID = (Integer) session.getAttribute("vluchtID");
                            int aantalPassagiersPerVlucht = (Integer) session.getAttribute("aantalPassagiersPerVlucht");
                        %>
                    <form>
                        <label>Volgens vlucht: </label>
                        <select name="vlucht_id" onchange="this.form.submit();">
                            <% for (Vlucht vlucht : vluchten) {
                                    if (vluchtID == vlucht.getId()) {%>
                            <option value="<%=vlucht.getId()%>" selected><%= vlucht.getCode()%></option>
                            <%} else {%>
                            <option value="<%=vlucht.getId()%>"><%= vlucht.getCode()%></option>
                            <%}
                                }%>
                        </select>
                    </form>
                    <p class="text-center"> <% if (aantalPassagiersPerVlucht == 0) { %>
                        Er zijn nog geen passagiers op deze vlucht.
                        <%} else {%>
                        <%= aantalPassagiersPerVlucht%> passagiers.
                        <%}%></p>
                </div>
            </div>
        </div>
    </body>
</html>
