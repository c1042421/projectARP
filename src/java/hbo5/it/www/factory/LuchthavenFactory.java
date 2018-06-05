/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author c1042421
 */
public class LuchthavenFactory extends BaseFactory {

    public Luchthaven maakObject(ResultSet resultset, String idColumn) throws SQLException {
         Luchthaven luchthaven = new Luchthaven();
        
        try {
            
            Land land = new LandFactory().maakObject(resultset);
            luchthaven.setLand(land);
            
        } catch(Exception e) {
            
        }
        
        int id = getIdForColumnName(idColumn, resultset);
        
        luchthaven.setLuchthavennaam(resultset.getString("luchthavennaam"));
        luchthaven.setStad(resultset.getString("stad"));
        luchthaven.setId(id);
        luchthaven.setLand_id(resultset.getInt("land_id"));

        return luchthaven;
    }
    
    @Override
    public Luchthaven maakObject(ResultSet resultset) throws SQLException {
        Luchthaven luchthaven = new Luchthaven();
        
        try {
            Land land = new LandFactory().maakObject(resultset);

            luchthaven.setLand(land);
        } catch(Exception e) {
            
        }
        
        luchthaven.setLuchthavennaam(resultset.getString("luchthavennaam"));
        luchthaven.setStad(resultset.getString("stad"));
        luchthaven.setId(resultset.getInt("id"));
        luchthaven.setLand_id(resultset.getInt("land_id"));

        return luchthaven;
    }
    
    public Luchthaven maakLuchthavenVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }


    public Luchthaven maakLuchthavenVanRequest(HttpServletRequest request) {
        Luchthaven l = new Luchthaven();
        
        String naam = request.getParameter("luchthavennaam");
        if (request.getParameter("id") != null) {
           int id = Integer.parseInt(request.getParameter("id"));
           l.setId(id);
        }
        
        int landId = Integer.parseInt(request.getParameter("land_id"));
        String stad = request.getParameter("stad");
   
        l.setLand_id(landId);
        l.setStad(stad);
        l.setLuchthavennaam(naam);
        return l;
    }
}
