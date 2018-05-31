/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataacces.DABemanningslid;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DAPersoon;
import hbo5.it.www.factory.BemanningFactory;
import hbo5.it.www.factory.LuchthavenFactory;
import hbo5.it.www.factory.PersoonFactory;
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
@WebServlet(urlPatterns = {"/SaveServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})
public class SaveServlet extends HttpServlet {

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

            String beheerpagina = request.getParameter("beheerpagina");

            int editedRows = 0;

            boolean saveLuchthaven = request.getParameter("save_luchthaven") != null;
            boolean saveNieuweLuchthaven = request.getParameter("save_nieuwe_luchthaven") != null;
            boolean saveBemanningslid = request.getParameter("save_bemanningslid") != null;
            boolean saveNieuwBemanninslid = request.getParameter("save_nieuw_bemanningslid") != null;

            DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
            DAPersoon daPersoon = new DAPersoon(url, login, password, driver);
            DABemanningslid daBemanningslid = new DABemanningslid(url, login, password, driver);

            if (saveLuchthaven || saveNieuweLuchthaven) {
                Luchthaven l = new LuchthavenFactory().maakLuchthavenVanRequest(request);

                editedRows = saveLuchthaven ? daLuchthaven.updateLuchthaven(l) : daLuchthaven.voegNieuweLuchthavenToe(l);

                ArrayList<Luchthaven> luchthavens = daLuchthaven.getAllLuchthavens();
                session.setAttribute("luchthavens", luchthavens);
            } else if (saveBemanningslid || saveNieuwBemanninslid) {
                Bemanningslid bemanningslid = new BemanningFactory().maakBemanningslidVanRequest(request);
                Persoon persoon = new PersoonFactory().maakPersoonVanRequest(request);

                if (saveNieuwBemanninslid) {
                    persoon.setSoort('B');
                    daPersoon.voegGebruikerToe(persoon);
                    
                    int id = daPersoon.getIDFrom(persoon);
                    bemanningslid.setPersoon_id(id);
                    
                    editedRows = daBemanningslid.voegNieuwBemanningslidToe(bemanningslid);
                } else {
                    daPersoon.update(persoon);
                    editedRows = daBemanningslid.update(bemanningslid);
                }

                ArrayList<Bemanningslid> bemanning = daBemanningslid.getAlleBemanningsLeden();
                session.setAttribute("bemanning", bemanning);
            }

            if (editedRows > 0) {
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
