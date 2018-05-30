/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataacces;
import hbo5.it.www.beans.Bemanningslid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author c1042421
 */
public class DAFunctie extends DABase {
   
    public DAFunctie(String url, String login, String password, String driver) throws ClassNotFoundException {
        super(url, login, password, driver);
    }  

    public ArrayList<Bemanningslid> voegFunctieToeAanBemanning(ArrayList<Bemanningslid> bemanning) {
        //TODO voeg de functie toe
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
