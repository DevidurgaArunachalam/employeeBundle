package com.launchclub.employeeDao;

import java.util.Map;

import com.launchclub.employeeModel.Employee;

/**
 * Interface created for Employee database 
 */
public interface EmployeeDao {
    
    boolean addEmployee(final Employee employee);
    
    Map<Integer, Employee> viewEmployeeData();
    
    boolean deleteEmployee(final int employeeId);
    
    boolean updateEmployeeDetails(final Employee employee);
}
