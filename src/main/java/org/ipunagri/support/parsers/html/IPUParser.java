package org.ipunagri.support.parsers.html;


import org.ipunagri.support.Regexes;
import org.ipunagri.support.models.ParsedRow;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class IPUParser extends HTMLParser {

    private List<ParsedRow> rows;
    private ParseType pdfType;

    public IPUParser(ParseType pdfType) {
        this.url = url;
        this.pdfType = pdfType;
    }

    private void generateRows(){
        File file = download(url);

    }


    @Override
    protected ParsedRow parse() {
        return null;
    }


    public List<ParsedRow> getRows() {
        return rows;
    }

}
