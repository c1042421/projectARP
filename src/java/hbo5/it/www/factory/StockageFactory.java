/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vliegtuig;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jelmarvanaert
 */
public class StockageFactory extends BaseFactory {

    @Override
    public Stockage maakObject(ResultSet resultset) throws SQLException {
        Stockage stockage = new Stockage();

        stockage.setReden(resultset.getString("reden"));
        stockage.setId(resultset.getInt("id"));
        stockage.setVandatum(resultset.getDate("vandatum"));
        stockage.setTotdatum(resultset.getDate("totdatum"));
        stockage.setVliegtuig_id(resultset.getInt("vliegtuig_id"));
        stockage.setHangar_id(resultset.getInt("hangar_id"));

        try {
            Vliegtuig vliegtuig = new VliegtuigFactory().maakObject(resultset);
            stockage.setVliegtuig(vliegtuig);

            Hangar hangar = new HangarFactory().maakObject(resultset);
            stockage.setHangar(hangar);
        } catch (Exception e) {

        }

        return stockage;
    }

    public Stockage maakStockageVanRequest(HttpServletRequest request) throws ParseException {
        Stockage stockage = new Stockage();

        int id = Integer.parseInt(request.getParameter("id"));
        int vliegtuigID = Integer.parseInt(request.getParameter("vliegtuig_id"));
        int hangarID = Integer.parseInt(request.getParameter("hangar_id"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String vanString = request.getParameter("van");
        java.util.Date vanUtil = sdf.parse(vanString);
        java.sql.Date van = new java.sql.Date(vanUtil.getTime());

        String totString = request.getParameter("tot");
        java.util.Date totUtil = sdf.parse(totString);
        java.sql.Date tot = new java.sql.Date(totUtil.getTime());
        
        stockage.setId(id);
        stockage.setVliegtuig_id(vliegtuigID);
        stockage.setVandatum(van);
        stockage.setTotdatum(tot);
        stockage.setHangar_id(hangarID);
        stockage.setReden(request.getParameter("reden"));

        return stockage;
    }

}
