/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public abstract class BaseFactory {

    protected int getIdForColumnName(String columnname, ResultSet resultset) throws SQLException {
        int id;
        try {
            id = resultset.getInt(columnname);
        } catch (Exception e) {
            id = resultset.getInt("id");
        }
        return id;
    }

    public abstract <T> T maakObject(ResultSet resultset) throws SQLException;

    //Maakt een lijst van een resultset met het type dat wordt meegegeven
    public <T> ArrayList<T> maakLijst(ResultSet resultset) throws SQLException {
        ArrayList<T> lijst = new ArrayList<>();

        while (resultset.next()) {
            T obj = maakObject(resultset);
            lijst.add(obj);
        }

        return lijst;
    }

}
