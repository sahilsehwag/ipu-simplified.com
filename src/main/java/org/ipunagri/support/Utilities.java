package org.ipunagri.support;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public static Date parseDate(String date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        /*Calendar c = Calendar.getInstance();*/
        Date date_r = null;


        try {
//            c.setTime(sdf.parse(date));
            date_r = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        return c.getTime();
        return date_r;
    }


}
