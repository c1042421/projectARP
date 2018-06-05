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

    public Land maakLandVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            maakObject(resultset);
        }
        return null;
    }

    @Override
    public Land maakObject(ResultSet resultset) throws SQLException {
        Land land = new Land();
        
        int id = getIdForColumnName("land_id", resultset);

        land.setId(id);
        land.setLandnaam(resultset.getString("landnaam"));

        return land;
    }
}
