<%-- 
    Document   : Zoekscherm
    Created on : 24-apr-2018, 13:14:14
    Author     : c1042486
--%>

<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
         <jsp:include page="navigatieBalk.jsp" />
       
        <form class="containerZoek" action="zoekServlet" method="Get">
             <h2 class="boxZoek">Algemeen zoeken</h2>
             <% ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) session.getAttribute("luchthavens");%>
                
             
             <p>Selecteer een luchthaven:</p>
             <select id="selectLuchthaven" name="luchthavenID">
                 <% if (!luchthavens.isEmpty()) {
                        for (Luchthaven luchthaven : luchthavens) {%>
                 <option value="<%=luchthaven.getId()%>"><%=luchthaven.getLuchthavennaam()%></option>
                <%}}%>
             </select>
            <p class="boxZoek">Ik zoek:</p>
            <select id="soortVlucht" name="soortVlucht">
                <option>Binnenkomende vluchten</option>
                <option>Vertrekkende vluchten</option>
            </select>
            <p><input name="zoekfunctie" type="submit" value="Algemeen zoeken"/></p>
        </form>
        
        
        <form action="zoekServlet" method="Get">
            
            
            <h2 class="boxZoek">Specifiek zoeken</h2>
            <p class="boxZoek">Mijn vluchtnummer:<input type="text" id="vluchtnummer" name="txtVluchtnummer"/>
            </p>
            
            <p class="boxZoek">Mijn vluchtdatum:<input type="date" id="vluchtdatum" name="txtVluchtdatum"/>
            </p>
            
            <p class="boxZoek">Mijn bestemming:<input type="text" id="bestemming" name="txtBestemming"/>
            </p>
            
            <p class="boxZoek">Mijn luchtvaartmaatschappij:<input type="text" id="luchtvaartmaatschappij" name="txtLuchtvaartmaatschappij"/>
            </p>
            
            <p><input name="zoekfunctie" type="submit" value="Specifiek zoeken"><p>
        </form>
    </body>
</html>
