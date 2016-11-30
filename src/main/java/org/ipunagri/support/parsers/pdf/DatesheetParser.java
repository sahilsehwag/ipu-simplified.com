package org.ipunagri.support.parsers.pdf;


import org.ipunagri.support.models.ParsedDatesheet;

import java.net.URL;

public class DatesheetParser extends PDFParser implements PDFToTextConverter {

    private ParsedDatesheet datesheet;

    public DatesheetParser(URL url) {
        super(url);
    }

    @Override
    protected String parse() {
        return null;
    }

    protected String nameGenerator() {
        return null;
    }


}
