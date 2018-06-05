/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Stockage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jelmarvanaert
 */
public class HangarFactory extends BaseFactory{

    @Override
    public Hangar maakObject(ResultSet resultset) throws SQLException {
        Hangar hangar = new Hangar();
        
        int id = getIdForColumnName("hangar_id" , resultset);
        
        hangar.setId(id);
        hangar.setHangarnaam(resultset.getString("hangarnaam"));
        
        return hangar;
    }

    public Hangar maakHangarVanRequest(HttpServletRequest request) {
        Hangar hangar = new Hangar();

        int id = Integer.parseInt(request.getParameter("id"));
        String hangarNaam = request.getParameter("hangarnaam");

        hangar.setId(id);
        hangar.setHangarnaam(hangarNaam);

        return hangar;
    }
    
}
