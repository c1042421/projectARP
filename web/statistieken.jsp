<%-- 
    Document   : statistieken
    Created on : Jun 2, 2018, 11:15:46 AM
    Author     : jelmarvanaert
--%>

<%@page import="java.util.Dictionary"%>
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
                            String gekozenTab = (String) session.getAttribute("gekozenTab");
                        %>
                    <div class="flex-container padding-bottom">
                        <div class="tab">
                            <button class="tablinks <% if (gekozenTab.equals("vlucht")) {%> active <%}%> " onclick="openTab(event, 'vlucht')">Vlucht</button>
                            <button class="tablinks <% if (gekozenTab.equals("dag")) {%> active <%}%> " onclick="openTab(event, 'dag')">Dag</button>
                            <button class="tablinks <% if (gekozenTab.equals("maand")) {%> active <%}%> " onclick="openTab(event, 'maand')">Maand</button>
                        </div>
                    </div>
                    <%
                        ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute("vluchten");
                        int vluchtID = (Integer) session.getAttribute("vluchtID");
                        int aantalPassagiersPerVlucht = (Integer) session.getAttribute("aantalPassagiersPerVlucht");
                    %>

                    <div id="vlucht" class="tabcontent" <% if (gekozenTab.equals("vlucht")) {%> style="display: block" <%}%>>
                        <form>
                            <input type="text" name="gekozenTab" value="vlucht" hidden />
                            <label>Kies de vlucht: </label>
                            <select name="vlucht_id" onchange="this.form.submit();">
                                <% for (Vlucht vlucht : vluchten) {%>
                                    <option value="<%=vlucht.getId()%>" <%if (vluchtID == vlucht.getId()) {%> selected <%}%> > <%= vlucht.getCode()%></option>
                                <%}%>
                            </select>
                        </form>
                        <p class="text-center"> 
                            <% if (aantalPassagiersPerVlucht == 0) { %>
                            Er zijn nog geen passagiers op deze vlucht.
                            <%} else {%>
                            <%= aantalPassagiersPerVlucht%> passagiers.
                            <%}%></p>
                    </div>
                    <div id="dag" class="tabcontent" <% if (gekozenTab.equals("dag")) {%> style="display: block" <%}%>>
                        <%
                        int dagID = (Integer) session.getAttribute("dag_id");
                    %>
                        <form>
                             <input type="text" name="gekozenTab" value="dag" hidden />
                             <label>Kies de dag: </label>
                             <select name="dag_id" onchange="this.form.submit()">
                                 <option value="1" <% if (dagID == 1) {%> selected <%}%> >Maandag</option>
                                 <option value="2" <% if (dagID == 2) {%> selected <%}%> >Dinsdag</option>
                                 <option value="3" <% if (dagID == 3) {%> selected <%}%> >Woensdag</option>
                                 <option value="4" <% if (dagID == 4) {%> selected <%}%> >Donderdag</option>
                                 <option value="5" <% if (dagID == 5) {%> selected <%}%> >Vrijdag</option>
                                 <option value="6" <% if (dagID == 6) {%> selected <%}%> >Zaterdag</option>
                                 <option value="7" <% if (dagID == 7) {%> selected <%}%> >Zondag</option>
                             </select>
                             <p class="text-center"> 
                            <% if (aantalPassagiersPerVlucht == 0) { %>
                            Er zijn nog geen passagiers op deze vlucht.
                            <%} else {%>
                            <%--<%= aantalPassagiersPerVlucht%>--%> passagiers.
                            <%}%></p>
                        </form>   
                    </div>
                    <div id="maand" class="tabcontent" <% if (gekozenTab.equals("maand")) {%> style="display: block" <%}%>>
                        <form>
                            <%
                        int maandID = (Integer) session.getAttribute("maand_id");
                    %>
                             <input type="text" name="gekozenTab" value="maand" hidden />
                             <label>Kies de maand:</label>
                             <select name="maand_id" onchange="this.form.submit()">
                                 <option value="1" <% if (maandID == 1) {%> selected <%}%> >Januari</option>
                                 <option value="2" <% if (maandID == 2) {%> selected <%}%>>Februari</option>
                                 <option value="3" <% if (maandID == 3) {%> selected <%}%>>Maart</option>
                                 <option value="4" <% if (maandID == 4) {%> selected <%}%>>April</option>
                                 <option value="5" <% if (maandID == 5) {%> selected <%}%>>Mei</option>
                                 <option value="6" <% if (maandID == 6) {%> selected <%}%>>Juni</option>
                                 <option value="7" <% if (maandID == 7) {%> selected <%}%>>Juli</option>
                                 <option value="8" <% if (maandID == 8) {%> selected <%}%>>Augustus</option>
                                 <option value="9" <% if (maandID == 9) {%> selected <%}%>>September</option>
                                 <option value="10" <% if (maandID ==10) {%> selected <%}%>>Oktober</option>
                                 <option value="11" <% if (maandID == 11) {%> selected <%}%>>November</option>
                                 <option value="12" <% if (maandID == 12) {%> selected <%}%>>December</option>
                             </select>
                             <p class="text-center">
                              <% if (aantalPassagiersPerVlucht == 0) { %>
                            Er zijn nog geen passagiers deze maand.
                            <%} else {%>
                            <%--<%= aantalPassagiersPerVlucht%>--%> passagiers.
                            <%}%></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
