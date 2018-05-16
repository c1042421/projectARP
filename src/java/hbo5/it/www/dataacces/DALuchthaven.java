/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Vlucht;
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

    private Luchthaven getLuchthavenForID(int id) {
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM Luchthaven inner join Land on LAND_ID=LAND.ID where LUCHTHAVEN.ID = ?");) {

            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();

            return LuchthavenFactory.maakLuchthavenVanResultset(resultset);

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
}
