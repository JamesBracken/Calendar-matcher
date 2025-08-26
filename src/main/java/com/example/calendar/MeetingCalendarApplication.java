package com.example.calendar;

import com.example.calendar.Employee.EmployeeMeetingService;
import com.example.calendar.Employee.entities.EmployeeMeeting;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MeetingCalendarApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CalendarApplication.class, args);  -- Leaving for future iterations where the project will be made into a spring project
		EmployeeMeetingService employeeService = new EmployeeMeetingService();
		ArrayList<List<String>> employee1MeetingsList = new ArrayList<>();
		List<String> employee1Bounds = Arrays.asList("8:00", "20:00");
		employee1MeetingsList.add(new ArrayList<>(Arrays.asList("8:30", "10:30")));
		employee1MeetingsList.add(new ArrayList<>(Arrays.asList("9:00", "10:30")));
		employee1MeetingsList.add(new ArrayList<>(Arrays.asList("12:00", "13:00")));
		employee1MeetingsList.add(new ArrayList<>(Arrays.asList("13:00", "14:00")));
		employee1MeetingsList.add(new ArrayList<>(Arrays.asList("16:00", "18:00")));

		ArrayList<List<String>> employee2MeetingsList = new ArrayList<>();
		List<String> employee2Bounds = Arrays.asList("8:00", "20:30");
		employee2MeetingsList.add(new ArrayList<>(Arrays.asList("10:00", "11:30")));
		employee2MeetingsList.add(new ArrayList<>(Arrays.asList("12:30", "14:30")));
		employee2MeetingsList.add(new ArrayList<>(Arrays.asList("14:30", "15:00")));
		EmployeeMeeting employee1Meetings = new EmployeeMeeting("Christopher", employee1MeetingsList, employee1Bounds);
		EmployeeMeeting employee2Meetings = new EmployeeMeeting("James", employee2MeetingsList, employee2Bounds);

		int meetingDuration = 30;

		employeeService.getEmployeesMeetingAvailability(employee1Meetings, employee2Meetings, meetingDuration);
	}
}