/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Bemanningslid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042410
 */
public class BemanningFactory {

    public static Bemanningslid maakBemanningslidVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }

    private static Bemanningslid maakObject(ResultSet resultset) throws SQLException {
        Bemanningslid bemanningslid = new Bemanningslid();

        bemanningslid.setId(resultset.getInt("id"));
        bemanningslid.setLuchtvaartmaatschappij_id(resultset.getInt("luchtvaartmaatschappij_id"));
        bemanningslid.setPersoon_id(resultset.getInt("persoon_id"));
        bemanningslid.setFunctie_id(resultset.getInt("functie_id"));

        return bemanningslid;
    }

    public static ArrayList<Bemanningslid> maakLijstBemannningsLedenVanResultset(ResultSet resultset) throws SQLException {
        ArrayList<Bemanningslid> leden = new ArrayList<>();
        
        while (resultset.next()){
            leden.add(maakObject(resultset));
        }
        
        return leden;
    }
}
