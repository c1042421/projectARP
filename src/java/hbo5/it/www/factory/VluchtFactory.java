/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vlucht;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class VluchtFactory extends BaseFactory {

    public Vlucht maakVluchtVanResultset(ResultSet resultset) throws SQLException {

        if (resultset.next()) {
            return maakObject(resultset);
        }
        return null;
    }

    @Override
    public Vlucht maakObject(ResultSet resultset) throws SQLException {

        Vlucht vlucht = new Vlucht();

        vlucht.setId(resultset.getInt("id"));
        vlucht.setCode(resultset.getString("code"));
        vlucht.setVertrektijd(resultset.getDate("vertrektijd"));
        vlucht.setAankomsttijd(resultset.getDate("aankomsttijd"));
        vlucht.setVliegtuig_id(resultset.getInt("vliegtuig_id"));
        vlucht.setVertrekluchthaven_id(resultset.getInt("vertrekluchthaven_id"));
        vlucht.setAankomstluchthaven_id(resultset.getInt("aankomstluchthaven_id"));

        try {
            Luchthaven aankomst = new LuchthavenFactory().maakObject(resultset, "aankomstluchthaven_id");
            Luchthaven vertrek = new LuchthavenFactory().maakObject(resultset, "vertrekluchthaven_id");
            Vliegtuig vliegtuig = new VliegtuigFactory().maakObject(resultset);

            vlucht.setVliegtuig(vliegtuig);
            vlucht.setAankomstLuchthaven(aankomst);
            vlucht.setVertrekLuchthaven(vertrek);
        } catch (Exception e) {

        }

        return vlucht;
    }
}
