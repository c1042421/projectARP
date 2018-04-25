/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo.it.www.factory;

import java.util.Date;

/**
 *
 * @author c1042421
 */
public class DateFactory {
     public static Date toUtilDateFromSqlDate(java.sql.Date date) {
        return new Date(date.getTime());
    }
}
