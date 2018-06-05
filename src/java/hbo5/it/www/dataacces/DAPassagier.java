/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.factory.PassagierFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author c1042421
 */
public class DAPassagier extends DABase {

    public DAPassagier(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }

    public ArrayList<Passagier> getPassagiersForPersoonID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PASSAGIER WHERE persoon_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new PassagierFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int annuleerVluchtForPassagierWithVluchtID(int vluchtID, Persoon persoon) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete From Passagier where vlucht_id = ? and persoon_id = ?");) {

            statement.setInt(1, vluchtID);
            statement.setInt(2, persoon.getId());

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int boekVluchtForVluchtID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Select From Passagier where vlucht_ID = ?");) {

            statement.setInt(1, id);

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Passagier> getPassagiersForVluchtID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.PASSAGIER WHERE vlucht_id =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new PassagierFactory().maakLijst(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getPassagiersGemiddeldeLeeftijdForAankomstLuchthaven(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT geboortedatum FROM C1042421.Passagier "
                        + "inner join persoon on PERSOON_ID = PERSOON.id "
                        + "inner join vlucht on VLUCHT_ID=vlucht.ID "
                        + "WHERE AANKOMSTLUCHTHAVEN_ID =?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            int leeftijdenSom = 0;
            int aantalpassagiers = 0;

            while (resultset.next()) {
                LocalDate datum = resultset.getDate("geboortedatum").toLocalDate();
                LocalDate vandaag = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int leeftijd = Period.between(datum, vandaag).getYears();
                leeftijdenSom += leeftijd;
                aantalpassagiers++;
            }

            return leeftijdenSom / aantalpassagiers;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getAantalPassagiersForDag(int dagID) throws ClassNotFoundException {
        DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
        ArrayList<Vlucht> vluchtenOpDag = daVlucht.getVluchtenVoorDag(dagID);
        int aantalPassagiers = 0;
        
        for (Vlucht vlucht: vluchtenOpDag) {
           aantalPassagiers += getPassagiersForVluchtID(vlucht.getId()).size();
        }
        
        return aantalPassagiers;
    }
    
    public int getAantalPassagiersForMaand(int maandID) throws ClassNotFoundException {
        DAVlucht daVlucht = new DAVlucht(url, login, password, driver);
        ArrayList<Vlucht> vluchtenOpDag = daVlucht.getVluchtenVoorMaand(maandID);
        int aantalPassagiers = 0;
        
        for (Vlucht vlucht : vluchtenOpDag) {
            aantalPassagiers += getPassagiersForVluchtID(vlucht.getId()).size();
        }
        
        return aantalPassagiers;
    }
}
