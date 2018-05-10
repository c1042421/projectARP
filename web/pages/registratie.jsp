<%-- 
    Document   : registratie
    Created on : 24-apr-2018, 13:18:48
    Author     : c1042410
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registreren</title>
    </head>
    <body>
        <% 
           Persoon persoon = (Persoon) session.getAttribute("loggedInPersoon");      
        %>
        <nav>
            <div class="flex-container-center-center">
                <a class="left-margin flex-container-center-center flex-row home" href="../index.jsp">
                     <img class="nav-logo left-margin" src="../images/travel.svg" /> 
                     <p>Home</p>
                </a></div>
            <div class="flex-container-center-center flex-row"> <% if (persoon != null) { %>
                <p> Welkom <%= persoon.getVoornaam() %></p>
                <form action="../InlogServlet">
                    <button type="submit" name="loguit"><i class="fas fa-sign-out-alt"> </i> Log uit</button>
                </form>
             <% } else {%>
                <a href="login.jsp" class="button"><i class="fas fa-sign-in-alt"> </i> Log in</a>
            <% } %>
            </div>
        </nav>
        <form action="../RegistratieServlet" method="post">
        <div class="flex-container-top-center">
            <h2>Registreer</h2>
            <div class="flex-container flex-row">
                <div class="card">
                    <h3>Persoonlijke gegevens <hr/></h3>
                <p>
                    <label>Voornaam:</label> <br>
                    <input autofocus required type="text" name="Voornaam" placeholder="vb. Gert"/> 
                </p>
                
                <p>
                    <label>Familienaam:</label> <br>
                    <input required type="text" name="Familienaam" placeholder="vb. Verhulst"/>
                </p>
                
                <p>
                    <label>Geboortedatum:</label> <br>
                    <input required type="date" name="Geboortedatum"/>
                </p>
                </div>
                
                <div class="card">
                    <h3>Adres <hr/></h3>
                <p>
                    <label>Straat:</label> <br>
                    <input required type="text" name="Straat" placeholder="vb. Dorpstraat"/>
                </p>
                <p>
                    <label>Huisnummer:</label> <br>
                    <input required type="text" name="Huisnummer" placeholder="vb. 101"/>
                </p>
                <p>
                    <label>Postcode:</label> <br>
                    <input required type="text" name="Postcode" placeholder="vb. 2540"/>
                </p>
                <p>
                    <label>Woonplaats:</label> <br>
                    <input required type="text" name="Woonplaats" placeholder="vb. Hove"/>
                </p>
                <p>
                    <label>Land:</label> <br>
                    <input required type="text" name="Land" placeholder="vb. België"/>
                </p>
                </div>
                
                
                <div class="card">
                    <h3>Login gegevens<hr/></h3>
                <p>
                    <label>Gebruikersnaam:</label> <br>
                    <input required type="text" name="Gebruikersnaam" placeholder="vb. gertStudio100"/>
                </p>
            
                <p>
                    <label>Wachtwoord:</label> <br>
                    <input required type="password" name="Wachtwoord" placeholder="vb. Test123"/>
                </p>
                <p>
                    <label>Bevestig wachtwoord:</label> <br>
                    <input required type="password" name="bevestigWachtwoord" placeholder="vb. Test123"/>
                </p>
                </div>
                
               </div>
                <p>
                    <button type="submit"><i class="fas fa-user-plus"> </i> Registreren </button>
                </p>
           </div>
        </form>
    </body>
</html>
