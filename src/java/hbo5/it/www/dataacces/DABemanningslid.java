/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.factory.BemanningFactory;
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
public class DABemanningslid extends DABase {
   
    public DABemanningslid(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public Bemanningslid getBemanningForPersoonID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.BEMANNINGSLID WHERE persoon_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return new BemanningFactory().maakBemanningslidVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Bemanningslid> getAlleBemanningsLeden() {
            try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.BEMANNINGSLID");) {

            ResultSet resultset = statement.executeQuery();
            
            return new BemanningFactory().maakLijst(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }
}
