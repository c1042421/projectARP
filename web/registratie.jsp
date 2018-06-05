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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registreren</title>
        <jsp:include page="imports.jsp" />
    </head>
    <body>
         <jsp:include page="navigatieBalk.jsp" />
         
        <form action="RegistratieServlet" method="post">
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
                    <input type="date" required pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}" name="Geboortedatum" placeholder="1970/05/27"/>
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
                    <button type="submit" class="button"><i class="fas fa-user-plus"> </i> Registreren </button>
                </p>
           </div>
        </form>
    </body>
</html>
