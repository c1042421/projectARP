<%-- 
    Document   : zoekresultaat
    Created on : 25-apr-2018, 8:56:30
    Author     : c1042486
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbo5.it.www.beans.Vlucht" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
        <title>Zoekresultaat</title>
    </head>
    <body>
        <%Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");%>
        <h1>Gevonden vluchten:</h1>
           
             <input type="text" value="<%=vlucht.getCode()%>"/>
            
    </body>
</html>
