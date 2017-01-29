package org.ipunagri.support.parsers;


import org.ipunagri.services.PDFLinkDao;
import org.ipunagri.support.Utilities;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public abstract class Parser implements ServletContextAware {

    protected URL url;
    protected File file;
    protected String parsedData;
    protected static Date lastFetchDate;
    protected static String dateFormat = "dd-MM-yyyy";

    private String CONFIG_FILE = "config.properties";

    protected static ServletContext servletContext;
    protected static ArrayList<String> todayURLs = null;


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public Date getLastFetchDate() {
        return lastFetchDate;
    }

    public void setLastFetchDate(Date lastFetchDate) {
        Parser.lastFetchDate = lastFetchDate;
    }

    protected abstract Object download(URL url);

    protected abstract Object parse();

    public ArrayList<String> getTodayURLs() {
        return todayURLs;
    }

    public void setTodayURLs(ArrayList<String> todayURLs) {
        Parser.todayURLs = todayURLs;
    }
}
