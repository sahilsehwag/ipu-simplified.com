package org.ipunagri.support.parsers.html;


import org.ipunagri.support.models.ParsedRow;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPUParser extends HTMLParser {

    private List<ParsedRow> rows;
    private ParseType pdfType;

    public IPUParser(ParseType pdfType) {

        rows = new ArrayList();

        this.url = pdfType.getUrl();
        this.pdfType = pdfType;
    }

    public void generateRows() {

        String lines = download(url);
        Date uploadDate = null;

        Pattern pattern = pdfType.getRegex();
        Matcher matcher = pattern.matcher(lines);

        int counter = 0;
        while (matcher.find()) {
            String date = matcher.group(3);

            String match = matcher.group();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Calendar c = Calendar.getInstance();

            try {
                c.setTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            uploadDate = c.getTime();


            if (uploadDate.after(lastFetchDate) || uploadDate.equals(lastFetchDate)) {

                String url = makeURLAbsolute(matcher.group(1), pdfType.getPdfBaseURL().toString());

                try {
                    URL p = new URL(url);
                    ParsedRow row = new ParsedRow(uploadDate, matcher.group(2), p);
                    rows.add(row);
                } catch (Exception e) {
                    counter++;
                    e.printStackTrace();
                }
            }
        }
        System.out.println("...................Count: " + counter + "...................");
    }


    @Override
    protected ParsedRow parse() {
        return null;
    }


    public List<ParsedRow> getRows() {
        return rows;
    }

}
