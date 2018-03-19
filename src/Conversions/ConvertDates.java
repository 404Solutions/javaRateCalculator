package Conversions;

import java.util.Date;

/**
 * Class that holds functions to convert javaDates and SqlDates to one another
 */
public class ConvertDates {

    /**
     * Convert java Date to sql date
     * @param uDate
     * @return
     */
   public static java.sql.Date convertToSqlDate(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    /**
     * Convert sql date to java date
     * @param sDate
     * @return
     */
    public static java.util.Date convertToUtilDate(java.sql.Date sDate){
        java.util.Date uDate = null;
        if (sDate != null) {
            uDate = new Date(sDate.getTime());
        }
        return uDate;
    }
}
