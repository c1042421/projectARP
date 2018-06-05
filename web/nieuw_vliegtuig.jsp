<%-- 
    Document   : nieuw_vliegtuig
    Created on : Jun 5, 2018, 10:16:05 PM
    Author     : Jozef
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Vliegtuigtype"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuw vliegtuig</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <% 
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) session.getAttribute("luchtvaartmaatschappijen");
            ArrayList<Vliegtuigtype> vliegtuigTypes = (ArrayList<Vliegtuigtype>) session.getAttribute("vliegtuigTypes");
        %>
        
        <jsp:include page="navigatieBalk.jsp"/>

        <div class="flex-container-top-center">
            <h1>Nieuw vliegtuig<hr/></h1>

            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="0"/></p>
                    
                    <p><label>Vliegtuigtype: </label>
                        <select name="typeID"> 
                            <%for (Vliegtuigtype type : vliegtuigTypes)  { %>
                            <option value="<%=type.getId()%>"><%=type.getTypenaam()%></option>
                      <%  } %>
                        </select></p>
                    <p><label>Luchtvaartmaatschappij: </label>
                        <select name="maatschappijID"> 
                            <%for (Luchtvaartmaatschappij lvm : luchtvaartmaatschappijen)  { %>
                            <option value="<%=lvm.getId()%>"><%=lvm.getLuchtvaartnaam() %></option>
                      <%  } %>
                        </select></p>
                
                    <input type="text" name="beheerpagina" hidden value="beheer_vliegtuigen"/>
                    
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_nieuw_vliegtuig"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
