/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.factory.HangarFactory;
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
public class DAHangar extends DABase {

    public int voegHangarToe(Hangar hangar) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Insert into hangar values (hangar_seq.nextval, ?)");) {

            statement.setString(1, hangar.getHangarnaam());

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Hangar hangar) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Update hangar SET HANGARNAAM=? where id=?");) {

            statement.setInt(2, hangar.getId());
            statement.setString(1, hangar.getHangarnaam());

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   
    public DAHangar(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  

    public ArrayList<Hangar> getAlleHangars() {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.hangar");) {
            
            ResultSet resultset = statement.executeQuery();

            return new HangarFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Hangar getHangerByID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * from HANGAR where ID=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return resultset.next() ? new HangarFactory().maakObject(resultset) : null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verwijderHangarForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete from HANGAR where ID=?");) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
