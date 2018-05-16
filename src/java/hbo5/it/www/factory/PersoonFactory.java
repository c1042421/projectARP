/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Persoon;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class PersoonFactory extends BaseFactory {
    
    public static Persoon maakPersoonVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {
           
            Persoon persoon = new Persoon();
            Date geboorteDatum = resultset.getDate("Geboortedatum");

            persoon.setGeboortedatum(geboorteDatum);
            persoon.setFamilienaam(resultset.getString("FAMILIENAAM"));
            persoon.setVoornaam(resultset.getString("Voornaam"));
            persoon.setHuisnr(resultset.getString("Huisnr"));
            persoon.setStraat(resultset.getString("Straat"));
            persoon.setWoonplaats(resultset.getString("Woonplaats"));
            persoon.setLand(resultset.getString("Land"));
            persoon.setPaswoord(resultset.getString("Paswoord"));
            persoon.setLogin(resultset.getString("Login"));
            persoon.setId(resultset.getInt("id"));
            persoon.setPostcode(resultset.getString("postcode"));
            persoon.setSoort(resultset.getString("soort").charAt(0));

            return persoon;
        }
        return null;
}
}
