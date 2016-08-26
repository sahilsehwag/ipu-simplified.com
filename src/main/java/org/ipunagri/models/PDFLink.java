package org.ipunagri.models;


import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import javax.persistence.Table;


@Entity(name="PDF_LINKS")
@Table(name="PDF_LINKS")
public class PDFLink {

    private static String RESULT = "RESULT";
    private static String NOTICE = "NOTICE";
    private static String DATESHEET = "DATESHEET";
    private static String CETRESULT = "CETRESULT";


    @Id
    @GeneratedValue
    private int id;

    @Column(name="PDF_TYPE")
    private String pdfType;

    @Column(name="NAME")
    private String name;

    @Column(name="URL")
    private URL url;

    @Column(name="UPLOAD_DATE")
    @Temporal(TemporalType.DATE)
    private Date uploadDate;


    public PDFLink() {
    }

    public PDFLink(String pdfType, String name, URL url, Date uploadDate) {
        this.pdfType = pdfType;
        this.name = name;
        this.url = url;
        this.uploadDate = uploadDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getPdfType() {
        return pdfType;
    }

    public void setPdfType(String pdfType) {
        this.pdfType = pdfType;
    }
}

