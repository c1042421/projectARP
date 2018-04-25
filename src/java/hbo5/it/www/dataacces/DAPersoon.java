/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author c1042421
 */
public class DAPersoon extends DABase {
   
    public DAPersoon(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public boolean voegGebruikerToe(Persoon p, String gebruikersnaam, String wachtwoord){
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO C1042421.PERSOON (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort)\n" +
"VALUES (persoon_seq.nextval, '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', 'P');");) 
        {

            statement.setString(1, p.getVoornaam());
            statement.setString(2, p.getFamilienaam());
            statement.setString(3, p.getStraat());
            statement.setString(4, p.getHuisnr());
            statement.setString(5, p.getPostcode());
            statement.setString(6, p.getWoonplaats());
            statement.setString(7, p.getLand());
            java.sql.Date sqlData = new java.sql.Date(p.getGeboortedatum().getTime());
            statement.setDate(8, sqlData);
            statement.setString(9, p.getLogin());
            statement.setString(10, p.getPaswoord());
            
            return statement.execute();
            
        } catch (Exception e) {
            
        }
        return false;
    }
}
