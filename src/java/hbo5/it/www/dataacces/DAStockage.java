/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Stockage;
import hbo5.it.www.factory.StockageFactory;
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
public class DAStockage extends DABase {

    public DAStockage(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }

    public ArrayList<Stockage> getAlleStockages() {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from stockage "
                        + "inner join VLIEGTUIG on VLIEGTUIG_ID = VLIEGTUIG.ID "
                        + "inner join HANGAR on HANGAR_ID = HANGAR.ID "
                        + "inner join VLIEGTUIGTYPE on VLIEGTUIGTYPE_ID = VLIEGTUIGTYPE.ID "
                        + "inner join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID = LUCHTVAARTMAATSCHAPPIJ.ID");) {

            ResultSet resultset = statement.executeQuery();

            return new StockageFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Stockage getStockageByID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from stockage "
                        + "inner join VLIEGTUIG on VLIEGTUIG_ID = VLIEGTUIG.ID "
                        + "inner join HANGAR on HANGAR_ID = HANGAR.ID "
                        + "inner join VLIEGTUIGTYPE on VLIEGTUIGTYPE_ID = VLIEGTUIGTYPE.ID "
                        + "inner join LUCHTVAARTMAATSCHAPPIJ on LUCHTVAARTMAATSCHAPPIJ_ID = LUCHTVAARTMAATSCHAPPIJ.ID "
                        + "where stockage.id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return resultset.next() ? new StockageFactory().maakObject(resultset) : null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(Stockage stockage) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update stockage SET VLIEGTUIG_ID=?, HANGAR_ID=?, Reden=?, Vandatum=?, totdatum=? where id=?");) {

            statement.setInt(1, stockage.getVliegtuig_id());
            statement.setInt(2, stockage.getHangar_id());
            statement.setString(3, stockage.getReden());
            statement.setDate(4, stockage.getVandatum());
            statement.setDate(5, stockage.getTotdatum());
            statement.setInt(6, stockage.getId());

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int voegStockageToe(Stockage stockage) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into stockage (id, Reden, Vandatum, totdatum, VLIEGTUIG_ID, HANGAR_ID) values (stockage_seq.nextval, ?, ?, ?, ?, ?)");) {

            statement.setString(1, stockage.getReden());
            statement.setDate(2, stockage.getVandatum());
            statement.setDate(3, stockage.getTotdatum());
            statement.setInt(4, stockage.getVliegtuig_id());
            statement.setInt(5, stockage.getHangar_id());

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void verwijderStockageForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from stockage where id=?");) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean stockageHeeftHangar(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from stockage where hangar_id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return resultset.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
