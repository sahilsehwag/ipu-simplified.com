package org.ipunagri.support.parsers;


import org.ipunagri.support.Utilities;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public abstract class Parser {

    protected URL url;
    protected File file;
    protected String parsedData;
    protected static Date lastFetchDate;
    protected static String dateFormat = "dd-MM-yyyy";

    static {
        setLastFetchDate();
    }


    public static Date getLastFetchDate() {
        return lastFetchDate;
    }

    public static void setLastFetchDate(Date lastFetchDate) {
        Parser.lastFetchDate = lastFetchDate;
    }

    protected abstract Object download(URL url);

    protected abstract Object parse();

    private static void setLastFetchDate() {
        Properties properties = new Properties();
        File config = new File("E:\\javaWork\\ipunagri\\src\\main\\webapp\\WEB-INF\\LastFetchDate.txt");
        String date = null;

        try (InputStream fileStream = new FileInputStream(config)) {

            properties.load(fileStream);
            date = properties.getProperty("lastFetchDate");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lastFetchDate = Utilities.parseDate(date, dateFormat);
        /*updateLastFetchDate(lastFetchDate);*/
    }

    public static void updateLastFetchDate(Date date) {
        String updateDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        updateDate = sdf.format(date);
        Properties properties = new Properties();
        File config = new File("E:\\javaWork\\ipunagri\\src\\main\\webapp\\WEB-INF\\LastFetchDate.txt");

        try (OutputStream fileStream = new FileOutputStream(config)) {

            properties.setProperty("lastFetchDate", updateDate);
            properties.store(fileStream, null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLastFetchDate(String date) {
        lastFetchDate = Utilities.parseDate(date, dateFormat);
        updateLastFetchDate(lastFetchDate);
    }

}
