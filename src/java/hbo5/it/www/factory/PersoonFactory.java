/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataacces.DAPersoon;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author c1042421
 */
public class PersoonFactory {
    
    public static Persoon maakPersoonVanResultset(ResultSet resultset) throws SQLException {
        if (resultset.next()) {

            Persoon persoon = new Persoon();
            Date geboorteDatum = resultset.getDate("Geboortedatum");

            persoon.setGeboortedatum(geboorteDatum);
            persoon.setFamilienaam(resultset.getString("Familienaam"));
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
    
    public static Persoon maakPersoonVanRequest(HttpServletRequest request) throws ParseException{
            String voornaam = request.getParameter("Voornaam");
            String familienaam = request.getParameter("Familienaam");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String geboortedatum = request.getParameter("Geboortedatum");
        
            java.util.Date parsedGeboortedatum = sdf.parse(geboortedatum);
            java.sql.Date sqlData = new java.sql.Date(parsedGeboortedatum.getTime());
        
            String straat = request.getParameter("Straat");
            String huisnummer = request.getParameter("Huisnummer");
            String postcode = request.getParameter("Postcode");
            String woonplaats = request.getParameter("Woonplaats");
            String land = request.getParameter("Land");
        
            String gebruikersnaam = request.getParameter("Gebruikersnaam");
            String wachtwoord = request.getParameter("Wachtwoord");
            String bevestigWachtwoord = request.getParameter("bevestigWachtwoord");
        
            Persoon p = new Persoon();
            p.setVoornaam(voornaam);
            p.setFamilienaam(familienaam);
            p.setGeboortedatum(sqlData);
            p.setStraat(straat);
            p.setHuisnr(huisnummer);
            p.setPostcode(postcode);
            p.setWoonplaats(woonplaats);
            p.setLand(land);
            
            if (wachtwoord.equals(bevestigWachtwoord)) {
                p.setLogin(gebruikersnaam);
                p.setPaswoord(wachtwoord);
                return p;
            }
            else {
                return null;
            }
    }
}
