/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Vliegtuigklasse;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jelmarvanaert
 */
public class VliegtuigklasseFactory extends BaseFactory {

    public Vliegtuigklasse maakVluchtVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }

        return null;
    }

    @Override
    public Vliegtuigklasse maakObject(ResultSet resultset) throws SQLException {
        Vliegtuigklasse klasse = new Vliegtuigklasse();

        klasse.setId(resultset.getInt("id"));
        klasse.setKlassenaam(resultset.getString("klassenaam"));

        return klasse;
    }

}
