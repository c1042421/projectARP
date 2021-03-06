/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.factory.LuchthavenFactory;
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
public class DALuchthaven extends DABase {

    public DALuchthaven(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }

    public Luchthaven getLuchthavenForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Luchthaven inner join Land on LAND_ID=LAND.ID where LUCHTHAVEN.ID = ?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new LuchthavenFactory().maakLuchthavenVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Luchthaven> getAllLuchthavens() {
       try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Luchthaven inner join Land on LAND_ID=LAND.ID");) {

            ResultSet resultset = statement.executeQuery();

            return new LuchthavenFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Passagier> voegLuchtavensToeAanPassagiersVlucht(ArrayList<Passagier> passagiers) {

        ArrayList<Passagier> passagiersMetVluchtLuchthavens = new ArrayList<>();

        for (Passagier passagier : passagiers) {
            Luchthaven aankomst = getLuchthavenForID(passagier.getVlucht().getAankomstluchthaven_id());
            Luchthaven vertrek = getLuchthavenForID(passagier.getVlucht().getVertrekluchthaven_id());
            Vlucht vlucht = passagier.getVlucht();
            vlucht.setAankomstLuchthaven(aankomst);
            vlucht.setVertrekLuchthaven(vertrek);
            passagier.setVlucht(vlucht);

            passagiersMetVluchtLuchthavens.add(passagier);
        }
        
        return passagiersMetVluchtLuchthavens;
    }

    public ArrayList<VluchtBemanning> voegLuchthavensToeAanBemanning(ArrayList<VluchtBemanning> vluchtbemanning) {
        
        ArrayList<VluchtBemanning> vluchtbemanningMetVluchtLuchthavens = new ArrayList<>();
        
        for (VluchtBemanning vlubem : vluchtbemanning) {
            Luchthaven aankomst = getLuchthavenForID(vlubem.getVlucht().getAankomstluchthaven_id());
            Luchthaven vertrek = getLuchthavenForID(vlubem.getVlucht().getVertrekluchthaven_id());
            Vlucht vlucht = vlubem.getVlucht();
            vlucht.setAankomstLuchthaven(aankomst);
            vlucht.setVertrekLuchthaven(vertrek);
            vlubem.setVlucht(vlucht);
            
            vluchtbemanningMetVluchtLuchthavens.add(vlubem);
        }
        
        return vluchtbemanningMetVluchtLuchthavens;
    }

    public int updateLuchthaven(Luchthaven l) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update LUCHTHAVEN SET Luchthavennaam=?, Land_id=?, STAD=? where id=?");) {

            statement.setString(1, l.getLuchthavennaam());
            statement.setInt(2, l.getLand_id());
            statement.setString(3, l.getStad());
            statement.setInt(4, l.getId());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int verwijderLuchthavenForID(int id) {
         try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from LUCHTHAVEN where id=?");) {

            statement.setInt(1, id);
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int voegNieuweLuchthavenToe(Luchthaven l) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into luchthaven (id, luchthavennaam , stad, land_id) values (luchthaven_seq.nextval, ?, ?, ?)");) {

            statement.setString(1, l.getLuchthavennaam());
            statement.setString(2, l.getStad());
            statement.setInt(3, l.getLand_id());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
