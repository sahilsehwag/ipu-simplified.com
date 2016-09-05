package org.ipunagri.support;


import java.util.regex.Pattern;

public enum Regexes {


    IPU_PDF("<tr[^<>]*?>\\s*?\\n\\s*?<td><a\\s*?href=\"([^\"]*?)\">([^<>]*?)</a></td>\\s*?\\n\\s*?<td>([\\d-]*?)</td>\\s*?\\n\\s*?</tr>\\s*?"),
    CET_RESULT(""),
    PDF_RESULT(""),
    PDF_SUBJECTS(""),
    PDF_RESULT_DETAIL("");


    private Pattern regex;

    Regexes(String regex){
        this.regex = Pattern.compile(regex);
    }

    public Pattern getRegex() {
        return regex;
    }

    public void setRegex(Pattern regex) {
        this.regex = regex;
    }
}
