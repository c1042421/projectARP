/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataacces.DAVlucht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author Axel
 */
@WebServlet(urlPatterns = {"/zoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})

public class zoekServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");

            HttpSession session = request.getSession();

            DAVlucht daVlucht = new DAVlucht(url, login, password, driver);

            String AlgemeenZoeken = request.getParameter("AlgemeenZoeken");
            if (AlgemeenZoeken != null) {
                int luchthavenID = Integer.parseInt(request.getParameter("luchthavenID"));
                String type = request.getParameter("soortVlucht");

                if (type == "Binnenkomende vluchten") {
                    ArrayList<Vlucht> vluchten = daVlucht.getAankomendeVluchtenForLuchthavenID(luchthavenID);
                    session.setAttribute("vluchten", vluchten);
                } else {
                    ArrayList<Vlucht> vluchten = daVlucht.getVertrekkendeVluchtenForLuchthaven(luchthavenID);
                    session.setAttribute("vluchten", vluchten);
                }
            } 
            else {

                String code = request.getParameter("txtVluchtnummer");
                String datum = request.getParameter("txtVluchtdatum");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date vluchtdatum = sdf.parse(datum);
                java.sql.Date sqlData = new java.sql.Date(vluchtdatum.getTime());

                String bestemming = request.getParameter("txtBestemming");
                String luchtvaartmaatschappij = request.getParameter("txtLuchthaven");

                if (code != null) {
                    ArrayList<Vlucht> vluchten = daVlucht.getVluchtForVluchtCode(code);;
                    session.setAttribute("vluchten", vluchten);
                } else if (datum != null) {
                    ArrayList<Vlucht> vluchten = daVlucht.getVluchtForVluchtDatum(vluchtdatum);
                    session.setAttribute("vluchten", vluchten);
                } else if (bestemming != null) {
                    ArrayList<Vlucht> vluchten = daVlucht.getVluchtForBestemming(bestemming);
                    session.setAttribute("vluchten", vluchten);
                } else if (luchtvaartmaatschappij != null) {
                    ArrayList<Vlucht> vluchten = daVlucht.getVluchtForLuchtvaartmaatschappij(luchtvaartmaatschappij);
                    session.setAttribute("vluchten", vluchten);
                }
            }

            request.getRequestDispatcher("overzichtVluchten.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(zoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(zoekServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
