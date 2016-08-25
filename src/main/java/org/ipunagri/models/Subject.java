package org.ipunagri.models;


import javax.persistence.*;


@Entity(name="SUBJECTS")
@Table(name="SUBJECTS")
public class Subject {

    private static final String THEORY = "THEORY";
    private static final String PRACTICAL = "PRACTICAL";

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;

    @Column(name="SUBJECT_ID")
    private int subjectId;

    @Column(name="SUBJECT_CODE")
    private String subjectCode;

    @Column(name="PROGRAM_ID")
    private int programId;

    @Column(name="SUBJECT_NAME")
    private String subjectName;

    @Column(name="SEMSETER")
    private int semester;

    @Column(name="TOTAL_CREDIT")
    private int totalCredit;

    @Column(name="COMPULSARY")
    private boolean isCompulsary;

    @Column(name="DROPPABLE")
    private boolean isDroppable;

    @Column(name="SUBJECT_TYPE")
    private String subjectType;


    public Subject() {
    }

    public Subject(int subjectId, String subjectCode, int programId, String subjectName, int semester, int totalCredit, boolean isCompulsary, boolean isDroppable) {
        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.programId = programId;
        this.subjectName = subjectName;
        this.semester = semester;
        this.totalCredit = totalCredit;
        this.isCompulsary = isCompulsary;
        this.isDroppable = isDroppable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public boolean isCompulsary() {
        return isCompulsary;
    }

    public void setCompulsary(boolean isCompulsary) {
        this.isCompulsary = isCompulsary;
    }

    public boolean isDroppable() {
        return isDroppable;
    }

    public void setDroppable(boolean isDroppable) {
        this.isDroppable = isDroppable;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }
}
