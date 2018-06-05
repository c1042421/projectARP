/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataacces.DALuchthaven;
import hbo5.it.www.dataacces.DAPassagier;
import hbo5.it.www.dataacces.DAPersoon;
import hbo5.it.www.dataacces.DAVliegtuig;
import hbo5.it.www.dataacces.DAVliegtuigklasse;
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
 * @author Axel
 */
@WebServlet(urlPatterns = {"/DetailServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")
    , @WebInitParam(name = "login", value = "c1042421")
    , @WebInitParam(name = "password", value = "1234")})

public class DetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");

            boolean boekVlucht = request.getParameter("boek") != null;
            boolean detailsVlucht = request.getParameter("details") != null;

            HttpSession session = request.getSession();

            DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
            DAPersoon daPersoon = new DAPersoon(url, login, password, driver);
            DAPassagier daPassagier = new DAPassagier(url, login, password, driver);
            DALuchthaven daLuchthaven = new DALuchthaven(url, login, password, driver);
            DAVliegtuig daVliegtuig = new DAVliegtuig(url, login, password, driver);
            DAVliegtuigklasse daVliegtuigKlasse = new DAVliegtuigklasse(url, login, password, driver);

            int vluchtID = Integer.parseInt(request.getParameter("vluchtID"));
            Vlucht vlucht = daVlucht.getVluchtForVluchtID(vluchtID);

            session.setAttribute("vlucht", vlucht);

            if (detailsVlucht) {
                request.getRequestDispatcher("details.jsp").forward(request, response);
            } 
            else if (boekVlucht) {
                //to do vluchtje boeken

                Persoon persoon = (Persoon)session.getAttribute("loggedInPersoon");

                if (persoon.getSoort() == 'P') {
                    
                    
                    int persoonID = persoon.getId();
                    Passagier passagier = new Passagier();
                    passagier.setId(vluchtID);
                    passagier.setIngecheckt(false);
                    passagier.setIngeschreven(false);
                    passagier.setKlasse_id(1);
                    passagier.setPersoon_id(persoonID);
                    passagier.setVlucht_id(vluchtID);
                    passagier.setPlaats("F04");

                    daPassagier.voegVluchtToeAanPassagier(passagier);
                    session.setAttribute("passagier", passagier);

                    request.getRequestDispatcher("succesBoek.jsp").forward(request, response);
                } else if (persoon.getSoort() == 'B') {
                    //Je kan geen vlucht boeken als Bemanning

                } else if (persoon.getSoort() == 'A') {

                    //Je kan geen vlucht boeken als Admin
                }

            } 
            else {
                //TODO User feedback not found
            }

            request.getRequestDispatcher("succesBoek.jsp").forward(request, response);
        }

    
    catch (ClassNotFoundException ex) {
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
        



} catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailServlet.class

.getName()).log(Level.SEVERE, null, ex);
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
        



} catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailServlet.class

.getName()).log(Level.SEVERE, null, ex);
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
