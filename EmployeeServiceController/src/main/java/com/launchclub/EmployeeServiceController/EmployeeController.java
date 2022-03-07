package com.launchclub.EmployeeServiceController;

import java.util.Map;

import com.launchclub.employeeModel.Employee;
import com.launchclub.employeeService.EmployeeServiceImplVersion2;

/**
 * <p>
 *    This controller class is used for getting the request from main and 
 *    gives it to the service.
 *    The input data fetched in view are processed and then called in employee main class.
 * </p>   
 */
public class EmployeeController {
    private final static EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();
    
    /**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     *    
     * @param employee
     */
	public static boolean addEmployee(final Employee employee) {
	    return EMPLOYEE_IMPL.addEmployee(employee);
	}
	
	/**
     * <p>
     *    Shows the employee details that are available in the
     *    
     * </p>
     */
	public static Map<Integer, Employee> viewEmployeeDetails() {
        return EMPLOYEE_IMPL.viewEmployeeData();  
	}
	
	/**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employee
     */ 
	public static boolean updateEmployeeDetails(Employee employee) {
	    return EMPLOYEE_IMPL.updateEmployeeDetails(employee);
	}
	
	/**
     * <p>
     *    Adds the employee details by getting the inputs from the user
     *    and stores in the database.
     * </p>
     * @param employeeId
     */
	public static boolean deleteEmployee(int employeeId) {
	    return EMPLOYEE_IMPL.deleteEmployee(employeeId);
    }
}
