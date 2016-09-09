package org.ipunagri.support.parsers;


import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Parser {

    protected URL url;
    protected File file;
    protected String parsedData;
    protected static Date lastFetchDate;

    static {
        String startDate = "01-01-2008";  // Start date

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        lastFetchDate = c.getTime();

    }


    public static Date getLastFetchDate() {
        return lastFetchDate;
    }

    public static void setLastFetchDate(Date lastFetchDate) {
        Parser.lastFetchDate = lastFetchDate;
    }

    protected abstract Object download(URL url);

    protected abstract Object parse();

}
