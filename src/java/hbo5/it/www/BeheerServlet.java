/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.dataacces.DABemanningslid;
import hbo5.it.www.dataacces.DAFunctie;
import hbo5.it.www.dataacces.DALand;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DALuchtvaartmaatschappij;
import hbo5.it.www.dataacces.DAVlucht;
import hbo5.it.www.dataacces.DAVluchtBemanning;
import java.io.IOException;
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
            DAFunctie daFunctie = new DAFunctie(url, login, password, driver);
            DALuchtvaartmaatschappij daLuchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            DABemanningslid daBemanningslid = new DABemanningslid(url, login, password, driver);
            DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
            DAVluchtBemanning daVluchtBemanning = new DAVluchtBemanning(url, login, password, driver);

            String beheerpagina = request.getParameter("beheerpagina");
            String objectType = request.getParameter("objectType");

            int id = request.getParameter("id") != null
                    ? Integer.parseInt(request.getParameter("id"))
                    : 0;
            boolean pasaan = request.getParameter("pasaan") != null;
            boolean verwijder = request.getParameter("verwijder") != null;
            boolean nieuw = request.getParameter("nieuw") != null;

            if (objectType.equals("luchthaven")) {

                if (pasaan || nieuw) {
                    ArrayList<Land> landen = daLand.getAlleLanden();
                    session.setAttribute("landen", landen);

                    if (pasaan) {
                        Luchthaven l = daLuchthaven.getLuchthavenForID(id);
                        session.setAttribute("editLuchthaven", l);
                    }
                } else if (verwijder) {

                    daLuchthaven.verwijderLuchthavenForID(id);

                    ArrayList<Luchthaven> luchthavens = daLuchthaven.getAllLuchthavens();
                    session.setAttribute("luchthavens", luchthavens);

                    request.getRequestDispatcher("beheer_luchthavens.jsp").forward(request, response);
                }
            } else if (objectType.equals("bemanningslid")) {

                Bemanningslid lid = daBemanningslid.getBemmanningslidForID(id);
                session.setAttribute("bemanningslid", null);
                if (pasaan || nieuw) {
                    ArrayList<Functie> functies = daFunctie.getAlleFuncties();
                    session.setAttribute("functies", functies);

                    ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getAlleLuchtvaartmaatschappijen();
                    session.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);

                    if (pasaan) {
                        session.setAttribute("editbemanningslid", lid);
                    }

                } else if (verwijder) {

                    if (!daVlucht.checkOfVluchtBemanningsLidBevat(id)) {
                        daBemanningslid.verwijderBemanningsLidForID(id);
                    } else {
                        session.setAttribute("bemanningslid", lid);
                    }

                    ArrayList<Bemanningslid> bemanning = daBemanningslid.getAlleBemanningsLeden();
                    session.setAttribute("bemanning", bemanning);

                    request.getRequestDispatcher("beheer_bemanning.jsp").forward(request, response);
                }
            } else if (objectType.equals("vluchtbemanning")) {

                int vluchtID = (Integer) session.getAttribute("vluchtID");

                if (pasaan || nieuw) {
                    ArrayList<Bemanningslid> bemanningsLeden = daBemanningslid.getAlleBemanningsLeden();
                    session.setAttribute("bemanningsLeden", bemanningsLeden);

                    Vlucht vlucht = daVlucht.getVluchtForVluchtID(vluchtID);

                    session.setAttribute("vluchtVoorBemanning", vlucht);

                    if (pasaan) {
                        VluchtBemanning vBemanning = daVluchtBemanning.getVluchtBemanningFor(id, vluchtID);
                        session.setAttribute("editVluchtBemanning", vBemanning);
                    }

                } else if (verwijder) {

                    daVluchtBemanning.verwijderVluchtbemanningsLidVoor(id);

                    ArrayList<VluchtBemanning> vluchtbemanningsLeden = daVluchtBemanning.getVluchtbemanningForVluchtID(vluchtID);
                    session.setAttribute("vluchtbemanningsLeden", vluchtbemanningsLeden);

                    request.getRequestDispatcher("beheer_vluchtbemanning.jsp").forward(request, response);
                }
            }

            request.getRequestDispatcher(beheerpagina + ".jsp").forward(request, response);

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
