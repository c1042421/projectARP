/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Vliegtuigtype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jelmarvanaert
 */
class VliegtuigtypeFactory extends BaseFactory {

    @Override
    public Vliegtuigtype maakObject(ResultSet resultset) throws SQLException {
        Vliegtuigtype type = new Vliegtuigtype();
        
        int id = checkIfIdExistsAndReturn("VLIEGTUIGTYPE_ID", resultset);
        
        type.setId(id);
        type.setTypenaam(resultset.getString("typenaam"));
        
        return type;
    }
}
