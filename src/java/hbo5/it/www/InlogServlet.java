/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataacces.DABemanningslid;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.dataacces.DALand;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DAPassagier;
import hbo5.it.www.dataacces.DAPersoon;
import hbo5.it.www.dataacces.DAVliegtuig;
import hbo5.it.www.dataacces.DAVliegtuigklasse;
import hbo5.it.www.dataacces.DAVlucht;
import hbo5.it.www.dataacces.DAVluchtBemanning;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c1042421
 */
@WebServlet(urlPatterns = {"/InlogServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
, @WebInitParam(name = "password", value = "1234")})
public class InlogServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");

            HttpSession session = request.getSession();

            String gebruikersnaam = request.getParameter("gebruikersnaam");
            String wachtwoord = request.getParameter("password");
            boolean loguit = request.getParameter("loguit") != null;

            if (loguit) {
                session.setAttribute("loggedInPersoon", null);
                session.setAttribute("passagiers", null);
                session.setAttribute("vluchtbemanning", null);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                
                DAPersoon daPersoon = new DAPersoon(url, login, password, driver);

                Persoon persoon = daPersoon.getPersoonVoorLogin(gebruikersnaam, wachtwoord);
                

                if (persoon != null) {
                    session.setAttribute("loggedInPersoon", persoon);
                    DAPassagier daPassagier = new DAPassagier(url, login, password, driver);
                        DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
                        DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
                        DAVliegtuig daVliegtuig = new DAVliegtuig(url, login, password, driver);
                        DAVliegtuigklasse daVliegtuigKlasse = new DAVliegtuigklasse(url, login, password, driver);
                        
                    if (persoon.getSoort() == 'P') {
                        ArrayList<Passagier> passagiers = daPassagier.getPassagiersForPersoonID(persoon.getId());
                        passagiers = daVlucht.voegVluchtenVoorPassagiersToe(passagiers);
                        passagiers = daVliegtuig.voegVliegtuigToeVoorVlucht(passagiers);
                        passagiers = daVliegtuigKlasse.voegVliegtuigKlasseVoorPassagiersToe(passagiers);
                        passagiers = daLuchthaven.voegLuchtavensToeAanPassagiersVlucht(passagiers);
                        
                        session.setAttribute("passagiers", passagiers);
                                                
                        request.getRequestDispatcher("passagiersVluchten.jsp").forward(request, response);
                    }
                    else if (persoon.getSoort() == 'B'){
                        DABemanningslid daBemanningslid = new DABemanningslid(url, login, password, driver);
                        Bemanningslid bemanningslid = daBemanningslid.getBemanningForPersoonID(persoon.getId());
                        
                        DAVluchtBemanning daVluchtBemanning = new DAVluchtBemanning(url, login, password, driver);
                        ArrayList<VluchtBemanning> vluchtbemanning = daVluchtBemanning.getVluchtbemmanningForBemanningsID(bemanningslid.getId());
                        
                        vluchtbemanning = daVlucht.voegVluchtenVoorBemanningToe(vluchtbemanning);
                        vluchtbemanning = daVliegtuig.voegVliegtuigToeVoorBemanning(vluchtbemanning);
                        vluchtbemanning = daLuchthaven.voegLuchthavensToeAanBemanning(vluchtbemanning);
                        
                        session.setAttribute("vluchtbemanning", vluchtbemanning);
                        request.getRequestDispatcher("bemanningsVluchten.jsp").forward(request, response);
                    }
                    
                } else {
                    //TODO User feedback not found
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InlogServlet.class.getName()).log(Level.SEVERE, null, ex);
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
