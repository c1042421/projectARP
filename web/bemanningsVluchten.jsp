<%-- 
    Document   : bemanningsVluchten
    Created on : 2-mei-2018, 11:32:22
    Author     : c1042410
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="hbo5.it.www.beans.VluchtBemanning"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bemanningsvluchten</title>
        <jsp:include page="imports.jsp" />
    </head>
    
    <body>       
          <jsp:include page="navigatieBalk.jsp" />
          
            <div class="flex-container-top-center">
                <h2>Mijn Reisschema <hr/></h2>
            
                <% ArrayList<VluchtBemanning> bemanningsleden = (ArrayList<VluchtBemanning>) session.getAttribute("vluchtbemanning"); 
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                        //DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                if (bemanningsleden != null && bemanningsleden.size() > 0) {
                    for (VluchtBemanning vlubem : bemanningsleden) {
                    Vlucht vlucht = vlubem.getVlucht(); 
                    LocalDate localdate = vlucht.getAankomsttijd().toLocalDate(); %>
                    <div class="vlucht card flex-container" >
                        <div>
                            <h3> Vlucht <%= vlucht.getCode() %> </h3>
                        </div>
                        <div class="flex-container flex-row">
                            <div class="flex-container section">
                                <h3>Van</h3>
                                <p> <%= vlucht.getVertrekLuchthaven().getLand().getLandnaam() %> - <%= vlucht.getVertrekLuchthaven().getStad() %><br/>
                                    <%= vlucht.getVertrekLuchthaven().getLuchthavennaam() %> <br/>
                                    op: <%= vlucht.getVertrektijd().toLocalDate().format(dateFormatter) %>
                                </p>
                            </div>
                            <div class="flex-container middle">
                                <img src="images/ic_plane.svg" />
                            </div>
                            <div class="flex-container section">
                                <h3>Naar</h3>
                                <p> <%= vlucht.getAankomstLuchthaven().getLand().getLandnaam() %>  - <%= vlucht.getAankomstLuchthaven().getStad()%><br/>
                                <%= vlucht.getAankomstLuchthaven().getLuchthavennaam() %><br/>
                                op: <%= vlucht.getAankomsttijd().toLocalDate().format(dateFormatter) %><br/>
                                </p>
                               

                            </div>
                        </div>
                        <div class="flex-container flex-row">
                            <a href="#" class="button"><i class="fas fa-plane"> </i> Details </a>
                            <form action="ManageServlet">
                                <button name="toonPassagiers" type="submit"><i class="fas fa-users"> </i> Passagiers</button>
                            </form>
                        </div>
                    </div>
                    <%}
                } else {%>
                    <p>Geen reisschema beschikbaar.</p>
                <%}%>
            </div>   
    </body>
</html>
