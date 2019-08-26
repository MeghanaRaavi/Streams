package com.training;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmpDept {

	public static void main(String[] args) {

		Department account = new Department("Account", 75); 
	      Department hr = new Department("HR", 50);
	      Department ops = new Department("OP", 25);
	      Department tech = new Department("Tech", 150);          
	   
	      List<Employee> employeeList = Arrays.asList(new  Employee("David", 32, "Matara", account), 
	                           new  Employee("Brayan", 25, "Galle", hr),
	                           new  Employee("JoAnne", 45, "Negombo", ops),
	                           new  Employee("Jake", 65, "Galle", hr),
	                           new  Employee("Brent", 55, "Matara", hr),
	                           new  Employee("Allice", 23, "Matara", ops),
	                           new  Employee("Austin", 30, "Negombo", tech),
	                           new  Employee("Gerry", 29, "Matara", tech),
	                           new  Employee("Scote", 20, "Negombo", ops),
	                           new  Employee("Branden", 32, "Matara", account),
	                           new  Employee("Iflias", 31, "Galle", hr));
	
	      System.out.println("Print Employees who lives in Matara");
	      employeeList.stream()
	      .filter(e -> e.getCity().equalsIgnoreCase("Matara"))
	      .sorted(Comparator.comparing(Employee::getName))
	      .forEach(e -> System.out.println(e.getName()));
	      
	      System.out.println("Print Distinct Departments");
	      employeeList.stream()
          .map(e -> e.getDepartment().getDepartmentName())
          .distinct()
          .forEach(System.out::println);
	      
	      System.out.println("Print Departments which have more than 50 Employees");
	      employeeList.stream()
          .map(Employee::getDepartment)
          .filter(d -> d.getNoOfEmployees() > 50)
          .distinct()
          .forEach(d -> System.out.println(d.getDepartmentName()));
	      
	      System.out.println("Print if employees work for HR department");
	      if (employeeList.stream()
	                .anyMatch(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("HR"))) { 
	    	  System.out.println("Found employees from HR department"); 
	      }
	
	}

}
