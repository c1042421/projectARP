/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.factory.BemanningFactory;
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
public class DABemanningslid extends DABase {

    public DABemanningslid(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }

    public Bemanningslid getBemanningForPersoonID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.BEMANNINGSLID WHERE persoon_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new BemanningFactory().maakBemanningslidVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Bemanningslid> getAlleBemanningsLeden() {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.BEMANNINGSLID join"
                        + " LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID"
                        + " join Persoon on persoon_id = Persoon.id"
                        + " join FUNCTIE on FUNCTIE_ID = FUNCTIE.ID");) {

            ResultSet resultset = statement.executeQuery();

            return new BemanningFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bemanningslid getBemmanningslidForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.BEMANNINGSLID join"
                        + " LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID=LUCHTVAARTMAATSCHAPPIJ.ID"
                        + " join Persoon on persoon_id = Persoon.id"
                        + " join FUNCTIE on FUNCTIE_ID = FUNCTIE.ID"
                        + " WHERE bemanningslid.id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new BemanningFactory().maakBemanningslidVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int verwijderBemanningsLidForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from Bemanningslid where id=?");) {

            statement.setInt(1, id);
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Bemanningslid bemanningslid) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update bemanningslid SET luchtvaartmaatschappij_id=?, functie_id=?"
                        + " where id=?");) {

            statement.setInt(1, bemanningslid.getLuchtvaartmaatschappij_id());
            statement.setInt(2, bemanningslid.getFunctie_id());
            statement.setInt(3, bemanningslid.getId());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int voegNieuwBemanningslidToe(Bemanningslid bemanningslid) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into bemanningslid values (bemanningslid_seq.nextval, ?, ?, ?)");) {

            statement.setInt(1, bemanningslid.getLuchtvaartmaatschappij_id());
            statement.setInt(2, bemanningslid.getPersoon_id());
            statement.setInt(3, bemanningslid.getFunctie_id());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
}
