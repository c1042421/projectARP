<%-- 
    Document   : edit_vluchtbemanning
    Created on : Jun 3, 2018, 6:01:04 PM
    Author     : jelmarvanaert
--%>

<%@page import="hbo5.it.www.beans.VluchtBemanning"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit vluchtbemanning</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp"/>
        <div class="flex-container-top-center">
             <% 
                 Vlucht vlucht = (Vlucht) session.getAttribute("vluchtVoorBemanning"); 
                 ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) session.getAttribute("bemanningsLeden");
                 VluchtBemanning vluchtBemanning =  (VluchtBemanning) session.getAttribute("editVluchtBemanning");
             %>
            <h1> Voeg bemanningslid toe aan <%= vlucht.getCode() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="vlucht_id" value="<%= vlucht.getId() %>" hidden />
                    <input type="text" name="beheerpagina" hidden value="beheer_vluchtbemanning" />
                    <input type="text" name="id" hidden value="<%=vluchtBemanning.getId() %>" />
                    <p><label>Bemanningslid: </label>
                    <select name="bemannings_id">
                        <% for(Bemanningslid lid : bemanningsleden) {%>
                        <option value="<%=lid.getId() %>" <% if (lid.getId() == vluchtBemanning.getBemanningslid().getId() ) {%> selected <%}%> > <%= lid.getPersoon().getVolledigeNaam() %> </option>
                        <%}%>
                    </select></p>
                    <p>
                        <label>
                           Taak:
                        </label>
                        <input name="taak_id" type="text" placeholder="bv. Piloot" value="<%=vluchtBemanning.getTaak() %>"/></p>
                    </p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_vluchtbemanning"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                    
                </form>
            </div>
        </div>
    </body>
</html>
