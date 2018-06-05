/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Passagier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public class PassagierFactory extends BaseFactory {

    @Override
    public Passagier maakObject(ResultSet resultset) throws SQLException {
        Passagier passagier = new Passagier();

        passagier.setId(resultset.getInt("id"));
        passagier.setIngecheckt(resultset.getBoolean("ingecheckt"));
        passagier.setIngeschreven(resultset.getBoolean("ingeschreven"));
        passagier.setKlasse_id(resultset.getInt("klasse_id"));
        passagier.setPersoon_id(resultset.getInt("klasse_id"));
        passagier.setVlucht_id(resultset.getInt("vlucht_id"));
        passagier.setPlaats(resultset.getString("plaats"));

        return passagier;
    }
}
