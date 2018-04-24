<%-- 
    Document   : Zoekscherm
    Created on : 24-apr-2018, 13:14:14
    Author     : c1042486
--%>

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
        <nav class="navZoek">
            <h1>Welkom op het zoekscherm!</h1>
            <a href="index.jsp">Terug</a>
        </nav>
       
        <form class="containerZoek" action="ZoekServlet">
             <h2 class="boxZoek">Algemeen zoeken</h2>
            <p class="boxZoek">Ik zoek:</p>
            <%String[] keuzeArray = {"Binnenkomende vluchten", "Vertrekkende vluchten"};
            for (int i=0;  i<keuzeArray.length; i++) {%>
            <p class="boxZoek"><input type="radio" name="keuze" value="<%=keuzeArray[i]%>" id="<%=i%>"/>
                <label class="boxZoek" for="<%=i%>"><%=keuzeArray[i]%></label></p>
            <%}%>
            
            <p class="boxZoek">Mijn luchthaven: <input type="text" id="luchthaven" name="txtLuchthaven"/>
            </p>
            
            <h2 class="boxZoek">Specifiek zoeken</h2>
            <p class="boxZoek">Mijn vluchtnummer:<input type="text" id="vluchtnummer" name="txtVluchtnummer"/>
            </p>
            
            <p class="boxZoek">Mijn vluchtdatum:<input type="text" id="vluchtdatum" name="txtVluchtdatum"/>
            </p>
            
            <p class="boxZoek">Mijn bestemming:<input type="text" id="bestemming" name="txtBestemming"/>
            </p>
            
            <p class="boxZoek">Mijn luchtvaartmaatschappij:<input type="text" id="luchtvaartmaatschappij" name="txtLuchtvaartmaatschappij"/>
            </p>
            
            <p><input type="submit" value="Zoek vlucht(en)"/><p>
        </form>
    </body>
</html>
