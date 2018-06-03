/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.factory.VluchtBemanningFactory;
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
                        "SELECT * FROM C1042421.VLUCHTBEMANNING WHERE BEMANNINGSLID_ID = ?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new VluchtBemanningFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<VluchtBemanning> getVluchtbemanningForVluchtID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM C1042421.VLUCHTBEMANNING"
                                + " inner join BEMANNINGSLID on BEMANNINGSLID_ID = BEMANNINGSLID.ID"
                                + " inner join PERSOON on persoon_id = PERSOON.ID"
                                + " inner join vlucht on VLUCHT.ID = VLUCHT_ID"
                                + " where VLUCHT_ID=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new VluchtBemanningFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<VluchtBemanning> getAlleVluchtBemanningsLeden() {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM C1042421.VLUCHTBEMANNING"
                                + " inner join BEMANNINGSLID on BEMANNINGSLID_ID = BEMANNINGSLID.ID"
                                + " inner join PERSOON on persoon_id = PERSOON.ID"
                                + " inner join vlucht on VLUCHT.ID = VLUCHT_ID");) {

            ResultSet resultset = statement.executeQuery();

            return new VluchtBemanningFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int voegNieuwBemanningsLidToe(VluchtBemanning vluchtBemanning) {
       try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into VLUCHTBEMANNING (id, taak, BEMANNINGSLID_ID, VLUCHT_ID) values (vluchtbemanning_seq.nextval, ?, ?, ?)");) {

            statement.setString(1, vluchtBemanning.getTaak());
            statement.setInt(2, vluchtBemanning.getBemanningslid_id());
            statement.setInt(3, vluchtBemanning.getVlucht_id());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int verwijderVluchtbemanningsLidVoor(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from VLUCHTBEMANNING where id=?");) {

            statement.setInt(1, id);
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public VluchtBemanning getVluchtBemanningFor(int id, int vluchtID) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM C1042421.VLUCHTBEMANNING"
                                + " inner join BEMANNINGSLID on BEMANNINGSLID_ID = BEMANNINGSLID.ID"
                                + " inner join PERSOON on persoon_id = PERSOON.ID"
                                + " inner join vlucht on VLUCHT.ID = VLUCHT_ID"
                                + " where VLUCHT_ID=? and VLUCHTBEMANNING.id=?");) {

            statement.setInt(1, vluchtID);
            statement.setInt(2, id);
            ResultSet resultset = statement.executeQuery();

            return new VluchtBemanningFactory().maakVluchtbemanningVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(VluchtBemanning vluchtBemanning) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update VLUCHTBEMANNING SET TAAK=?, VLUCHT_ID=?, BEMANNINGSLID_ID=? where id=?");) {
            
            statement.setString(1, vluchtBemanning.getTaak());
            statement.setInt(2, vluchtBemanning.getVlucht_id());
            statement.setInt(3, vluchtBemanning.getBemanningslid_id());
            statement.setInt(4, vluchtBemanning.getId());
            
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
