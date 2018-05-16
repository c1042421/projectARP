/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author c1042421
 */
public class DALuchtvaartmaatschappij extends DABase {
   
    public DALuchtvaartmaatschappij(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  
}
