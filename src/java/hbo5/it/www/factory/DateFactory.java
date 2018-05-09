package hbo5.it.www.factory;

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