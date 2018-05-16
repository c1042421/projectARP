/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.factory.VliegtuigklasseFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author c1042421
 */
public class DAVliegtuigklasse extends DABase {
   
    public DAVliegtuigklasse(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public Vliegtuigklasse getVliegtuigklasseForID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.Vliegtuigklasse WHERE id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return VliegtuigklasseFactory.maakVluchtVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Passagier> voegVliegtuigKlasseVoorPassagiersToe(ArrayList<Passagier> passagiers) {
        ArrayList<Passagier> passagiersMetKlasse = new ArrayList<>();
        
        for (Passagier passagier : passagiers){
            Vliegtuigklasse klasse = getVliegtuigklasseForID(passagier.getKlasse_id());
            passagier.setKlasse(klasse);
            passagiersMetKlasse.add(passagier);
        }
        
        return passagiersMetKlasse;
    }
}
