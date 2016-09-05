package org.ipunagri.support.parsers.html;


import org.ipunagri.support.models.ParsedRow;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPUParser extends HTMLParser {

    private List<ParsedRow> rows;
    private ParseType pdfType;

    public IPUParser(ParseType pdfType) {
        this.url = pdfType.getUrl();
        this.pdfType = pdfType;
    }

    private void generateRows() {

        String lines = download(url);

        Pattern pattern = pdfType.getRegex();
        Matcher matcher = pattern.matcher(lines);

        while (matcher.find()) {
            String date[] = matcher.group(3).split("-");

            Calendar uploadDate =
                    new GregorianCalendar(Integer.parseInt(date[2]),
                            Integer.parseInt(date[1]),
                            Integer.parseInt(date[0]));

            String url = makeURLAbsolute(matcher.group(1), pdfType.getPdfBaseURL().getPath());

            try {
                ParsedRow row = new ParsedRow(uploadDate, matcher.group(2), new URL(url));
                rows.add(row);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    protected ParsedRow parse() {
        return null;
    }


    public List<ParsedRow> getRows() {
        return rows;
    }

}
