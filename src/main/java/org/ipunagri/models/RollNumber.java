package org.ipunagri.models;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
public class RollNumber {

    @Column(name="STUDENT_ID")
    private Integer studentId;

    @Column(name="COLLEGE_ID")
    private Integer collegeId;

    @Column(name="PROGRAM_ID")
    private Integer programId;

    public RollNumber() {
    }

    public RollNumber(Integer studentId, Integer collegeId, Integer programId) {
        this.studentId = studentId;
        this.collegeId = collegeId;
        this.programId = programId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }
}
