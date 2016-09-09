package org.ipunagri.support.models;


import java.net.URL;
import java.util.Date;

public class ParsedRow {

    private Date date;
    private String name;
    private URL url;

    public ParsedRow() {

    }

    public ParsedRow(Date date, String name, URL url) {
        this.date = date;
        this.name = name;
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
