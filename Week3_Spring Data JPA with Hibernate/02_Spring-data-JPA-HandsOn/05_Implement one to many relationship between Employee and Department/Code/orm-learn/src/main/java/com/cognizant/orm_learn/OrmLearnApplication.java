package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {

	@Autowired
	private DepartmentService departmentService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@PostConstruct
	public void testGetDepartment() {
		Department department = departmentService.get(1);
		System.out.println("Department: " + department);

		Set<Employee> employeeList = department.getEmployeeList();
		System.out.println("Employees in Department:");
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
}
