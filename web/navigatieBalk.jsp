<%-- 
    Document   : navigatieBalk
    Created on : 23-mei-2018, 9:56:02
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<% Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon"); %>
        <nav>
            <div class="flex-container-center-center flex-row"> <img class="nav-logo left-margin" src="images/travel.svg" /> 
                <a class="left-margin flex-container-center-center flex-row menu" href="index.jsp">
                    <i class="fas fa-home"> </i>
                    <p>Home</p>
                </a>
                <form action="StartServlet">
                    <button class="left-margin menu" type="submit">
                        <i class="fas fa-chart-pie"></i>
                        Zoek Vluchten
                    </button>
                </form>
               <a class="left-margin flex-container-center-center flex-row menu" href="passagiersVluchten.jsp">
                    <i class="fas fa-plane"> </i>
                    <p>Mijn Vluchten</p>
                </a>
                <%if (persoon != null && persoon.getSoort() == 'B') { %>
                <a class="left-margin flex-container-center-center flex-row menu" href="bemanningsVluchten.jsp">
                    <i class="fas fa-plane"> </i>
                    <p>Mijn Reisschema</p>
                </a>
                <%}%>
                <% if (persoon != null && persoon.getSoort() == 'A') { %>
                <a class="left-margin flex-container-center-center flex-row menu" href="admin.jsp">
                    <i class="fas fa-book"></i>
                    <p>Beheer</p>
                </a>
                <form action="StatistiekenServlet">
                    <button class="left-margin menu" type="submit">
                        <i class="fas fa-chart-pie"></i>
                        Statistieken
                    </button>
                </form>
                <!--<a class="left-margin flex-container-center-center flex-row menu" href="statistieken.jsp">
                    <i class="fas fa-chart-pie"></i>
                    <p>Statistieken</p>
                </a>-->
                <%}%>
            </div> </div>
            <div class="flex-container-center-center flex-row">
             <% if (persoon != null) { %>
                <p> Welkom <%= persoon.getVoornaam() %></p>
                <form action="InlogServlet">
                    <button type="submit" name="loguit" class="button"><i class="fas fa-sign-out-alt"> </i> Log uit</button>
                </form>
             <% } else {%>
                <a href="login.jsp" class="button"><i class="fas fa-sign-in-alt"> </i> Log in</a>
                <a href="registratie.jsp" class="button"><i class="fas fa-user-plus"> </i> Registreer</a>
            <% } %>
            </div>
</nav>
