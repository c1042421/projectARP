/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.factory.FunctieFactory;
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
public class DAFunctie extends DABase {
   
    public DAFunctie(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public Functie getFunctieByID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from Functie where id=?");) {

            statement.setInt(1, id);
            
            ResultSet resultset = statement.executeQuery();
            
            return FunctieFactory.maakFunctieVanResultset(resultset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    
    }

    public ArrayList<Bemanningslid> voegFunctieToeAanBemanning(ArrayList<Bemanningslid> bemanning) {
        ArrayList<Bemanningslid> leden = new ArrayList<>();
        
        for (Bemanningslid lid : bemanning) {
            Functie functie = getFunctieByID(lid.getFunctie_id());
            lid.setFunctie(functie);
            leden.add(lid);
        }
        
        return leden;
    }

    public ArrayList<Functie> getAlleFuncties() {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from Functie");) {
            
            ResultSet resultset = statement.executeQuery();
            
            return FunctieFactory.maakLijstFunctieVanResultset(resultset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
