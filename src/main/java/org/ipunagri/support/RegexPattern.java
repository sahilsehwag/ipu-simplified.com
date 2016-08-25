package org.ipunagri.support;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegexPattern {

    RESULTS(""),
    SUBJECTS(""),
    COLLEGES(""),
    RESULT_DETAILS("");

    private Pattern pattern;

    RegexPattern(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public Matcher getMatcher(String text){
        return this.pattern.matcher(text);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
