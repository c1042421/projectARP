/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.dataacces.DABemanningslid;
import hbo5.it.www.dataacces.DAFunctie;
import hbo5.it.www.dataacces.DAHangar;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DALuchtvaartmaatschappij;
import hbo5.it.www.dataacces.DAVliegtuig;
import hbo5.it.www.dataacces.DAPersoon;
import hbo5.it.www.dataacces.DAStockage;
import hbo5.it.www.dataacces.DAVlucht;
import hbo5.it.www.dataacces.DAVluchtBemanning;
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


@WebServlet(urlPatterns = {"/AdminServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})
public class AdminServlet extends HttpServlet {

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

            DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
            DABemanningslid daBemanning = new DABemanningslid(url, login, password, driver);

            DAVliegtuig daVliegtuig = new DAVliegtuig(url, login, password, driver);
            DALuchtvaartmaatschappij daLuchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            DAPersoon daPersoon = new DAPersoon(url, login, password, driver);
            DAFunctie daFunctie = new DAFunctie(url, login, password, driver);
            DAVluchtBemanning daVluchtBemanning = new DAVluchtBemanning(url, login, password, driver);
            DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
            DAStockage daStockage = new DAStockage(url, login, password, driver);
            DAHangar daHangar = new DAHangar(url, login, password, driver);

            boolean toonLuchthavens = request.getParameter("luchthavens") != null;
            boolean toonBemanning = request.getParameter("bemanning") != null;
            boolean toonVluchtBemanning = request.getParameter("vluchbemanning") != null;
            boolean toonVliegtuigenInHangar = request.getParameter("vliegtuigInHangar") != null;
            boolean toonVliegtuigen = request.getParameter("vliegtuig") != null;
            boolean toonHangaren = request.getParameter("hangar") != null;

            if (toonBemanning) {

                ArrayList<Bemanningslid> bemanning = daBemanning.getAlleBemanningsLeden();
                session.setAttribute("bemanning", bemanning);

                request.getRequestDispatcher("beheer_bemanning.jsp").forward(request, response);
            } else if (toonLuchthavens) {

                ArrayList<Luchthaven> luchthavens = daLuchthaven.getAllLuchthavens();
                session.setAttribute("luchthavens", luchthavens);
                request.getRequestDispatcher("beheer_luchthavens.jsp").forward(request, response);
            } else if (toonVluchtBemanning) {

                String vluchtIDString = request.getParameter("vlucht_id");
                int vluchtID = 1;
                if (vluchtIDString != null) {
                    vluchtID = Integer.parseInt(vluchtIDString);
                }
                session.setAttribute("vluchtID", vluchtID);

                ArrayList<Vlucht> vluchten = daVlucht.getAlleVluchten();
                session.setAttribute("vluchten", vluchten);

                ArrayList<VluchtBemanning> vluchtbemanningsLeden = daVluchtBemanning.getVluchtbemanningForVluchtID(vluchtID);
                session.setAttribute("vluchtbemanningsLeden", vluchtbemanningsLeden);
                request.getRequestDispatcher("beheer_vluchtbemanning.jsp").forward(request, response);
            } else if (toonVliegtuigenInHangar) {

                ArrayList<Stockage> stockages = daStockage.getAlleStockages();
                session.setAttribute("stockages", stockages);

                request.getRequestDispatcher("beheer_stockage.jsp").forward(request, response);

            } else if (toonVliegtuigen) {
                ArrayList<Vliegtuig> vliegtuigen = daVliegtuig.getAlleVliegtuigen();
                session.setAttribute("vliegtuigen", vliegtuigen);
                request.getRequestDispatcher("beheer_vliegtuigen.jsp").forward(request, response);
                
            }else if (toonHangaren) {
                ArrayList<Hangar> hangaren = daHangar.getAlleHangars();
                session.setAttribute("hangar", hangaren);
                
                request.getRequestDispatcher("beheer_hangar.jsp").forward(request, response);
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
