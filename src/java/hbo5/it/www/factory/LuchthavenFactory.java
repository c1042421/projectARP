/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class LuchthavenFactory extends BaseFactory {

    public static Luchthaven maakLuchthavenVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()){
            
            Luchthaven luchthaven = new Luchthaven();
            Land land = LandFactory.maakLandVanResultsetZonderNext(resultset);
            
            luchthaven.setLand(land);
            luchthaven.setLuchthavennaam(resultset.getString("luchthavennaam"));
            luchthaven.setStad(resultset.getString("stad"));
            luchthaven.setId(resultset.getInt("id"));
            luchthaven.setLand_id(resultset.getInt("land_id"));
                  
            return luchthaven;
        }
        return null;
    }
    
}
