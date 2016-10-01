package org.ipunagri.models;


import javax.persistence.*;
import javax.persistence.Entity;
import java.net.URL;
import java.util.Date;


@Entity
@Table(name = "PDF_LINKS")
@NamedQueries({
        @NamedQuery(name = "getRowsByPDFType", query = "FROM PDFLink AS pdf WHERE pdf.pdfType = :pdfType"),
        @NamedQuery(name = "getRowsByDateRange", query = "FROM PDFLink AS pdf WHERE (pdf.uploadDate >= :startDate and pdf.uploadDate <= :endDate)"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name="PDFLink.byPDFTypeInRange", query="SELECT * FROM PDF_LINKS WHERE PDF_TYPE = :pdfType LIMIT :start, :end", resultClass=PDFLink.class)
})
public class PDFLink implements IModel{

    public static String RESULT = "RESULT";
    public static String NOTICE = "NOTICE";
    public static String DATESHEET = "DATESHEET";
    public static String CETRESULT = "CETRESULT";


    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "PDF_TYPE")
    private String pdfType;

    @Column(name = "NAME")
    @Lob
    private String name;

    @Lob
    @Column(name = "URL")
    private URL url;

    @Column(name = "UPLOAD_DATE")
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

