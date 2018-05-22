/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.factory.LandFactory;
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
public class DALand extends DABase {
   
    public DALand(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public Land getLandForID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.Land WHERE id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            return LandFactory.maakLandVanResultset(resultset);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Passagier> voegLandenToeAanVluchtLuchthavensVanPassagiers(ArrayList<Passagier> passagiers) {
         ArrayList<Passagier> passagiersMetVluchtLuchthavens = new ArrayList<>();

        for (Passagier passagier : passagiers) {
            Land vertrekLand = getLandForID(passagier.getVlucht().getVertrekLuchthaven().getLand_id());
            Land aankomstLand = getLandForID(passagier.getVlucht().getAankomstLuchthaven().getLand_id());
            
            passagier.getVlucht().getAankomstLuchthaven().setLand(aankomstLand);
            passagier.getVlucht().getVertrekLuchthaven().setLand(vertrekLand);

            passagiersMetVluchtLuchthavens.add(passagier);
        }

        return passagiersMetVluchtLuchthavens;
    }
}
