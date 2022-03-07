package com.launchclub.employeeDetailsValidation;

import java.time.LocalDate;

import org.osgi.service.component.annotations.Component;

import com.launchclub.employeeDao.EmployeeDao;
import com.launchclub.employeeDao.EmployeeDaoImpl;
import com.launchclub.employeeException.CustomException.InvalidInputException;
import com.launchclub.employeeService.EmployeeServiceImplVersion2;

@Component
public class EmployeeDetailsValidation implements employeeVaildator {

	public static final EmployeeDao EMPLOYEE_DAO = new EmployeeDaoImpl();

	/**
	 * <p>
	 * Checks the employee name as accepting only alphabets and returns the
	 * validated input to the Employee Details class.
	 * </p>
	 * 
	 * @return employeeName
	 */
	public boolean checkEmployeeName(final String employeeName) {
		return employeeName.matches("^([A-Za-z]+\\s)*[a-zA-Z]+$|^[a-zA-z]$") ? true : false;
	}

	/**
	 * <p>
	 * Checks the contactNumber as accepting only numeric values as in the pattern
	 * and returns the validated input to the Employee details class.
	 * </p>
	 * 
	 * @return contactNumber
	 */
	public  boolean checkContactNumber(final String contactNumber) {
		return contactNumber.matches("[6-9]{1}[0-9]{9}") ? true : false;
	}

	/**
	 * <p>
	 * Checks the as accepting only numeric values as in the pattern and returns the
	 * validated input to the Employee details class.
	 * </p>
	 * 
	 * @return salary
	 */
	public  boolean checkSalary(final String salary) {
		return salary.matches("[0-9]+([,.][0-9]{2,})?") ? true : false;
	}

	/**
	 * <p>
	 * Validating employee joining date by checking day, month, year of default
	 * calendar method. If any input other than predefined values are given, then
	 * the method is called again to get desired input.
	 * </p>
	 * 
	 * @param dateOfBirth
	 * @return date
	 */
	public  boolean dateValidation(final String dateOfJoining) {

		try {
			final LocalDate inputDate = LocalDate.parse(dateOfJoining);
			final LocalDate currentDate = LocalDate.now();

			if (currentDate.plusDays(1).isAfter(inputDate)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new InvalidInputException("Invalid Input!!!...");
		}
	}

	/**
	 * <p>
	 * Checks the employeeId which is available to update the employee details
	 * in the employee management system
	 * </p>
	 * 
	 * @param choice
	 * @return choice
	 */
	public  boolean employeeIdCorrect(final int employeeId) {
		return EmployeeServiceImplVersion2.employeeIdCorrect(employeeId);
	}

	/**
	 * <p>
	 * Checks the employee Id as accepting only numerical values and return the
	 * validated input to the Employee details class.
	 * </p>
	 * 
	 * @param employeeId
	 * @return employeeId
	 */
	public boolean employeeIdValidation(final String employeeId) {
		return employeeId.matches("[0-9]{1,}") ? true : false;
	}

	/**
	 * <p>
	 * Checks the choice of the user as accepting only numerical values from 1-5 and
	 * return the validated input to the Employee details class.
	 * </p>
	 * 
	 * @param choice
	 * @return choice
	 */
	public boolean choiceValidation(final String choice) {
		return choice.matches("[1-5]") ? true : false;
	}

	/**
	 * <p>
	 * Checks the employeeId which is available and return the validated input to
	 * the Employee details class.
	 * </p>
	 * 
	 * @param choice
	 * @return choice
	 */
	public boolean checkEmployeeId(String employeeId) {
		int employee = Integer.parseInt(employeeId);
		return (EMPLOYEE_DAO.viewEmployeeData().containsKey(employee)) ? true : false;
	}

}
