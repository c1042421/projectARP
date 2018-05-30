/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.factory.VliegtuigFactory;
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
public class DAVliegtuig extends DABase {
   
    public DAVliegtuig(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
    
    public Vliegtuig getVliegtuigForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.Vliegtuig vl "
                        + "inner join VLIEGTUIGTYPE on vl.VLIEGTUIGTYPE_ID = VLIEGTUIGTYPE.ID "
                        + "inner join LUCHTVAARTMAATSCHAPPIJ on vl.LUCHTVAARTMAATSCHAPPIJ_ID = LUCHTVAARTMAATSCHAPPIJ.ID "
                        + "WHERE vl.id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return VliegtuigFactory.maakVliegtuigVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Passagier> voegVliegtuigToeVoorVlucht(ArrayList<Passagier> passagiers) {
        ArrayList<Passagier> passagiersMetVliegtuigInVlucht = new ArrayList<>();
        
        for (Passagier passagier : passagiers){
            Vlucht vlucht = passagier.getVlucht();
            Vliegtuig vliegtuig = getVliegtuigForID(vlucht.getVliegtuig_id());
            
            vlucht.setVliegtuig(vliegtuig);
            passagier.setVlucht(vlucht);
            
            passagiersMetVliegtuigInVlucht.add(passagier);
        }
        
        return passagiersMetVliegtuigInVlucht;
    }

    public ArrayList<VluchtBemanning> voegVliegtuigToeVoorBemanning(ArrayList<VluchtBemanning> vluchtbemanning) {
        ArrayList<VluchtBemanning> vluchtbemanningMetVliegtuigInVlucht = new ArrayList<>();
        
        for (VluchtBemanning vlubem : vluchtbemanning) {
            Vlucht vlucht = vlubem.getVlucht();
            Vliegtuig vliegtuig = getVliegtuigForID(vlucht.getVliegtuig_id());
            
            vlucht.setVliegtuig(vliegtuig);
            vlubem.setVlucht(vlucht);
            
            vluchtbemanningMetVliegtuigInVlucht.add(vlubem);
        }
        return vluchtbemanningMetVliegtuigInVlucht;
    }
    
    public ArrayList<Vliegtuig> getAllVliegtuigen(){        
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.VLIEGTUIG join vliegtuigtype on vliegtuig.VLIEGTUIGTYPE_ID = vliegtuigtype.ID \n" +
"                                 join luchtvaartmaatschappij on vliegtuig.LUCHTVAARTMAATSCHAPPIJ_ID = luchtvaartmaatschappij.ID");) {


            ResultSet resultset = statement.executeQuery();

            return VliegtuigFactory.maakLijstVanVliegtuigen(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public int verwijderVliegtuigForID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from VLIEGTUIG where id=?");) {

            statement.setInt(1, id);
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
