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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author c1042486
 */
@WebServlet(name = "ZoekServlet", urlPatterns = {"/ZoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE"),
    @WebInitParam(name = "login", value = "c1042421"),
    @WebInitParam(name = "password", value = "1234"),
    @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ZoekServlet extends HttpServlet {
    
    private DAVlucht davlucht = null;
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");       
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");
            if (davlucht == null) {
                davlucht = new DAVlucht(url, login, password, driver);
            }
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        RequestDispatcher rd = request.getRequestDispatcher("zoekresultaat.jsp");
        Vlucht vlucht = davlucht.getVlucht();
        request.setAttribute("vlucht", vlucht);
        rd.forward(request, response);

        
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
