/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import hbo5.it.www.interfaces.IFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author c1042421
 */
public abstract class BaseFactory implements IFactory {
    protected static int checkIfIdExistsAndReturn(String columnname, ResultSet resultset) throws SQLException {
        int id;
        try {
            id = resultset.getInt(columnname);
        } catch (Exception e) {
            id = resultset.getInt("id");
        }
        return id;
    }
    
     protected int checkIfIdExistsAndReturnNotStatic(String columnname, ResultSet resultset) throws SQLException {
        int id;
        try {
            id = resultset.getInt(columnname);
        } catch (Exception e) {
            id = resultset.getInt("id");
        }
        return id;
    }
  
    @Override
    public abstract <T> T maakObject(ResultSet resultset) throws SQLException;

    //Maakt een lijst van een resultset met het type dat wordt meegegeven
    @Override
    public <T> ArrayList<T> maakLijst(ResultSet resultset) throws SQLException {
        ArrayList<T> lijst = new ArrayList<>();
        
        while (resultset.next()) {
            T object = maakObject(resultset);
            lijst.add(object);
        }
        
        return lijst;
    }

}
