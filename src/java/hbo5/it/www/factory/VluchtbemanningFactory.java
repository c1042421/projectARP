/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;
import hbo5.it.www.beans.VluchtBemanning;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042410
 */
public class VluchtBemanningFactory {
    public static VluchtBemanning maakVluchtbemanningVanResultset(ResultSet resultset) throws SQLException{
        if (resultset.next()) {

            VluchtBemanning vluchtbemanning = new VluchtBemanning();

            vluchtbemanning.setId(resultset.getInt("ID"));
            vluchtbemanning.setTaak(resultset.getString("TAAK"));
            vluchtbemanning.setBemanningslid_id(resultset.getInt("BEMANNINGSLID_ID"));
            vluchtbemanning.setVlucht_id(resultset.getInt("VLUCHT_ID"));

            return vluchtbemanning;
        }
        return null;
    }
}