<%-- 
    Document   : beheer_vluchtbemanning
    Created on : Jun 3, 2018, 2:21:07 PM
    Author     : jelmarvanaert
--%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="hbo5.it.www.beans.VluchtBemanning"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beheer vluchtbemanning</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center padding-bottom">
           <h1>Beheer vluchtbemanning voor vlucht <hr></h1>
           <form action="AdminServlet" class="padding-bottom">
                <select name="vlucht_id" onchange="this.form.submit();">
                <% ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) session.getAttribute("vluchten"); 
                Integer vluchtID = (Integer) session.getAttribute("vluchtID");
                for (Vlucht vlucht: vluchten) {%>
                <option value="<%= vlucht.getId() %>" <% if (vluchtID == vlucht.getId()) { %> selected <%}%>> <%= vlucht.getCode() %> </option>
                <%}%>
                </select>
                <input type="text" name="vluchbemanning" value="hello" hidden/>
            </form>
            <div class="grid-container grid-2-colums">
                <form action="BeheerServlet">
                    <input type="text" hidden name="beheerpagina" value="nieuwe_vluchtbemanning"/>
                    <input type="text" hidden name="objectType" value="vluchtbemanning"/>
                    <button name="nieuw" class="card card-hover" type="submit"><i class="fas fa-plus"> </i> Voeg bemanning toe</button>
                </form>
                 <% ArrayList<VluchtBemanning> vluchtbemanningsLeden = (ArrayList<VluchtBemanning>) session.getAttribute("vluchtbemanningsLeden");%>
                <% if (!vluchtbemanningsLeden.isEmpty()) {
                        for (VluchtBemanning bemanning : vluchtbemanningsLeden) {
                            String taak = bemanning.getTaak() != null ? bemanning.getTaak() : "Geen taak";
                %>
                <div class="card">
                    <h2><%= bemanning.getBemanningslid().getPersoon().getVolledigeNaam() %></h2>
                    <p class="text-center"><%= taak %> - <%= bemanning.getVlucht().getCode() %></p> 
                    <form action="BeheerServlet">
                        <div class="flex-container-center-center flex-row"> 
                            <input type="text" hidden name="id" value="<%=bemanning.getId()%>"/>
                            <input type="text" hidden name="beheerpagina" value="edit_vluchtbemanning"/>
                            <input type="text" hidden name="objectType" value="vluchtbemanning"/>
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
