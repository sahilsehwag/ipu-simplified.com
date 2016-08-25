package org.ipunagri.models;


import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;

@Table(name="COLLEGES")
@Entity(name="COLLEGES")
public class College {

    @Id
    @GeneratedValue
    @Column(name="COLLEGE_ID")
    private int id;

    @Column(name="COLLEGE_NAME", unique=true)
    private String name;

    @Column(name="COLLEGE_WEBSITE")
    private URL websiteURL;

    @Column(name="COLLEGE_NOTICE_PAGE_URL")
    private String noticePageURL;

    public College() {
    }

    public College(String name, URL websiteURL, String noticePageURL) {
        this.name = name;
        this.websiteURL = websiteURL;
        this.noticePageURL = noticePageURL;
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

    public URL getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(URL websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getNoticePageURL() {
        return noticePageURL;
    }

    public void setNoticePageURL(String noticePageURL) {
        this.noticePageURL = noticePageURL;
    }
}
