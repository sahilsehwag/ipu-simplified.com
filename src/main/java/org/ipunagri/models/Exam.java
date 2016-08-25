package org.ipunagri.models;


import javax.persistence.*;
import java.util.Date;

@Entity(name="EXAMS")
@Table(name="EXAMS")
public class Exam {

    @Id
    @GeneratedValue
    @Column(name="EXAM_ID")
    private int id;

    @Column(name="SUBJECT_ID")
    private int subjectId;

    @Column(name="PROGRAM_ID")
    private int programId;

    @Column(name="EXAM_DATE")
    @Temporal(TemporalType.DATE)
    private Date examDate;

    public Exam(){
    }

    public Exam(int subjectId, int programId, Date examDate) {
        this.subjectId = subjectId;
        this.programId = programId;
        this.examDate = examDate;
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

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
