package com.launchclub.employeeExceptions;

public  class ConnectionNotFoundException extends CustomException {
	public ConnectionNotFoundException(String message) {
        super(message);
    }
}
