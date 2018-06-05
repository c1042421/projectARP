<%-- 
    Document   : edit_vliegtuig
    Created on : 30-mei-2018, 11:22:55
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Vliegtuigtype"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        
        <% 
            Vliegtuig vl = (Vliegtuig) session.getAttribute("editVliegtuig");
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) session.getAttribute("luchtvaartmaatschappijen");
            ArrayList<Vliegtuigtype> vliegtuigTypes = (ArrayList<Vliegtuigtype>) session.getAttribute("vliegtuigTypes");
        %>
        
        <div class="flex-container-top-center">
            <h1> <%= vl.getVliegtuigtype().getTypenaam() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= vl.getId()%>"/></p>
                    <input type="text" name="beheerpagina" hidden value="beheer_vliegtuigen"/>
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
                    
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_vliegtuig"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
                    
    </body>
</html>
