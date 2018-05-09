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
 * @author c1042421
 */
class LuchtvaartmaatschappijFactory extends BaseFactory {

    static Luchtvaartmaatschappij maakLuchtvaartmaatschappijVanResultsetWithoutNext(ResultSet resultset) throws SQLException {
        
        Luchtvaartmaatschappij lm = new Luchtvaartmaatschappij();
        
        int id = checkIfIdExistsAndReturn("LUCHTVAARTMAATSCHAPPIJ_ID", resultset);
        
        lm.setId(id);
        lm.setLuchtvaartnaam(resultset.getString("luchtvaartnaam"));
        
        return lm;
    }
}
