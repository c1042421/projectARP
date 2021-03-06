<%-- 
    Document   : mijnVluchten
    Created on : 2-mei-2018, 11:27:38
    Author     : c1042421
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Date"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mijn Vluchten</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center">
            <h2>Mijn vluchten <hr/></h2>

            <% ArrayList<Passagier> passagiers = (ArrayList<Passagier>) session.getAttribute("passagiers");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (passagiers != null && passagiers.size() > 0) {

                    for (Passagier passagier : passagiers) {
                        Vlucht vlucht = passagier.getVlucht();
                        LocalDate localdate = vlucht.getAankomsttijd().toLocalDate();%>
            <div class="vlucht card flex-container">
                <div>
                    <h3> Vlucht <%= vlucht.getCode()%> </h3>
                </div>
                <div class="flex-container flex-row">
                    <div class="flex-container section">
                        <h3>Van</h3>
                        <p> <%= vlucht.getVertrekLuchthaven().getLand().getLandnaam()%> - <%= vlucht.getVertrekLuchthaven().getStad()%><br/>
                            <%= vlucht.getVertrekLuchthaven().getLuchthavennaam()%> <br/>
                            op: <%= vlucht.getVertrektijd().toLocalDate().format(dateFormatter)%>
                        </p>
                    </div>
                    <div class="flex-container middle">
                        <img src="images/ic_plane.svg" />
                    </div>
                    <div class="flex-container section">
                        <h3>Naar</h3>
                        <p> <%= vlucht.getAankomstLuchthaven().getLand().getLandnaam()%>  - <%= vlucht.getAankomstLuchthaven().getStad()%><br/>
                            <%= vlucht.getAankomstLuchthaven().getLuchthavennaam()%><br/>
                            op: <%= vlucht.getAankomsttijd().toLocalDate().format(dateFormatter)%><br/>
                        </p>
                    </div>
                </div>
                <div class="flex-container flex-row">
                    <a href="details.jsp" class="button"><i class="fas fa-plane"> </i> Details </a>
                    <%  java.util.Date utilDate = new java.util.Date();
                        Date date = new Date(utilDate.getTime());
                        if (vlucht.getVertrektijd().after(date)) {%>
                    <form action="ManageServlet">
                        <input type="hidden" name="vluchtID" value=<%= vlucht.getId()%>>
                        <button type="submit" name="annuleerVlucht"><i class="fas fa-times"> </i> Annuleren</button>
                    </form>
                    <%}%>
                </div>
                
                </div>
                <%}%>

                <%} else if (persoon == null) {%>
                <p class="text-center"> U bent niet ingelogd. <br> Log in om uw vluchten te kunnen bekijken.</p>
                <a class="button" href="login.jsp"><i class="fas fa-sign-in-alt"> </i> Log in</a>
                <%} else {%>
                <p>U heeft geen vluchten geboekt.</p>
                <%}%>
            </div>
    </body>
</html>
