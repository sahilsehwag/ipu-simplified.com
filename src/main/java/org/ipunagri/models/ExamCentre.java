package org.ipunagri.models;


import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


@Entity(name="EXAM_CENTRES")
public class ExamCentre {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;

    @Column(name="COLLEGE_ID")
    private int collegeId;

    @Column(name="CENTRE_ID")
    private int centreId;

    @Column(name="PROGRAM_ID")
    private int programId;

    @Column(name="SEMESTER")
    private byte semester;

    @Column(name="EXAM_DATE")
    @Temporal(TemporalType.DATE)
    private Date examDate;

    public ExamCentre() {
    }

    public ExamCentre(int collegeId, int centreId, int programId, byte semester, Date examDate) {
        this.collegeId = collegeId;
        this.centreId = centreId;
        this.programId = programId;
        this.semester = semester;
        this.examDate = examDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getCentreId() {
        return centreId;
    }

    public void setCentreId(int centreId) {
        this.centreId = centreId;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public byte getSemester() {
        return semester;
    }

    public void setSemester(byte semester) {
        this.semester = semester;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
