/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Functie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jelmarvanaert
 */
public class FunctieFactory extends BaseFactory {

    public Functie maakFunctieVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }
    
    public Functie maakObject(ResultSet resultset) throws SQLException {
        Functie functie = new Functie();
        
        functie.setId(resultset.getInt("id"));
        functie.setFunctienaam(resultset.getString("functienaam"));
        functie.setOmschrijving(resultset.getString("omschrijving"));
        
        return functie;
    }   
}
