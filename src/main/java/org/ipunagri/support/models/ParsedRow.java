package org.ipunagri.support.models;


import java.net.URL;
import java.util.Calendar;

public class ParsedRow {

    private Calendar date;
    private String name;
    private URL url;


    public ParsedRow(Calendar date, String name, URL url) {
        this.date = date;
        this.name = name;
        this.url = url;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
