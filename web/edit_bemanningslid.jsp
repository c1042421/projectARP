<%-- 
    Document   : edit_bemanningslid
    Created on : May 31, 2018, 4:15:18 PM
    Author     : jelmarvanaert
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Bemanningslid</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
       <jsp:include page="navigatieBalk.jsp"/>
        <% 
            Bemanningslid lid = (Bemanningslid) session.getAttribute("editbemanningslid");
            ArrayList<Functie> functies = (ArrayList<Functie>) session.getAttribute("functies");
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) session.getAttribute("luchtvaartmaatschappijen");
        %>
        
        <div class="flex-container-top-center">
            <h1> <%= lid.getPersoon().getVolledigeNaam() %><hr/></h1>
            
            <div class="card">
                <form action="SaveServlet">
                    <input type="text" name="id" hidden value="<%= lid.getId()%>"/>
                    <input type="text" name="persoon_id" hidden value="<%= lid.getPersoon().getId() %>"/>
                    <input type="text" name="beheerpagina" hidden value="beheer_bemanning"/>
                    <p>
                        <label>Voornaam: </label>
                        <input type="text" name="Voornaam" value="<%=lid.getPersoon().getVoornaam() %>" />
                    </p>
                    
                    <p>
                        <label>Achternaam: </label>
                        <input type="text" name="Familienaam" value="<%=lid.getPersoon().getFamilienaam()%>" />
                    </p>
                    
                    <p>
                        <label>Geboortedatum </label>
                        <input type="date" name="Geboortedatum" value="<%=lid.getPersoon().getGeboortedatum() %>" />
                    </p>
                    
                    <p>
                        <label>Straat: </label>
                        <input type="text" name="Straat" value="<%=lid.getPersoon().getStraat() %>" />
                    </p>
                    
                    <p>
                        <label>Huisnummer: </label>
                        <input type="text" name="Huisnummer" value="<%=lid.getPersoon().getHuisnr()%>" />
                    </p>
                    
                    <p>
                        <label>Woonplaats: </label>
                        <input type="text" name="Woonplaats" value="<%=lid.getPersoon().getWoonplaats()%>" />
                    </p>
                    
                    <p>
                        <label>Postcode: </label>
                        <input type="text" name="Postcode" value="<%=lid.getPersoon().getPostcode()%>" />
                    </p>
                    
                    <p>
                        <label>Land: </label>
                        <input type="text" name="Land" value="<%=lid.getPersoon().getLand()%>" />
                    </p>
                    
                    <p><label>Functie: </label>
                    <select name="functie_id">
                        <% for(Functie functie : functies) { 
                            if (functie.getId() == lid.getFunctie_id()) {
                        %>
                            <option selected value="<%=functie.getId() %>"><%= functie.getFunctienaam()%></option>
                        <%} else {%>
                            <option value="<%=functie.getId() %>"><%= functie.getFunctienaam()%></option>
                        <%}}%>
                    </select></p>
                    <p><label>Luchtvaartmaatschappij: </label>
                    <select name="lvm_id">
                        <% for(Luchtvaartmaatschappij lvm : luchtvaartmaatschappijen) { 
                            if (lvm.getId() == lid.getLuchtvaartmaatschappij_id()) {
                        %>
                            <option selected value="<%=lvm.getId() %>"><%= lvm.getLuchtvaartnaam()%></option>
                        <%} else {%>
                            <option value="<%=lvm.getId() %>"><%= lvm.getLuchtvaartnaam()%></option>
                        <%}}%>
                    </select></p>
                    <div class="flex-container-center-center"> 
                        <button class="button" type="submit" name="save_bemanningslid"><i class="fas fa-save"> </i> Opslaan</button> 
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
