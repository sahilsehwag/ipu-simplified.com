package org.ipunagri.support.models;


import java.net.URL;
import java.util.Calendar;

public class ParsedRow {

    private Calendar date;
    private String[] nameTokens;
    private URL url;


    public ParsedRow(Calendar date, String[] nameTokens, URL url) {
        this.date = date;
        this.nameTokens = nameTokens;
        this.url = url;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String[] getNameTokens() {
        return nameTokens;
    }

    public void setNameTokens(String[] nameTokens) {
        this.nameTokens = nameTokens;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
