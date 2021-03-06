/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigtype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author c1042421
 */
public class VliegtuigFactory extends BaseFactory {

    public Vliegtuig maakVliegtuigVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }

        return null;
    }

    @Override
    public Vliegtuig maakObject(ResultSet resultset) throws SQLException {
        Vliegtuig vliegtuig = new Vliegtuig();

        try {
            Luchtvaartmaatschappij lm = new LuchtvaartmaatschappijFactory().maakObject(resultset);
            Vliegtuigtype type = new VliegtuigtypeFactory().maakObject(resultset);

            vliegtuig.setLuchtvaartmaatschappij(lm);
            vliegtuig.setVliegtuigtype(type);
        } catch (Exception e) {

        }

        int id = getIdForColumnName("vliegtuig_id", resultset);
        vliegtuig.setId(id);

        vliegtuig.setLuchtvaartmaatschappij_id(resultset.getInt("LUCHTVAARTMAATSCHAPPIJ_ID"));
        vliegtuig.setVliegtuigtype_id(resultset.getInt("VLIEGTUIGTYPE_ID"));

        return vliegtuig;
    }

    public Vliegtuig maakVliegtuigVanRequest(HttpServletRequest request) {
        Vliegtuig vliegtuig = new Vliegtuig();
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        int luchtvaartmaatschappijID = Integer.parseInt(request.getParameter("maatschappijID"));
        
        vliegtuig.setVliegtuigtype_id(typeID);
        vliegtuig.setLuchtvaartmaatschappij_id(luchtvaartmaatschappijID);
        
        return vliegtuig;
    }

}
