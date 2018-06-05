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
public class DABase {
    protected final String url, login, password, driver;

    public DABase(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.driver = driver;
        this.url = url;
        this.login = login;
        this.password = password;
    }  
}
