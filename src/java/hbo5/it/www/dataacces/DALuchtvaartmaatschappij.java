/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.factory.LuchtvaartmaatschappijFactory;
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
public class DALuchtvaartmaatschappij extends DABase {
   
    public DALuchtvaartmaatschappij(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public ArrayList<Luchtvaartmaatschappij> getAlleLuchtvaartmaatschappijen() {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.Luchtvaartmaatschappij");) {
             
            ResultSet resultset = statement.executeQuery();
            
            return LuchtvaartmaatschappijFactory.maakLijstLuchtvaartmaatschappijenVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
