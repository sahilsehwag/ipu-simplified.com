package org.ipunagri.support.models;


public class ParsedSubjectResult {

    private String subjecId;
    private int creditScored;
    private String internalMarks;
    private String externalMarks;
    private String totalMarks;
    private boolean back;
    private boolean grace;


    public ParsedSubjectResult(String subjecId, int creditScored, String internalMarks, String externalMarks, String totalMarks, boolean back, boolean grace) {
        this.subjecId = subjecId;
        this.creditScored = creditScored;
        this.internalMarks = internalMarks;
        this.externalMarks = externalMarks;
        this.totalMarks = totalMarks;
        this.back = back;
        this.grace = grace;
    }

    public String getSubjecId() {
        return subjecId;
    }

    public void setSubjecId(String subjecId) {
        this.subjecId = subjecId;
    }

    public int getCreditScored() {
        return creditScored;
    }

    public void setCreditScored(int creditScored) {
        this.creditScored = creditScored;
    }

    public String getInternalMarks() {
        return internalMarks;
    }

    public void setInternalMarks(String internalMarks) {
        this.internalMarks = internalMarks;
    }

    public String getExternalMarks() {
        return externalMarks;
    }

    public void setExternalMarks(String externalMarks) {
        this.externalMarks = externalMarks;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public boolean isBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    public boolean isGrace() {
        return grace;
    }

    public void setGrace(boolean grace) {
        this.grace = grace;
    }
}
