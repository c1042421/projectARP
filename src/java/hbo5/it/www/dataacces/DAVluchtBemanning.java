/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.factory.VluchtbemanningFactory;
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
public class DAVluchtBemanning extends DABase {
   
    public DAVluchtBemanning(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public ArrayList<VluchtBemanning> getVluchtbemmanningForBemanningsID(int id) {
        try (
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM C1042421.VLUCHTBEMANNING WHERE BEMANNINGSLID_ID = ?");) 
                {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return VluchtbemanningFactory.maakVluchtbemanningsLijstVanResultset(resultset);

                } catch (Exception e) {
                    e.printStackTrace();
                    }   
            return null;
    }
    
    public VluchtBemanning getVluchtbemanningForVluchtID(int id) {
        try (
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM vluchtbemanning vb join vlucht v on vb.vlucht_id = v.id join luchthaven l1 on v.VERTREKLUCHTHAVEN_ID = l1.ID \n" +
                "join luchthaven l2 on v.AANKOMSTLUCHTHAVEN_ID = l2.id WHERE bemanningslid_id = ?");) 
                {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return VluchtbemanningFactory.maakVluchtbemanningVanResultset(resultset);

                } catch (Exception e) {
                    e.printStackTrace();
                    }   
            return null;
        }
}
