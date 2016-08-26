package org.ipunagri.support.parsers.html;


import org.ipunagri.support.Regexes;
import org.ipunagri.support.models.ParsedRow;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.regex.Pattern;

public class IPUParser extends HTMLParser {

    private Set<ParsedRow> rows;

    public IPUParser(URL url) {
        this.url = url;
    }

    private void generateRows(String row){

    }


    @Override
    protected String parse() {
        return null;
    }


    public Set<ParsedRow> getRows() {
        return rows;
    }

}
