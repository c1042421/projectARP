<%-- 
    Document   : bemanningsVluchten
    Created on : 2-mei-2018, 11:32:22
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanningsvluchten</title>
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        
        <h1>Bemanningsvluchten</h1>
        
        <h3>Geplande vluchten voor: <%= persoon.getVoornaam() + " " + persoon.getFamilienaam() %></h3>
        
        <p>
            <%foreach (vlucht in vluchten){%>
            
}
        </p>
        
        
        
    </body>
</html>
