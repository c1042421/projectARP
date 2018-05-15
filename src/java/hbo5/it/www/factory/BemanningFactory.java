/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Bemanningslid;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042410
 */
public class BemanningFactory {
    public static Bemanningslid maakBemanningslidVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {

            Bemanningslid bemanningslid = new Bemanningslid();
            
            bemanningslid.setId(resultset.getInt("id"));
            bemanningslid.setLuchtvaartmaatschappij_id(resultset.getInt("luchtvaartmaatschappij_id"));
            bemanningslid.setPersoon_id(resultset.getInt("persoon_id"));
            bemanningslid.setFunctie_id(resultset.getInt("functie_id"));
            
            return bemanningslid;
        }
        return null;
    }
}
