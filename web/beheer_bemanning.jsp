<%-- 
    Document   : beheer_bemanning
    Created on : 29-mei-2018, 12:55:57
    Author     : c1042421
--%>

<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer bemanning</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center padding-bottom">
            <% Bemanningslid teVerwijderenLid = (Bemanningslid) session.getAttribute("bemanningslid");
                if (teVerwijderenLid != null){
            %>
            <div class="error"><p class="text-center">Kan <%= teVerwijderenLid.getPersoon().getVolledigeNaam() %> niet verwijderen. <%= teVerwijderenLid.getPersoon().getVoornaam() %> heeft nog vluchten.</p></div>
            <%}%>
            <h1>Beheer Bemanning<hr></h1>
            <div class="grid-container grid-2-colums">
                <form action="BeheerServlet">
                    <input type="text" hidden name="beheerpagina" value="nieuw_bemanningslid"/>
                    <input type="text" hidden name="objectType" value="bemanningslid"/>
                    <button name="nieuw" class="card card-hover" type="submit"><i class="fas fa-plus"> </i> Nieuw Bemanningslid</button>
                </form>
                <%
                    ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) session.getAttribute("bemanning");
                    
                    if (!bemanningsleden.isEmpty()) {
                        for (Bemanningslid lid : bemanningsleden) {%>
                <div class="card">
                    <h2><%= lid.getPersoon().getVolledigeNaam()%> </h2>
                    <p class="text-center"><%= lid.getFunctie().getFunctienaam()%></p>
                    <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=lid.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_bemanningslid"/>
                            <input type="text" hidden name="objectType" value="bemanningslid"/>
                            <button name="pasaan" class="button edit" type="submit"><i class="far fa-edit"></i> Pas aan</button>
                            <button name="verwijder" class="button" type="submit"><i class="fas fa-trash-alt"></i> Verwijder</button>
                        </div>
                    </form> 
                </div>
                <%}
                    }%>
            </div>
        </div>
    </body>
</html>
