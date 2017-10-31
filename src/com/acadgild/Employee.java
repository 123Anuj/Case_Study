package com.acadgild;


import com.departments.HRDepartment;
import com.departments.ManagementDepartment;
import com.departments.TechnicalDepartment;

/**
 * This class is of Normal Employee which are not fixed in any company.As in this class we declare all the details 
 * which the Employee generally have. 
 * @author Anuj Gautam
 *
 */
public class Employee{

private	 String deptName;
private  String name;
private  String designation;
private  	double salary;
private	int yearOfExperience;
private	 String adress;
private String dateOfJoining;
private String lateTimeLeaveAppliedOn;
public String getLateTimeLeaveAppliedOn() {
	return lateTimeLeaveAppliedOn;
}

/**
 * 
 * @param lateTimeLeaveAppliedOn
 */
public void setLateTimeLeaveAppliedOn(String lateTimeLeaveAppliedOn) {
	this.lateTimeLeaveAppliedOn = lateTimeLeaveAppliedOn;
}

private int leaveBalance;



public int getLeaveBalance() {
	return leaveBalance;
}
public void setLeaveBalance(int leaveBalance) {
	this.leaveBalance = leaveBalance;
}
public String getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;

}

private  String empId;


	
/**
 * Default constructor of the Employee class
 */
public Employee(){
	
}
	/**
	 * public Employee(String deptName,String name,String designation,double salary,int yearOfExperience,String adress,String empId
	 * As this is a public Parameterized constructor of the Employee class used to construct the object of the Employee and initialize the private static fields and it take many parameter as listed below:-
	 * @param deptName
	 * @param name
	 * @param designation
	 * @param salary
	 * @param yearOfExperience
	 * @param adress
	 * @param empId
	 * 
	 */
	public Employee(String deptName,String name,String designation,double salary,int yearOfExperience,String adress,String empId){
		
		this.adress=adress;
		
		this.deptName=deptName;
		this.designation=designation;
		this.salary=salary;
		this.yearOfExperience=yearOfExperience;
		this.name=name;
		this.empId=empId;
		
	}
	
	/**
	 * public Employee(String name, String empId):-
	 * 		This is another parameterized constructor of the Employee class which is taking arguments as name of the employee
	 *       and his/her employee id which can be used to see his/her details
	 * @param name
	 * @param empId
	 * @
	 */
	public Employee(String name, String empId){
	
		this.name=name;
		this.empId=empId;
	}
	

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
public int hashCode(){
	System.out.println("Inside Hashcode");
	int hashcode=0;
	hashcode=yearOfExperience*20;
	hashcode+=empId.hashCode();
	return hashcode;
	
}

public boolean equals(Object obj){
	System.out.println("Inside Equals ");
	if(obj instanceof Employee){
		Employee emp=(Employee)obj;
		return (emp.empId.equals(this.empId)&&emp.name==this.name);
		
	}
	else
	return false;
}

/**
 *public String getDeptName(): - 
 *	This is the public method or we can say accessor or getter which is used to get the value of the private 
 *  data of this class.
 * @return:- It returns the Department name of the Employee
 */
public String getDeptName() {
	return deptName;
}

/**
 * public void setDeptName(String deptName): -
 * 		This public method used to control changes to a variable. They are also widely known as setter methods.
 *       As this method is used to set the value of the private data of this class. Also known as mutators. 
 * @param deptName
 */
public void setDeptName(String deptName) {
	this.deptName = deptName;
}

/**
 * @return :- It returns the value of the private data member of this class.
 */
public String getName() {
	return name;
}

/**
 * It will set the value of private data member of this class
 * @param name 
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return :- It will return the designation of the Employee
 */
public String getDesignation() {
	return designation;
}

/**
 * This public method will set the value of designation of the employee.
 * @param designation
 */
public void setDesignation(String designation) {
	this.designation = designation;
}

/**
 * @return : - It will return the value of private data member salary of the employee.
 */
public double getSalary() {
	return salary;
}

/**
 * This public method is used to set the salary of the employee.
 * @param salary
 */
public void setSalary(double salary) {
	this.salary = salary;
}

/**
 * 
 * @return :- It will return the Experience of the Employee
 */
public int getYearOfExperience() {
	return yearOfExperience;
}

public void setYearOfExperience(int yearOfExperience) {
	this.yearOfExperience = yearOfExperience;
}

public String getAdress() {
	return adress;
}

public void setAdress(String adress) {
	this.adress = adress;
}

public String getEmpId() {
	return empId;
}

public void setEmpId(String empId) {
	this.empId = empId;
}
	
public String toString(){
	return deptName+" "+designation+" "+name;
}

/**
 * public String seeEmployeeId(String deptName,String name) :-
 * 			This public method is used when any employee wants to see it's Employee Id. He/she has to give 
 * 			his/her name and department name as an parameter to this method.
 * @param deptName
 * @param name
 * @return :- It will return the employee Id of the employee.
 * @throws InterruptedException 
 */
public String seeEmployeeId(String deptName,String name) throws InterruptedException{
	
	if(deptName.equalsIgnoreCase("Technical Department")||deptName.equalsIgnoreCase("Technical")){
		System.out.println("Please Wait while we are generating your Employee Id");
		Thread.sleep(5000);
		TechnicalDepartment tech1=new TechnicalDepartment();
		 String empId=tech1.generateEmloyeeId(name);
		 return empId;
	}
	
	else if(deptName.equalsIgnoreCase("Management Department")||deptName.equalsIgnoreCase("Management")||deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Operations Department")||deptName.equalsIgnoreCase("Operation")||deptName.equalsIgnoreCase("Operation Department")||deptName.equalsIgnoreCase("Sales")||deptName.equalsIgnoreCase("Sales Department")){
		System.out.println("Please Wait while we are generating your Employee Id");
		Thread.sleep(5000);
		ManagementDepartment mgmtdept=new ManagementDepartment();
		
		String empId=mgmtdept.generateEmloyeeId(name);
		return empId;
	}
	
	else if(deptName.equalsIgnoreCase("HR Department")||deptName.equalsIgnoreCase("HR")){
	
		System.out.println("Please Wait while we are generating your Employee Id");
		Thread.sleep(5000);
		HRDepartment hrDept=new HRDepartment();
		String empId=hrDept.generateEmloyeeId(name);
		return empId;
	}
	else{
		return null;
	}
	
}

/**
 * 
 * public double seeEmployeeSalary(String department,String name,String employeeId,String designation): -
 * 
 * 		This public method has a return type of double and taking many parameters as listed below and it is used
 *      when someone wants to see the salary of a particular Employee.
 * @param department
 * @param name
 * @param employeeId
 * @param designation
 * @return :- Salary of the employee in double.
 * @throws InterruptedException 
 */
public double seeEmployeeSalary(String department,String name,String employeeId,String designation, int yearOfExperience) throws InterruptedException{
	Employee e=new Employee();
	e.setDeptName(department);
	e.setName(name);
	e.setEmpId(employeeId);
	e.setDesignation(designation);
	e.setYearOfExperience(yearOfExperience);
	System.out.println("Please wait while We are checking information from your department....");
	Thread.sleep(5000);
	HRDepartment hr=new HRDepartment();
	double salary=hr.generateSalary(e.getDeptName(),e.getDesignation(),e.getName(),e.getEmpId(),e.getYearOfExperience());
	return salary;
}


 }




