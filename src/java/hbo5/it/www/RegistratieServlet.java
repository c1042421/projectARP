/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataacces.DAPersoon;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c1042410
 */
@WebServlet(urlPatterns = {"/RegistratieServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
, @WebInitParam(name = "password", value = "1234")})

public class RegistratieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String voornaam = request.getParameter("Voornaam");
        String familienaam = request.getParameter("Familienaam");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String geboortedatum = request.getParameter("Geboortedatum");
        
        java.util.Date parsedGeboortedatum = null;
        try {
            
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");

            parsedGeboortedatum = sdf.parse(geboortedatum);
            
            HttpSession session = request.getSession();
        
            java.sql.Date sqlData = new java.sql.Date(parsedGeboortedatum.getTime());
        
            String straat = request.getParameter("Straat");
            String huisnummer = request.getParameter("Huisnummer");
            String postcode = request.getParameter("Postcode");
            String woonplaats = request.getParameter("Woonplaats");
            String land = request.getParameter("Land");
        
            String gebruikersnaam = request.getParameter("Gebruikersnaam");
            String wachtwoord = request.getParameter("Wachtwoord");
            String bevestigWachtwoord = request.getParameter("bevestigWachtwoord");
        
            Persoon p = new Persoon();
            p.setVoornaam(voornaam);
            p.setFamilienaam(familienaam);
            p.setGeboortedatum(sqlData);
            p.setStraat(straat);
            p.setHuisnr(huisnummer);
            p.setPostcode(postcode);
            p.setWoonplaats(woonplaats);
            p.setLand(land);
        
        
            DAPersoon daPersoon = new DAPersoon(url, login, password, driver);
            
            if (wachtwoord.equals(bevestigWachtwoord)) {
                p.setLogin(gebruikersnaam);
                p.setPaswoord(wachtwoord);
                boolean registratieGelukt = daPersoon.voegGebruikerToe(p);
                if (registratieGelukt) {
                    
                }
            }
            //ELSE + error message nog toevoegen
            }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
