/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
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
    public Vlucht getVlucht() {
        Vlucht vlucht = null;
        
        try (
            Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM vlucht where id < 5");)
        {
            if(resultset.next()){
            vlucht = new Vlucht();
            vlucht.setId(resultset.getInt("ID"));
            vlucht.setVertrekluchthaven_id(resultset.getInt("vertrekluchthaven_id"));
            vlucht.setAankomstluchthaven_id(resultset.getInt("aankomstluchthaven_id"));
            vlucht.setVertrektijd(resultset.getDate("vertrektijd"));
            vlucht.setAankomsttijd(resultset.getDate("aankomsttijd"));
            vlucht.setCode(resultset.getString("code"));
            }
         } catch (Exception e) {
            e.printStackTrace();
        }
        return vlucht;
    }
            
        
    
}
