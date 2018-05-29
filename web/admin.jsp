<%-- 
    Document   : admin
    Created on : 23-mei-2018, 9:52:51
    Author     : c1042421
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet" type="text/css" href="style/style.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="navigatieBalk.jsp" />
        <div class="flex-container-top-center">
            <h1>Beheer <hr/> </h1>
            <div class="w960">
                <form action="AdminServlet">
                    <div class="grid-container">
                        <button type="submit" class="adminCard luchthaven" name="luchthavens"> Luchthavens </button>
                        <button type="submit" class="adminCard airline" name="airline"> Luchtvaartmaatschappij </button>
                        <button type="submit" class="adminCard airplane" name="vliegtuig"> Vliegtuigen </button>
                        <button type="submit" class="adminCard hangar" name="hangar"> Hangar </button>
                        <button type="submit" class="adminCard crew" name="bemanning"> Bemanning </button>
                        <button type="submit" class="adminCard air-crew" name="vluchbemanning"> VluchtBemanning </button>
                        <div></div>
                        <button type="submit" class="adminCard vliegtuig-in-hanger" name="vliegtuigInHangar"> Vliegtuigen in hangar </button>
                    </div>
                </form>
            </div>
        </div>


    </body>
</html>
