package org.ipunagri.models;


import java.net.URL;
import java.util.Calendar;

public class PDFLink {

    private PDFType pdfType;
    private String name;
    private URL url;
    private Calendar uploadDate;

    public enum PDFType{
        RESULT, NOTICE, DATESHEET;
    }
}

