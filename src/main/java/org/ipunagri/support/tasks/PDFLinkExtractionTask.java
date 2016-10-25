package org.ipunagri.support.tasks;


import org.ipunagri.models.PDFLink;
import org.ipunagri.services.PDFLinkDao;
import org.ipunagri.support.models.ParsedRow;
import org.ipunagri.support.parsers.Parser;
import org.ipunagri.support.parsers.html.IPUParser;
import org.ipunagri.support.parsers.html.ParseType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PDFLinkExtractionTask {

    @Autowired
    PDFLinkDao pdfLinksDAO;

    public void getResultPDFLinks() {
        ParseType pdfType = ParseType.RESULT;
        IPUParser ipuParser = new IPUParser(pdfType);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {

        }
        else {
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.RESULT);
        }

    }

    public void getNoticePDFLinks() {
        ParseType p = ParseType.NOTICE;
        IPUParser ipuParser = new IPUParser(p);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {
        }
        else {
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.NOTICE);
        }

    }

    public void getDatesheetPDFLinks() {
        ParseType p = ParseType.DATESHEET;
        IPUParser ipuParser = new IPUParser(p);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {
        }
        else {
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.DATESHEET);
        }


    }

    public void getOldResultPDFLinks() {
        ParseType pdfType = ParseType.OLD_RESULTS;
        IPUParser ipuParser = new IPUParser(pdfType);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();


        if (rows.isEmpty()) {
        }
        else {
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.RESULT);
        }

    }

    public void updateLastFetchDate(){
        Parser.updateLastFetchDate(new Date());
    }

}
