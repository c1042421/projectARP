/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.factory.PassagierFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public class DAPassagier extends DABase {

    public DAPassagier(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public ArrayList<Passagier> getPassagiersForPersoonID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PASSAGIER WHERE persoon_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return PassagierFactory.maakLijstVanResultSet(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
