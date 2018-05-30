/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.dataacces.DALand;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DALuchtvaartmaatschappij;
import hbo5.it.www.dataacces.DAVliegtuig;
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
 * @author c1042421
 */
@WebServlet(urlPatterns = {"/BeheerServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})
public class BeheerServlet extends HttpServlet {

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
            HttpSession session = request.getSession();

            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");

            DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
            DALand daLand = new DALand(url, login, password, driver);
            DAVliegtuig daVliegtuig = new DAVliegtuig(url, login, password, driver);
            DALuchtvaartmaatschappij daLuchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);

            String beheerpagina = request.getParameter("beheerpagina");
            String objectType = request.getParameter("objectType");
            
            int id = Integer.parseInt(request.getParameter("id"));
            boolean pasaan = request.getParameter("pasaan") != null;
            boolean verwijder = request.getParameter("verwijder") != null;

            if (objectType.equals("luchthaven")) {

                if (pasaan) {
                    Luchthaven l = daLuchthaven.getLuchthavenForID(id);
                    ArrayList<Land> landen = daLand.getAlleLanden();

                    session.setAttribute("editLuchthaven", l);
                    session.setAttribute("landen", landen);
                    
                } else if (verwijder) {
                    
                    daLuchthaven.verwijderLuchthavenForID(id);
                    
                    ArrayList<Luchthaven> luchthavens = daLuchthaven.getAllLuchthavens();
                    session.setAttribute("luchthavens", luchthavens);
                    
                    request.getRequestDispatcher("beheer_luchthavens.jsp").forward(request, response);
                }
            } else if (objectType.equals("vliegtuig")) {
                if (pasaan) {
                    Vliegtuig vl = daVliegtuig.getVliegtuigForID(id);
                    ArrayList<Luchtvaartmaatschappij> lvm = daLuchtvaartmaatschappij.getAlleLuchtvaartmaatschappijen();

                    session.setAttribute("editVliegtuig", vl);
                    session.setAttribute("luchtvaartmaatschappijen", lvm);
                    
                } else if (verwijder) {
                    
                    daVliegtuig.verwijderVliegtuigForID(id);
                    
                    ArrayList<Vliegtuig> vliegtuigen = daVliegtuig.getAllVliegtuigen();
                    session.setAttribute("vliegtuigen", vliegtuigen);
                    
                    request.getRequestDispatcher("beheer_vliegtuigen.jsp").forward(request, response);
                }
            }

            if (pasaan) {
                request.getRequestDispatcher(beheerpagina + ".jsp").forward(request, response);
            } 

        } catch (Exception e) {
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
