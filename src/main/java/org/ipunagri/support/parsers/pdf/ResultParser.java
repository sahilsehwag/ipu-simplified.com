package org.ipunagri.support.parsers.pdf;


import org.ipunagri.support.models.ParsedResult;

import java.net.URL;
import java.util.Set;

public class ResultParser extends PDFParser implements PDFToTextConverter{

    private Set<ParsedResult> results;

    public ResultParser(URL url){
        super(url);
    }

    @Override
    protected String parse() {
        return null;
    }


    public Set<ParsedResult> getResults() {
        return results;
    }
    
    protected String nameGenerator() {
        return null;
    }
}
