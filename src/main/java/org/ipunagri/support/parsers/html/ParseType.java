package org.ipunagri.support.parsers.html;


import org.ipunagri.support.Regexes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public enum ParseType {

    RESULT("http://164.100.158.135/ExamResults/ExamResultsmain.htm",
            "http://164.100.158.135/ExamResults/",
            Regexes.IPU_PDF.getRegex()),

    NOTICE("http://ipu.ac.in/exam_notices.php",
            "http://ggsipuresults.nic.in/ipu/examnotice/",
            Regexes.IPU_PDF.getRegex()),

    DATESHEET("http://ipu.ac.in/exam_datesheet.php",
            "http://ipu.ac.in/public/ExamDatesheets/",
            Regexes.IPU_PDF.getRegex()),

    CET_RESULT("",
            "",
            Regexes.CET_RESULT.getRegex());


    private URL url;
    private URL pdfBaseURL;
    private Pattern regex;

    ParseType(String url, String pdfBaseURL, Pattern regex) throws MalformedURLException {
        this.url = new URL(url);
        this.pdfBaseURL = new URL(pdfBaseURL);
        this.regex = regex;
    }

}
