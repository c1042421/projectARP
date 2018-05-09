/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Land;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class LandFactory {

    public static Land maakLandVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            Land land = new Land();

            land.setId(resultset.getInt("id"));
            land.setLandnaam(resultset.getString("landnaam"));

            return land;
        }
        return null;
    }
}
