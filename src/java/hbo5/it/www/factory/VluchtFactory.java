/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Vlucht;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author c1042486
 */
public class VluchtFactory {

    public static Vlucht maakVluchtVanResultset(ResultSet resultset) throws SQLException {
         if(resultset.next()){
             
            Vlucht vlucht = new Vlucht();
            
            vlucht.setId(resultset.getInt("ID"));
            vlucht.setVertrekluchthaven_id(resultset.getInt("vertrekluchthaven_id"));
            vlucht.setAankomstluchthaven_id(resultset.getInt("aankomstluchthaven_id"));
            vlucht.setVertrektijd(resultset.getDate("vertrektijd"));
            vlucht.setAankomsttijd(resultset.getDate("aankomsttijd"));
            vlucht.setCode(resultset.getString("code"));
            
            return vlucht;
            }
        
        return null;
    }
    
}
