/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataacces.DAPassagier;
import hbo5.it.www.dataacces.DAPersoon;
import hbo5.it.www.dataacces.DAVlucht;
import java.io.IOException;
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
            boolean loguit = Boolean.parseBoolean(request.getParameter("loguit"));

            if (loguit) {
                session.setAttribute("loggedInPersoon", null);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                
                DAPersoon daPersoon = new DAPersoon(url, login, password, driver);

                Persoon persoon = daPersoon.getPersoonVoorLogin(gebruikersnaam, wachtwoord);

                if (persoon != null) {
                    session.setAttribute("loggedInPersoon", persoon);
                    
                    if (persoon.getSoort() == 'P') {
                        DAPassagier daPassagier = new DAPassagier(url, login, password, driver);
                        DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
                        
                        Passagier passagier = daPassagier.getPassagierForPersoonID(persoon.getId());
                        //TODO Vluchten opvragen
                        request.getRequestDispatcher("pages/passagiersVluchten.jsp").forward(request, response);
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
