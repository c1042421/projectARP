<%-- 
    Document   : details
    Created on : 5-jun-2018, 10:26:54
    Author     : Axel
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <% Vlucht vlucht = (Vlucht) session.getAttribute("vlucht");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localdate = vlucht.getAankomsttijd().toLocalDate();%>
        <div class="vlucht card flex-container" >
            <div>
                <h3> Vlucht <%= vlucht.getCode()%> </h3>
            </div>
            <div class="flex-container flex-row">
                <div class="flex-container section">
                    <h3>Vertrekluchthaven</h3>
                    <p> <%= vlucht.getVertrekLuchthaven()%> <br/>
                    </p>
                </div>

                <div class="flex-container section">
                    <h3>Vertrektijd</h3>
                    <p> 
                        <%= vlucht.getVertrektijd().toLocalDate().format(dateFormatter)%> </br>
                    </p>
                </div>

                <div class="flex-container section">
                    <h3>Aankomstluchthaven</h3>
                    <p> <%= vlucht.getAankomstLuchthaven()%><br/>
                    </p>
                </div>

                <div class="flex-container section">
                    <h3>Aankomsttijd</h3>
                    <p> 
                        <%= vlucht.getAankomsttijd().toLocalDate().format(dateFormatter)%> </br>
                    </p>
                </div>

                <div class="flex-container section">
                    <h3>Code</h3>
                    <p> <%= vlucht.getCode()%><br/>
                    </p>
                </div>

                <div class="flex-container section">
                    <h3>Vliegtuig</h3>
                    <p> <%= vlucht.getVliegtuig()%><br/>
                    </p>
                </div>


            </div>
        </div>
    </body>
</html>
