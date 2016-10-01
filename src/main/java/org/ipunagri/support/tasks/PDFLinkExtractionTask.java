package org.ipunagri.support.tasks;


import org.ipunagri.models.PDFLink;
import org.ipunagri.services.PDFLinkDao;
import org.ipunagri.support.models.ParsedRow;
import org.ipunagri.support.parsers.html.IPUParser;
import org.ipunagri.support.parsers.html.ParseType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PDFLinkExtractionTask {

    @Autowired
    PDFLinkDao pdfLinksDAO;

    public void getResultPDFLinks() {
        System.out.println("================================RESULTS==========================================================");
        ParseType pdfType = ParseType.RESULT;
        IPUParser ipuParser = new IPUParser(pdfType);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!ROWS ARE NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!EXECUTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.RESULT);
        }

        System.out.println("================================RESULTS==========================================================");
    }

    public void getNoticePDFLinks() {
        System.out.println("================================NOTICES==========================================================");
        ParseType p = ParseType.NOTICE;
        IPUParser ipuParser = new IPUParser(p);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!ROWS ARE NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!EXECUTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.NOTICE);
        }

        System.out.println("================================NOTICES==========================================================");

    }

    public void getDatesheetPDFLinks() {
        System.out.println("=================================DATESHEETS=========================================================");
        ParseType p = ParseType.DATESHEET;
        IPUParser ipuParser = new IPUParser(p);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        if (rows.isEmpty()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!ROWS ARE NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!EXECUTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.DATESHEET);
        }

        System.out.println("=================================DATESHEETS=========================================================");

    }

    public void getOldResultPDFLinks() {
        System.out.println("=================================OLD RESULTS=========================================================");
        ParseType pdfType = ParseType.OLD_RESULTS;
        IPUParser ipuParser = new IPUParser(pdfType);

        ipuParser.generateRows();
        List<ParsedRow> rows = ipuParser.getRows();

        System.out.println("!!!!!!!!!!!!!!!!!!!HERE I AM!!!!!!!!!!!!!!!!!!!!!!");

        if (rows.isEmpty()) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!ROWS ARE NULL!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!EXECUTING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            pdfLinksDAO.saveOrUpdateAll(rows, PDFLink.RESULT);
        }

        System.out.println("=================================OLD RESULTS=========================================================");

    }

    public void updateLastFetchDate(){
        IPUParser.setLastFetchDate(new Date());
    }

}
