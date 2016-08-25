package org.ipunagri.models;


import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="PROGRAMS")
@Table(name="PROGRAMS")
public class Program {

    @Id
    @Column(name="PROGRAM_ID")
    private int id;

    @Column(name="COURSE_NAME")
    private String courseName;

    @Column(name="STREAM_NAME")
    private String streamName;

    public Program() {
    }

    public Program(int id, String courseName, String streamName) {
        this.id = id;
        this.courseName = courseName;
        this.streamName = streamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }
}
