/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Vliegtuig;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class VliegtuigFactory extends BaseFactory {

    public static Vliegtuig maakVliegtuigVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()){
            Vliegtuig vliegtuig = new Vliegtuig();
            
            Luchtvaartmaatschappij lm = LuchtvaartmaatschappijFactory.maakLuchtvaartmaatschappijVanResultset(resultset);
        }
    }
    
}
