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

/**
 *
 * @author c1042421
 */
public class VliegtuigFactory extends BaseFactory {

    public static Vliegtuig maakVliegtuigVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()){
            Vliegtuig vliegtuig = new Vliegtuig();
            
            Luchtvaartmaatschappij lm = LuchtvaartmaatschappijFactory.maakLuchtvaartmaatschappijVanResultsetZonderNext(resultset);
            Vliegtuigtype type = VliegtuigtypeFactory.maakVliegtuigtypeVanResultsetZonderNext(resultset);
            
            vliegtuig.setLuchtvaartmaatschappij(lm);
            vliegtuig.setVliegtuigtype(type);
            
            vliegtuig.setId(resultset.getInt("id"));
            vliegtuig.setLuchtvaartmaatschappij_id(resultset.getInt("LUCHTVAARTMAATSCHAPPIJ_ID"));
            vliegtuig.setVliegtuigtype_id(resultset.getInt("VLIEGTUIGTYPE_ID"));
                        
            return vliegtuig;
        }
        
        return null;
    }
    
}
