/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.factory.VluchtFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author c1042421
 */
public class DAVlucht extends DABase {
   
    public DAVlucht(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }
    public Vlucht getVlucht(int id) {
        Vlucht vlucht = null;
        
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.VLUCHT WHERE vlucht_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return VluchtFactory.maakVluchtVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
            
        
    
}
