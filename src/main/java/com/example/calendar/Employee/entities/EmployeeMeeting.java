package com.example.calendar.Employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employeeMeetings")
public class EmployeeMeeting {
    //May want to expand to include Dates

    //Name
    private String name;

    //List of meetings
    private List<List<String>> meetingTimes;

    //Daily bounds
    private List<String> bounds;

    public EmployeeMeeting() {
    }

    public List<String> getBounds() {
        return bounds;
    }

    public void setBounds(List<String> bounds) {
        this.bounds = bounds;
    }

    public EmployeeMeeting(String name, ArrayList<List<String>> meetings, List<String> bounds) {
        this.name = name;
        this.meetingTimes = meetings;
        this.bounds = bounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<String>> getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(List<List<String>> meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", meetings=" + meetingTimes +
                '}';
    }
}
