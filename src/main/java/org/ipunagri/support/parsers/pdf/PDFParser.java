package org.ipunagri.support.parsers.pdf;


import org.ipunagri.support.parsers.Parser;
import org.ipunagri.support.models.ParsedRow;

import java.io.File;
import java.net.URL;

public abstract class PDFParser extends Parser{


    private ParsedRow row;

    protected PDFParser(URL url){
        this.url = url;
    }

    @Override
    protected File download(URL url) {
        return null;
    }


    protected boolean validPDFUrl(URL url){
        return false;
    }


    public ParsedRow getRow() {
        return row;
    }

    public void setRow(ParsedRow row) {
        this.row = row;
    }
}
