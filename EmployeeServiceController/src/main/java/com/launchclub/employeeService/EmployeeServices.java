package com.launchclub.employeeService;

import com.launchclub.employeeModel.Employee;

/**
 * Provides interface for EmployeeServiceImpl class
 */
public interface EmployeeServices {
    
    void addEmployee(final Employee employee);

	void viewEmployeeDetails();

	void updateEmployeeDetails(final Employee employee);
	
	void deleteEmployee(final int employeeId);
	
}
