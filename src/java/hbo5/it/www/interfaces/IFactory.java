/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jelmarvanaert
 */
public interface IFactory {
    public <T> T maakObject(ResultSet resultset) throws SQLException;
    public <T> ArrayList<T> maakLijst(ResultSet resultset) throws SQLException;
}
