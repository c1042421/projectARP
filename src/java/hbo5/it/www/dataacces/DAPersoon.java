/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.factory.PersoonFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
/**
 *
 * @author c1042421
 */
public class DAPersoon extends DABase {
   
    public DAPersoon(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public boolean voegGebruikerToe(Persoon p){
        boolean gelukt = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO C1042421.PERSOON (id, voornaam, familienaam, straat, huisnr, postcode, woonplaats, land, geboortedatum, login, paswoord, soort)\n" +
"VALUES (persoon_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'P')");)
        {

            statement.setString(1, p.getVoornaam());
            statement.setString(2, p.getFamilienaam());
            statement.setString(3, p.getStraat());
            statement.setString(4, p.getHuisnr());
            statement.setString(5, p.getPostcode());
            statement.setString(6, p.getWoonplaats());
            statement.setString(7, p.getLand());
            statement.setDate(8, p.getGeboortedatum());
            statement.setString(9, p.getLogin());
            statement.setString(10, p.getPaswoord());
            
            statement.executeUpdate();
            
        } catch (Exception e) {
            gelukt = false;
           
        }
        return gelukt;
    }
     public Persoon getPersoonVoorLogin(String userLogin, String paswoord) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PERSOON WHERE login=? AND paswoord=?");) {

            statement.setString(1, userLogin);
            statement.setString(2, paswoord);
            ResultSet resultset = statement.executeQuery();
            
            return new PersoonFactory().maakPersoonVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
     public Persoon getPersoonForID(int id){
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PERSOON WHERE id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return new PersoonFactory().maakPersoonVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

    public ArrayList<Bemanningslid> voegPersoonToeAanBemanning(ArrayList<Bemanningslid> bemanning) {
       ArrayList<Bemanningslid> leden = new ArrayList<>();
       
       for (Bemanningslid lid : bemanning) {
           Persoon p = getPersoonForID(lid.getPersoon_id());
           lid.setPersoon(p);
           leden.add(lid);
       } 
       return leden;
    }

    public int update(Persoon persoon) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update Persoon SET Voornaam=?, familienaam=?, straat=?, huisnr=?,"
                        + " postcode=?, woonplaats=?, land=? where id=?");) {

            statement.setString(1, persoon.getVoornaam());
            statement.setString(2, persoon.getFamilienaam());
            statement.setString(3, persoon.getStraat());
            statement.setString(4, persoon.getHuisnr());
            statement.setString(5, persoon.getPostcode());
            statement.setString(6, persoon.getWoonplaats());
            statement.setString(7, persoon.getLand());
            statement.setInt(8, persoon.getId());
            
            return statement.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
