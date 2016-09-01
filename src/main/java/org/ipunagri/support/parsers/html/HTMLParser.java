package org.ipunagri.support.parsers.html;


import org.ipunagri.support.parsers.Parser;

import javax.imageio.stream.FileCacheImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public abstract class HTMLParser extends Parser{

    @Override
    protected File download(URL url) {
        try {

            URLConnection connection = url.openConnection();
            InputStream htmlStream = connection.getInputStream();
            FileOutputStream htmlFile = new FileOutputStream(HTMLParser.class.getResource("temp.html").getFile());

            while(htmlStream.available() == 0){
                htmlFile.write(htmlStream.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected boolean validHTMLUrl(){
        return false;
    }
}
