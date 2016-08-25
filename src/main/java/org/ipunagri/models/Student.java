package org.ipunagri.models;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity(name="STUDENTS")
@Table(name="STUDENTS")
public class Student {

    @EmbeddedId
    private RollNumber rollNumber;

    @Column(name="CURRENT_SEMESTER")
    private Integer currentSemester;

    public Student() {
    }

    public Student(RollNumber rollNumber, Integer currentSemester) {
        this.rollNumber = rollNumber;
        this.currentSemester = currentSemester;
    }


    public RollNumber getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(RollNumber rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }
}
