/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DAPassagier;
import hbo5.it.www.dataacces.DAVlucht;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jelmarvanaert
 */
@WebServlet(urlPatterns = {"/StatistiekenServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})
public class StatistiekenServlet extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();

            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");
            
            DAPassagier daPassagier = new DAPassagier(url, login, password, driver);
            DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
            DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
            
            String luchthavenIDString = request.getParameter("luchthaven_id");
            Integer luchtHavenIDFromSession = (Integer)session.getAttribute("luchthavenID");
            
            luchtHavenIDFromSession = luchtHavenIDFromSession != null ? luchtHavenIDFromSession : 1;
            
            int luchthavenID = luchthavenIDString != null ? Integer.parseInt(luchthavenIDString) : luchtHavenIDFromSession;
            session.setAttribute("luchthavenID", luchthavenID);
            
            String vluchtIDString = request.getParameter("vlucht_id");
            Integer vluchtIDFromSession = (Integer)session.getAttribute("vluchtID");
            
            vluchtIDFromSession = vluchtIDFromSession != null ? vluchtIDFromSession : 1;
      
            int vluchtID = vluchtIDString != null ? Integer.parseInt(vluchtIDString) : vluchtIDFromSession;
            session.setAttribute("vluchtID", vluchtID);
            
            int aantalPassagiersPerVlucht = daPassagier.getPassagiersForVluchtID(vluchtID).size();
            session.setAttribute("aantalPassagiersPerVlucht", aantalPassagiersPerVlucht);
            
            ArrayList<Vlucht> vluchten = daVlucht.getAlleVluchten();
            session.setAttribute("vluchten", vluchten);
            ArrayList<Luchthaven> luchthavens = daLuchthaven.getAllLuchthavens();
            session.setAttribute("luchthavens", luchthavens);
            int gemiddledeLeeftijd = daPassagier.getPassagiersGemiddeldeLeeftijdForAankomstLuchthaven(luchthavenID);
            session.setAttribute("gemiddeldeLeeftijd", gemiddledeLeeftijd);
            
            request.getRequestDispatcher("statistieken.jsp").forward(request, response);
            
        } catch (Exception e) {
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
