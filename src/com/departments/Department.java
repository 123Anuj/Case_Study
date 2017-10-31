package com.departments;

import com.acadgild.Company;

/**
 * @author sumit
 *
 */
public abstract class Department extends Company {

String deptName;
String deptId;

String employeeDateOfJoining;

/* (non-Javadoc)
 * @see com.acadgild.Company#doWork()
 */
public abstract void doWork();

/**
 * String generateEmployeeId(String name)
 * This method is used to generate the Employee Id and it is taking the name of the employee as an parameter
 * and returning a String value as employee Id.
 * @param name:- Name of the Employee
 * @return a String value as Employee Id 
 */
public abstract String generateEmloyeeId(String name);
	
}
