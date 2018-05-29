/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Land;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public class LandFactory extends BaseFactory {

    public static Land maakLandVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            maakLandVanResultsetZonderNext(resultset);
        }
        return null;
    }
    
    public static Land maakLandVanResultsetZonderNext(ResultSet resultset) throws SQLException {
        Land land = new Land();
        
        int id = checkIfIdExistsAndReturn("land_id", resultset);

        land.setId(id);
        land.setLandnaam(resultset.getString("landnaam"));

        return land;
    }

    public static ArrayList<Land> maakLijstLandenVanResultset(ResultSet resultset) throws SQLException {
        ArrayList<Land> landen = new ArrayList<>();
        
        while(resultset.next()) {
            Land l = maakLandVanResultsetZonderNext(resultset);
            landen.add(l);
        }
        return landen;
    }
}
