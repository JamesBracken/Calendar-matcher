package com.example.calendar.Employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    //May want to expand to include Dates

    //Name
    private String name;

    //List of meetings
    private List<List<String>> meetings;

    //Daily bounds
    private List<String> bounds;

    public Employee() {
    }

    public List<String> getBounds() {
        return bounds;
    }

    public void setBounds(List<String> bounds) {
        this.bounds = bounds;
    }

    public Employee(String name, ArrayList<List<String>> meetings, List<String> bounds) {
        this.name = name;
        this.meetings = meetings;
        this.bounds = bounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<String>> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<List<String>> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", meetings=" + meetings +
                '}';
    }
}
