package com.example.calendar.Employee;

import com.example.calendar.Employee.entities.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//@Service
public class EmployeeService {

    //Check min and max for both employee bounds FINISHED
    //May need to convert Strings into minute integers FINISHED
    //Order meetings by nested list's-0 index FINISHED
    //Add meetings which account for the time between bounds and first/last meetings
    //Create a for loop to loop over meetings FINISHED
    //Using the for loop create a new list of meeting availability FINISHED
    //Create a condition to only add items > meeting duration FINISHED
    //Return a list of the available meeting times converted back into strings FINISHED

    public ArrayList<List<String>> getEmployeesMeetingAvailability(Employee emp1, Employee emp2, int meetingDuration) { //ArrayList<Integer>
        //Start and end bounds accounting for both employees
        Integer startBound = Math.max(getTimeInMinutes(emp1.getBounds().get(0)), getTimeInMinutes(emp2.getBounds().get(0)));
        Integer endBound = Math.min(getTimeInMinutes(emp1.getBounds().get(1)), getTimeInMinutes(emp2.getBounds().get(1)));

        ArrayList<List<Integer>> empMeetingTimesAggregated = convertEmpHoursToMins(emp1);
        empMeetingTimesAggregated.addAll(convertEmpHoursToMins(emp2));

        //Sorting employee meetings aggregated
        empMeetingTimesAggregated.sort(Comparator.comparing(nestedList -> nestedList.get(0)));
        System.out.println("empMeetingsAggregated: " + empMeetingTimesAggregated);

        //Get gaps in employees meetings
        ArrayList<List<Integer>> possibleMeetingTimes = getMeetingGaps(empMeetingTimesAggregated, meetingDuration, startBound, endBound);

        //Convert meeting times back into string format
//        convertListOfMinsToTimeFormat(possibleMeetingTimes);
        System.out.println("conertedListOfMinsToTimeFormat: " + convertListOfMinsToTimeFormat(possibleMeetingTimes));
        return convertListOfMinsToTimeFormat(possibleMeetingTimes);
    }

    //Converts integer format time to String formatted times
    public ArrayList<List<String>> convertListOfMinsToTimeFormat(ArrayList<List<Integer>> meetingTimes) {
        ArrayList<List<String>> convertedList = new ArrayList<>();
        for(int i = 0; i < meetingTimes.size(); i++) {
            List<String> newList = new ArrayList<>();
            for(Integer meetingMinutes: meetingTimes.get(i)) {
                int hours = (int) Math.floor(meetingMinutes / 60);
                int extraMinutes = meetingMinutes % 60;
                newList.add(String.format("%02d:%02d", hours, extraMinutes));
            }
            convertedList.add(newList);
        }
        return convertedList;
    }

    // List of the meetings in minute format, meeting duration
    public ArrayList<List<Integer>> getMeetingGaps(ArrayList<List<Integer>> aggregatedMeetings, Integer meetingDuration, Integer startBound, Integer endBound) {
        ArrayList<List<Integer>> possibleMeetingTimes = new ArrayList<>();
        //Between start bound and first meeting
        if(aggregatedMeetings.get(0).get(0) - startBound >= meetingDuration) {
            possibleMeetingTimes.add(Arrays.asList(startBound, aggregatedMeetings.get(0).get(0)));
        }

        for(int i = 0; i < aggregatedMeetings.size() - 1; i++) {
            if(aggregatedMeetings.get(i + 1).get(0) - aggregatedMeetings.get(i).get(1) >= meetingDuration) {
                possibleMeetingTimes.add(Arrays.asList(aggregatedMeetings.get(i).get(1), aggregatedMeetings.get(i + 1).get(0)));
            }
        }

        //Between last meeting and end bound
        if(aggregatedMeetings.get(aggregatedMeetings.size() - 1).get(1) + meetingDuration <= endBound) {
            possibleMeetingTimes.add(Arrays.asList(aggregatedMeetings.get(aggregatedMeetings.size() - 1).get(1), endBound));
        }
        return possibleMeetingTimes;
    }

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
