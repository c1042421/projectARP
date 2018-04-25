/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo.it.www.factory;

import hbo5.it.www.InlogServlet;
import hbo5.it.www.beans.Persoon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c1042421
 */
public class PersoonFactory {

    public static Persoon maakPersoonVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {

            Persoon persoon = new Persoon();
            java.sql.Date sqlGeboortedatum = resultset.getDate("Geboortedatum");
            Date geboorteDatum = DateFactory.toUtilDateFromSqlDate(sqlGeboortedatum);

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
