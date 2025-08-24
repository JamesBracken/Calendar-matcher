package com.example.calendar;

import com.example.calendar.Employee.EmployeeService;
import com.example.calendar.Employee.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CalendarApplication {

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
//		SpringApplication.run(CalendarApplication.class, args);
		ArrayList<List<String>> employee1Meetings = new ArrayList<List<String>>();
//		List<String> employee1Bounds = Arrays.asList("9:00", "20:00");
		List<String> employee1Bounds = Arrays.asList("8:00", "20:00");
		employee1Meetings.add(new ArrayList<>(Arrays.asList("8:30", "10:30")));
		employee1Meetings.add(new ArrayList<>(Arrays.asList("9:00", "10:30")));
		employee1Meetings.add(new ArrayList<>(Arrays.asList("12:00", "13:00")));
		employee1Meetings.add(new ArrayList<>(Arrays.asList("13:00", "14:00")));
		employee1Meetings.add(new ArrayList<>(Arrays.asList("16:00", "18:00")));

		ArrayList<List<String>> employee2Meetings = new ArrayList<List<String>>();
//		List<String> employee2Bounds = Arrays.asList("10:00", "18:30");
		List<String> employee2Bounds = Arrays.asList("8:00", "20:30");
		employee2Meetings.add(new ArrayList<>(Arrays.asList("10:00", "11:30")));
		employee2Meetings.add(new ArrayList<>(Arrays.asList("12:30", "14:30")));
		employee2Meetings.add(new ArrayList<>(Arrays.asList("14:30", "15:00")));
		Employee employee1 = new Employee("Christopher", employee1Meetings, employee1Bounds);
		Employee employee2 = new Employee("James", employee2Meetings, employee2Bounds);

		int meetingDuration = 70;

		System.out.println("Application working");
		System.out.println(employee1);
		System.out.println(employee2);
		employeeService.createEmployeesMeetingAvailability(employee1, employee2, meetingDuration);
	}

}
