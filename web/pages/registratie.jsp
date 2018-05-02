<%-- 
    Document   : registratie
    Created on : 24-apr-2018, 13:18:48
    Author     : c1042410
--%>

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
        <nav>
            <a href ="../index.jsp"><i class="fas fa-user"> </i> Home</a>
        </nav>
        <div class="container">
            <form action="../RegistratieServlet">
                
                <div class="container">
                <div class="registratie">
                <p>
                    <label>Voornaam:</label> <br>
                    <input type="text" name="Voornaam" placeholder="vb. Gert"/> 
                </p>
                
                <p>
                    <label>Familienaam:</label> <br>
                    <input type="text" name="Familienaam" placeholder="vb. Verhulst"/>
                </p>
                
                <p>
                    <label>Geboortedatum:</label> <br>
                    <input type="date" name="Geboortedatum"/>
                </p>
                </div>
                
                <div class="registratie">
                <p>
                    <label>Straat:</label> <br>
                    <input type="text" name="Straat" placeholder="vb. Dorpstraat"/>
                </p>
                <p>
                    <label>Huisnummer:</label> <br>
                    <input type="text" name="Huisnummer" placeholder="vb. 101"/>
                </p>
                <p>
                    <label>Postcode:</label> <br>
                    <input type="text" name="Postcode" placeholder="vb. 2540"/>
                </p>
                <p>
                    <label>Woonplaats:</label> <br>
                    <input type="text" name="Woonplaats" placeholder="vb. Hove"/>
                </p>
                <p>
                    <label>Land:</label> <br>
                    <input type="text" name="Land" placeholder="vb. België"/>
                </p>
                </div>
                
                
                <div class="registratie">
                <p>
                    <label>Gebruikersnaam:</label> <br>
                    <input type="text" name="Gebruikersnaam" placeholder="vb. gertStudio100"/>
                </p>
            
                <p>
                    <label>Wachtwoord:</label> <br>
                    <input type="password" name="Wachtwoord" placeholder="vb. Test123"/>
                </p>
                <p>
                    <label>Bevestig wachtwoord:</label> <br>
                    <input type="password" name="bevestigWachtwoord" placeholder="vb. Test123"/>
                </p>
                </div>
                <p>
                    <input class="registreerKnop" type="submit" value="Registreer"/>
                </p>
                
            </form>
            </div>
        
    </body>
</html>
