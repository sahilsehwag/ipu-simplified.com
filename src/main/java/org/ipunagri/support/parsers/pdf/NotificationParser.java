package org.ipunagri.support.parsers.pdf;


import org.ipunagri.support.models.ParsedNotice;

import java.net.URL;

public class NotificationParser extends PDFParser implements PDFToHTMLConverter {

    private ParsedNotice notification;


    public NotificationParser(URL url) {
        super(url);
    }


    @Override
    protected String parse() {
        return null;
    }

}
