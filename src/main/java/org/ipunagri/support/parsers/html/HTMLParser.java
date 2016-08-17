package org.ipunagri.support.parsers.html;


import org.ipunagri.support.parsers.Parser;

import java.io.File;
import java.net.URL;

public abstract class HTMLParser extends Parser{

    @Override
    protected File download(URL url) {
        return null;
    }

    protected boolean validHTMLUrl(){
        return false;
    }
}
