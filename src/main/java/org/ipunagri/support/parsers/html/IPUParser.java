package org.ipunagri.support.parsers.html;


import org.ipunagri.services.PDFLinkDao;
import org.ipunagri.support.models.ParsedRow;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPUParser extends HTMLParser {

    private LinkedList<ParsedRow> rows;
    private ParseType pdfType;


    private PDFLinkDao pdfLinkDao;


    public IPUParser(ParseType pdfType, PDFLinkDao pdfLinkDao) {

        rows = new LinkedList<ParsedRow>();

        this.url = pdfType.getUrl();
        this.pdfType = pdfType;
        this.pdfLinkDao = pdfLinkDao;
    }

    public void generateRows(String pdfTypeString, Date lastFetchDate) {

        if (lastFetchDate == null) {
            lastFetchDate = new Date(2010, 1, 1);
            lastFetchDate.setYear(lastFetchDate.getYear() - 1900);
        }

        ArrayList<String> oldRows = pdfLinkDao.getLastFetchDatesRows(pdfTypeString, lastFetchDate);
        String lines = download(url);
        Date uploadDate = null;

        Pattern pattern = pdfType.getRegex();
        Matcher matcher = pattern.matcher(lines);

        while (matcher.find()) {
            String date = matcher.group(3);
            SimpleDateFormat sdf = null;

            if (date.length() < 10)
                sdf = new SimpleDateFormat("dd-MM-yy");
            else
                sdf = new SimpleDateFormat("dd-MM-yyyy");

            Calendar c = Calendar.getInstance();

            try {
                c.setTime(sdf.parse(date));
                uploadDate = c.getTime();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            if (uploadDate.after(lastFetchDate) || uploadDate.equals(lastFetchDate)) {
                String url = makeURLAbsolute(matcher.group(1), pdfType.getPdfBaseURL().toString());

                try {
                    URL p = new URL(url);
                    ParsedRow row = new ParsedRow(uploadDate, matcher.group(2).trim(), p);
                    if (!oldRows.contains(row.getName())) {
                        rows.addFirst(row);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
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