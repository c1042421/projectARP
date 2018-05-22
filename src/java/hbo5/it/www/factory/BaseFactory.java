/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author c1042421
 */
public class BaseFactory {
    protected static int checkIfIdExistsAndReturn(String columnname, ResultSet resultset) throws SQLException {
        int id;
        try {
            id = resultset.getInt(columnname);
        } catch (Exception e) {
            id = resultset.getInt("id");
        }
        return id;
    }
}
