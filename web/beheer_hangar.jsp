<%-- 
    Document   : beheer_hangar
    Created on : 5-jun-2018, 15:32:21
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer vliegtuigen</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        
        <div class="flex-container-top-center">
            <h1>Beheer Hangaren<hr></h1>
        <div class="grid-container grid-2-colums">
            <form action="BeheerServlet">
                    <input type="text" hidden name="beheerpagina" value="nieuw_hangar"/>
                    <input type="text" hidden name="objectType" value="hangar"/>
                    <button name="nieuw" class="card card-hover" type="submit"><i class="fas fa-plus"> </i> Nieuwe hangar</button>
            </form>
            
            <% ArrayList<Hangar> hangaren = (ArrayList<Hangar>) session.getAttribute("hangar");%>
            <% if (!hangaren.isEmpty()) {
                    for (Hangar hangar : hangaren) {%>
                    <div class="card">
                        <h2><%= hangar.getHangarnaam() %></h2>
                        <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=hangar.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_hangar"/>
                            <input type="text" hidden name="objectType" value="hangar"/>
                            <button name="pasaan" class="button edit" type="submit"><i class="far fa-edit"></i> Pas aan</button>
                            <button name="verwijder" class="button" type="submit"><i class="fas fa-trash-alt"></i> Verwijder</button>
                        </div>
                    </form> 
                    </div>
            <%}
                }%>
        </div>
        </div>
        </div>
                
    </body>
</html>
