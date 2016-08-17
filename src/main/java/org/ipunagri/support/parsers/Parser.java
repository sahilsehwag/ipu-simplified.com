package org.ipunagri.support.parsers;


import java.io.File;
import java.net.URL;

public abstract class Parser {

    protected URL url;
    protected File file;
    protected String parsedData;


    protected abstract File download(URL url);
    protected abstract String parse();

//    protected abstract String nameGenerator();

}
