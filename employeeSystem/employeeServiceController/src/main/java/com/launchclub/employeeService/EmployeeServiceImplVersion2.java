package com.launchclub.employeeService;

import java.util.Map;

import com.launchclub.dao.EmployeeDao;
import com.launchclub.dao.EmployeeDaoImpl;
import com.launchclub.employeeExceptions.DataNotFoundException;
import com.launchclub.employeeExceptions.IdAlreadyExistsException;
import com.launchclub.employeeExceptions.IdNotFoundException;
import com.launchclub.model.Employee;

/**
 * Implements the EmployeeDB interface
 */
 public class EmployeeServiceImplVersion2 implements EmployeeDao {
     
    private static final EmployeeDaoImpl EMPLOYEE_DAO = new EmployeeDaoImpl();
    
    /**
     * Adds the employee details to the database
     */
    public boolean addEmployee(Employee employee) { 
        
        if (EMPLOYEE_DAO.viewEmployeeData().containsKey(employee.getEmployeeId())) {
            throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
        } else {
            return EMPLOYEE_DAO.addEmployee(employee);
        }
   }
 
    /**
     * Shows all the employee details from the database
     */
    public Map<Integer, Employee> viewEmployeeData() {     
        
        if (EMPLOYEE_DAO.viewEmployeeData().isEmpty()) {
           throw new DataNotFoundException("Data doesnot exists!!!...");
        }
        return EMPLOYEE_DAO.viewEmployeeData();  
    }

    /**
     * Deletes the employee details from the database
     */
    public boolean deleteEmployee(final int employeeId) {
        
        if (EMPLOYEE_DAO.deleteEmployee(employeeId)) {
            return true;
        } else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }

    /**
     * Updates the employee details from the database
     */
    public boolean updateEmployeeDetails(Employee employee) {
        boolean isUpdated = EMPLOYEE_DAO.updateEmployeeDetails(employee);
        
        if (isUpdated) {
            return true;
        }
        else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }
    
    /**
     * Checks the employeeId whether contained in the database and adds if not present 
     */
    public static boolean employeeIdCorrect(int employeeId) {
      
      if (!EMPLOYEE_DAO.viewEmployeeData().containsKey(employeeId)) {
        return true; 
      }
       throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
   }
    
    /**
     * Checks the employeeId whether contained in the database to update in the database
     */
    public static boolean employeeIdCorrectUpdate(int employeeId) {
        
        if (EMPLOYEE_DAO.viewEmployeeData().containsKey(employeeId)) {
            return true;
        }
        throw new IdNotFoundException("Employee Id Not Found!!!..."); 
    }
    
    /**
     * Checks the user choice to update the details to the employee database
     */
    public static boolean validateUserChoice(final String userChoice) {
        
        if (!userChoice.matches("(yes|no) |(YES|No)")) {
            return false;
         }
        return true;
    }
    
    /**
	 * <p>
	 * Checks the employeeId which is available and return the validated input to
	 * the Employee details class.
	 * </p>
	 * 
	 * @param employeeId
	 * @return employeeId
	 */
	public boolean checkEmployeeId(String employeeId) {
		int employee = Integer.parseInt(employeeId);
		return (EMPLOYEE_DAO.viewEmployeeData().containsKey(employee)) ? true : false;
	}
}

