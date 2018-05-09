/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042486
 */
public class LuchtvaartmaatschappijFactory {
    public static Luchtvaartmaatschappij maakLuchtvaartmaatschappijVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {

            Luchtvaartmaatschappij lvm = new Luchtvaartmaatschappij();
            
            lvm.setId(resultset.getInt("id"));
            lvm.setLuchtvaartnaam(resultset.getString("luchtvaartnaam"));
            
            return lvm;
        }
        return null;
    }
}
