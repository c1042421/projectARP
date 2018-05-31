/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.factory.VluchtFactory;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public class DAVlucht extends DABase {

    public DAVlucht(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }

    public Vlucht getVluchtForVluchtID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM C1042421.VLucht WHERE id=?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return new VluchtFactory().maakVluchtVanResultset(resultset);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Passagier> voegVluchtenVoorPassagiersToe(ArrayList<Passagier> passagiers) {
        ArrayList<Passagier> passagiersMetVlucht = new ArrayList<>();

        for (Passagier passagier : passagiers) {
            Vlucht vlucht = getVluchtForVluchtID(passagier.getVlucht_id());
            passagier.setVlucht(vlucht);
            passagiersMetVlucht.add(passagier);
        }

        return passagiersMetVlucht;
    }

    public ArrayList<VluchtBemanning> voegVluchtenVoorBemanningToe(ArrayList<VluchtBemanning> vluchtbemanning) {
        ArrayList<VluchtBemanning> vluchtbemanningMetVlucht = new ArrayList<>();
        
        for (VluchtBemanning vlubem : vluchtbemanning) {
            Vlucht vlucht = getVluchtForVluchtID(vlubem.getVlucht_id());
            vlubem.setVlucht(vlucht);
            vluchtbemanningMetVlucht.add(vlubem);
        }
        return vluchtbemanningMetVlucht;
    }
    
    public int annuleerVluchtForVluchtID(int vluchtID) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("Delete From Vlucht where ID = ?");) {

            statement.setInt(1, vluchtID);

            return statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean checkOfVluchtBemanningsLidBevat(int bemanningsID) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("select * From vluchtbemanning where bemanningslid_id = ?");) {

            statement.setInt(1, bemanningsID);

            ResultSet resultset = statement.executeQuery();
            
            return resultset.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
