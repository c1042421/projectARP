<%-- 
    Document   : beheer_vliegtuigen
    Created on : 30-mei-2018, 10:17:23
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer vliegtuigen</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        
        <div class="flex-container-top-center">
            <h1>Beheer Vliegtuigen<hr></h1>
        <div class="grid-container grid-2-colums">
            
            <form action="BeheerServlet">
                    <input type="text" hidden name="beheerpagina" value="nieuw_vliegtuig"/>
                    <input type="text" hidden name="objectType" value="vliegtuig"/>
                    <button name="nieuw" class="card card-hover" type="submit"><i class="fas fa-plus"> </i> Nieuw vliegtuig</button>
                </form>
            
            <% ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) session.getAttribute("vliegtuigen");%>
            <% if (!vliegtuigen.isEmpty()) {
                    for (Vliegtuig vliegtuig : vliegtuigen) {%>
                    <div class="card">
                        <h2><%= vliegtuig.getVliegtuigtype().getTypenaam()%></h2>
                        <p class="text-center"><%=vliegtuig.getLuchtvaartmaatschappij().getLuchtvaartnaam()%></p>
                        <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=vliegtuig.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_vliegtuig"/>
                            <input type="text" hidden name="objectType" value="vliegtuig"/>
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
