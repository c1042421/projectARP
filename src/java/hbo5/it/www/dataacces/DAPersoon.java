/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public boolean checkUserExists(String userLogin, String passwoord) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("SELECT Login, Paswoord FROM C1042421.PERSOON where Login='yvesbrys'" );) {
            
            return resultset.next();
        } catch (Exception e) {
            e.printStackTrace();
}
        return false;
    }
}
