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
    </head>
    <body>
        <h1>Welkom op het zoekscherm!</h1>
        <h2>Algemeen zoeken</h2>
        <form action="ZoekServlet">
            <p>Ik zoek:</p>
            <%String[] keuzeArray = {"Binnenkomende vluchten", "Vertrekkende vluchten"};
            for (int i=0;  i<keuzeArray.length; i++) {%>
            <p><input type="radio" name="keuze" value="<%=keuzeArray[i]%>" id="<%=i%>"/>
                <label for="<%=i%>"><%=keuzeArray[i]%></label></p>
            <%}%>
            
            <p>Mijn luchthaven: <input type="text" id="luchthaven" name="txtLuchthaven"/>
            </p>
            
            <h2>Specifiek zoeken</h2>
            <p>Mijn vluchtnummer:               <input type="text" id="vluchtnummer" name="txtVluchtnummer"/>
            </p>
            
            <p>Mijn vluchtdatum:                <input type="text" id="vluchtdatum" name="txtVluchtdatum"/>
            </p>
            
            <p>Mijn bestemming:                 <input type="text" id="bestemming" name="txtBestemming"/>
            </p>
            
            <p>Mijn luchtvaartmaatschappij:     <input type="text" id="luchtvaartmaatschappij" name="txtLuchtvaartmaatschappij"/>
            </p>
            
            <p><input type="submit" value="Zoek vlucht(en)"/><p>
        </form>
    </body>
</html>
