<%-- 
    Document   : login
    Created on : 24-apr-2018, 13:41:31
    Author     : c1042421
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="../style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
         <nav>
            
        </nav>
        <div class="container">
                <form action="../InlogServlet">
                    <div class="login">
                        <p><label>Gebruikersnaam: </label> <br> <input type="text" name="gebruikersnaam" placeholder="vb. jelmar"/></p>
                        <p><label>Wachtwoord: </label> <br> <input type="password" name="password" placholder="Wachtwoord"/></p>
                        <p><input type="submit" value="Inloggen"/></p>
                     </div>
                </form>
        </div>
    </body>
</html>
