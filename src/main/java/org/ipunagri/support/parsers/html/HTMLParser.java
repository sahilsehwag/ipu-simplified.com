package org.ipunagri.support.parsers.html;


import org.ipunagri.support.parsers.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public abstract class HTMLParser extends Parser {


    @Override
    protected String download(URL url) {
        String lines = null;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(url.openStream()))) {

            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while ((lines = br.readLine()) != null) {
                stringBuilder.append(lines);
                stringBuilder.append(ls);
            }
            lines = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    protected String makeURLAbsolute(String url, String baseURL) {

        url = url.trim();

        if (url.substring(0, 12).equals("/ExamResults"))
            url = "http://164.100.158.135" + url;


        else if (url.charAt(0) == '/')
            url = baseURL + url;

        else if (!url.substring(0, 4).equals("http"))
            url = baseURL + url;

        return url;
    }

    protected boolean validHTMLUrl() {
        return false;
    }
}
