/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public class LuchtvaartmaatschappijFactory extends BaseFactory {
   
    @Override
    public Luchtvaartmaatschappij maakObject(ResultSet resultset) throws SQLException {
        
        Luchtvaartmaatschappij lm = new Luchtvaartmaatschappij();

        int id = checkIfIdExistsAndReturnNotStatic("LUCHTVAARTMAATSCHAPPIJ_ID", resultset);

        lm.setId(id);
        lm.setLuchtvaartnaam(resultset.getString("luchtvaartnaam"));

        return lm;
    }

    public Luchtvaartmaatschappij maakLuchtvaartmaatschappijVanResultset(ResultSet resultset) throws SQLException {
        return resultset.next() ? maakObject(resultset) : null;
    }
}
