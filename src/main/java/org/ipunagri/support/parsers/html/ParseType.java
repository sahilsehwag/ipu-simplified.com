package org.ipunagri.support.parsers.html;


import org.ipunagri.support.Regexes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public enum ParseType {

    RESULT("http://164.100.158.135/ExamResults/ExamResultsmain.htm",
            "http://164.100.158.135/ExamResults",
            Regexes.IPU_PDF.getRegex()),

    OLD_RESULTS("http://ipu.ac.in/exam_results.php",
                "http://ipu.ac.in",
                Regexes.IPU_PDF.getRegex()),

    NOTICE("http://ipu.ac.in/exam_notices.php",
            "http://ipu.ac.in",
            Regexes.IPU_PDF.getRegex()),

    DATESHEET("http://ipu.ac.in/exam_datesheet.php",
            "http://ipu.ac.in",
            Regexes.IPU_PDF.getRegex());

//    CET_RESULT("",
//            "",
//            Regexes.CET_RESULT.getRegex());


    private URL url;
    private URL pdfBaseURL;
    private Pattern regex;

    ParseType(String url, String pdfBaseURL, Pattern regex) {
        try{
            this.url = new URL(url);
            this.pdfBaseURL = new URL(pdfBaseURL);
        }catch(MalformedURLException e){
            System.out.println(url.toString());
            e.printStackTrace();
        }
        this.regex = regex;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL getPdfBaseURL() {
        return pdfBaseURL;
    }

    public void setPdfBaseURL(URL pdfBaseURL) {
        this.pdfBaseURL = pdfBaseURL;
    }

    public Pattern getRegex() {
        return regex;
    }

    public void setRegex(Pattern regex) {
        this.regex = regex;
    }
}
