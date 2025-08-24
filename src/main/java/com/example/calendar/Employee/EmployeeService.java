package com.example.calendar.Employee;

import com.example.calendar.Employee.entities.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//@Service
public class EmployeeService {

    //Check min and max for both employee bounds FINISHED
    //May need to convert Strings into minute integers FINISHED
    //Order meetings by nested list's-0 index
    //Create a for loop to loop over meetings
    //Using the for loop create a new list of meeting availability
    //Create a condition to only add items > meeting duration

    public void createEmployeesMeetingAvailability(Employee emp1, Employee emp2) { //ArrayList<Integer>
        ArrayList<List<Integer>> empMeetingsAggregated = convertEmpHoursToMins(emp1);
        empMeetingsAggregated.addAll(convertEmpHoursToMins(emp2));
        System.out.println("empMeetingsAggregated: " + empMeetingsAggregated);
    public ArrayList<List<Integer>> convertEmpHoursToMins(Employee emp) {
        ArrayList<List<Integer>> empMeetingsAggregated = new ArrayList<>();
        List<List<String>> empMeetings = emp.getMeetings();
        for (int i = 0; i < emp.getMeetings().size(); i++) {
            List<Integer> newList = new ArrayList<>();
            for (String time : empMeetings.get(i)) {
                newList.add(getTimeInMinutes(time));
            }
            empMeetingsAggregated.add(newList);
        }
        return empMeetingsAggregated;
    }

    public Integer getTimeInMinutes(String time) {
        int minutes = 0;
        String[] timeList = time.split(":");
        minutes += Integer.parseInt(timeList[0]) * 60;
        minutes += Integer.parseInt(timeList[1]);
        return minutes;
    }

}
