<%-- 
    Document   : overzichtVluchten
    Created on : 5-jun-2018, 10:26:16
    Author     : Axel
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
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
        
        <h2>Gevonden vluchten: <hr/></h2>
        <div class="grid-container grid-2-colums">
            <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute("vluchten");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (vluchten != null && vluchten.size() > 0) {

                    for (Vlucht vlucht : vluchten) {

                        LocalDate localdate = vlucht.getAankomsttijd().toLocalDate();%>
        <div class="vlucht card flex-container" >
            <div>
                <h3> Vlucht <%= vlucht.getCode()%> </h3>
            </div>
            <div class="flex-container flex-row">
                <div class="flex-container section">
                    <h3>Van</h3>
                    <p> <%= vlucht.getVertrekLuchthaven()%><br/>
                        <%= vlucht.getVertrekLuchthaven()%> <br/>
                        op: <%= vlucht.getVertrektijd().toLocalDate().format(dateFormatter)%>
                    </p>
                </div>
                <div class="flex-container middle">
                    <img src="images/ic_plane.svg" />
                </div>
                <div class="flex-container section">
                    <h3>Naar</h3>
                    <p> <%= vlucht.getAankomstLuchthaven()%><br/>
                        <%= vlucht.getAankomstLuchthaven()%><br/>
                        op: <%= vlucht.getAankomsttijd().toLocalDate().format(dateFormatter)%><br/>
                    </p>
                </div>
            </div>
            <div class="flex-container flex-row">
                 <form action="DetailServlet">
                     <button type="submit" class="button" name="boeken">Boek deze vlucht</button>
                     <button type="submit" class="button" name="details">Details</button>
                     <input type="hidden" name="vluchtID" value=<%= vlucht.getId()%>>
                </form>
            </div>

        </div>

        <%}%>
        <div>
            <%} else {%>
            <p>Er zijn geen vluchten gevonden.</p>
            <%}%>
        </div>
        </div>



    </body>
</html>
