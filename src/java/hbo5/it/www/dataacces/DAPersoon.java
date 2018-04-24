/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
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
    
    public boolean tryLogin(String userLogin, String paswoord) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PERSOON WHERE Login=? AND paswoord=?");) {
                
            statement.setString(1, userLogin);
            statement.setString(2, paswoord);
            ResultSet resultset = statement.executeQuery();
                
            return resultset.next();
        } catch (Exception e) {
            e.printStackTrace();
}
        return false;
    }
}
