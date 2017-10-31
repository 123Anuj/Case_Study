package com.departments;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

public class HRDepartment extends Department{

	static String deptId="HR_103";

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		System.out.println("");
	}
	
	/**
	 * This is a protected method and used to generate the salary of the employee and taking a list of parameters as listed below: -
	 * @param deptName
	 * @param designation
	 * @param name
	 * @param employeeId
	 * @return :- Salary of the employee in double.
	 */
	public double generateSalary(String deptName,String designation, String name, String employeeId,int yearOfExperience){
		
		
		System.out.println("Please enter the Overall Points Of the Candidate which he/she scored in the Interview out of 10 and above 5 because ");
		
		Scanner scan=new Scanner(System.in);
		
		int points=scan.nextInt();
		
		switch(points){
		
		case 5: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(8000.00,name);
				return 8000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(10000.00,name);
				return 10000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(7000.00,name);
				return 7000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(10000.00,name);
				return 10000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(12000.00,name);
				return 12000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(12000.00,name);
				return 12000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(15000.00,name);
				return 15000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(60000.00,name);
				return 60000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
		}
		
		break;
		
		
		case 6: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(10000.00,name);
				return 10000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(12000.00,name);
				return 12000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(22000.00,name);
				return 22000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(32000.00,name);
				return 32000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(10000.00,name);
				return 10000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(12000.00,name);
				return 12000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(15000.00,name);
				return 15000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(22000.00,name);
				return 22000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(14000.00,name);
				return 14000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(18000.00,name);
				return 18000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(22000.00,name);
				return 22000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(50000.00,name);
				return 50000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(65000.00,name);
				return 65000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(22000.00,name);
				return 22000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
		}
		break;
		
		case 7: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(12000.00,name);
				return 12000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(15000.00,name);
				return 15000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(12000.00,name);
				return 12000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(14000.00,name);
				return 14000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(16000.00, name);
				return 16000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(20000.00, name);
				return 20000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(24000.00, name);
				return 24000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(32000.00, name);
				return 32000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(32000.00, name);
				return 32000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(55000.00,name);
				return 55000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(70000.00,name);
				return 70000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(50000.00,name);
				return 50000.00;
			}
		}
		
		break;
		
		case 8: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(15000.00,name);
				return 15000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(20000.00,name);
				return 20000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(15000.00,name);
				return 15000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(22000.00,name);
				return 20000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(24000.00,name);
				return 24000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(60000.00,name);
				return 60000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(75000.00,name);
				return 75000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(55000.00,name);
				return 55000.00;
			}
		}
		
		break;
		
		case 9: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(25000.00,name);
				return 25000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(20000.00,name);
				return 20000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(34000.00,name);
				return 34000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(24000.00,name);
				return 24000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(50000.00,name);
				return 50000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(65000.00,name);
				return 65000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(80000.00,name);
				return 80000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(50000.00,name);
				return 50000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(60000.00,name);
				return 60000.00;
			}
		}
		break;
		
		case 10: if(deptName.equalsIgnoreCase("Technical")|| deptName.equalsIgnoreCase("Technical Department")){
			if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
				
			}
			else if((designation.equalsIgnoreCase("Software Engineer")||designation.equalsIgnoreCase("Trainee"))&&(yearOfExperience>1)){
				salaryBreakUpPlan(30000.00,name);
				return 30000;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(40000.00,name);
				return 40000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Software Engineer"))&&(yearOfExperience>=2)){
				salaryBreakUpPlan(50000.00,name);
				return 50000.00;
			}
			
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience<2)){
				salaryBreakUpPlan(25000.00,name);
				return 25000.00;
			}
			else if((designation.equalsIgnoreCase("Software Developer")|| designation.equalsIgnoreCase("Developer"))&&(yearOfExperience>=2&&yearOfExperience<=5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience<5)){
				salaryBreakUpPlan(30000.00,name);
				return 30000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Software Developer")|| designation.equalsIgnoreCase("Senior Developer"))&&(yearOfExperience>=5)){
				salaryBreakUpPlan(38000.00,name);
				return 38000.00;
			}
			
			}
		
		//Management and Operations Salary distribution.
		
		if(deptName.equalsIgnoreCase("Management")|| deptName.equalsIgnoreCase("Sales")|| deptName.equalsIgnoreCase("Operations")||deptName.equalsIgnoreCase("Sales Department")){
			if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience<=1)){
				salaryBreakUpPlan(28000.00,name);
				return 28000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Executive")||designation.equalsIgnoreCase("Consultant")||designation.equalsIgnoreCase("Technical Consultant")||designation.equalsIgnoreCase("Sales Executive")||designation.equalsIgnoreCase("Operation Executive"))&&(yearOfExperience>1&&yearOfExperience<4)){
				salaryBreakUpPlan(32000.00,name);
				return 32000.00;
				
			}
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
			}
			
			else if((designation.equalsIgnoreCase("Senior Sales Executive")||designation.equalsIgnoreCase("Senior Technical Consultant")||designation.equalsIgnoreCase("Senior Operation Executive"))&&(yearOfExperience>6&&yearOfExperience<8)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Senior Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(55000.00,name);
				return 55000.00;
			}
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience<10)){
				salaryBreakUpPlan(70000.00,name);
				return 70000.00;
			}
			
			else if((designation.equalsIgnoreCase("Manager")||designation.equalsIgnoreCase("Sales Manager")||designation.equalsIgnoreCase("Operations Manager"))&&(yearOfExperience>10&&yearOfExperience<20)){
				salaryBreakUpPlan(100000.00,name);
				return 100000.00;
			}
		}
		
		//Hr department salary distribution
		
		if(deptName.equalsIgnoreCase("Hr Department")|| deptName.equalsIgnoreCase("Hr")){
			if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience<=2)){
				salaryBreakUpPlan(35000.00,name);
				return 35000.00;
				
			}
			
			else if((designation.equalsIgnoreCase("Hr Executive")||designation.equalsIgnoreCase("Executive"))&&(yearOfExperience>2&&yearOfExperience<5)){
				salaryBreakUpPlan(45000.00,name);
				return 45000.00;
				
			}
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience<=5)){
				salaryBreakUpPlan(55000.00,name);
				return 55000.00;
			}
			
			else if((designation.equalsIgnoreCase("Team Lead-Hr")||designation.equalsIgnoreCase("Team Lead")||designation.equalsIgnoreCase("Hr-Team Lead"))&&(yearOfExperience>5&&yearOfExperience<10)){
				salaryBreakUpPlan(65000.00,name);
				return 65000.00;
			}
		}
		break;
		
		default: System.out.println("You have entered wrong input.");
		
		
		break;
		}
		
		return 0;
		
	}
	
	public void salaryBreakUpPlan(double monthlySalary, String name){
		
		double basicSalary= (monthlySalary*30.00)/100.00;
		
		double HRA= (monthlySalary*30.00)/100.00;
		
		double conveyance=(monthlySalary*25.00)/100.00;
		
		double medical=(monthlySalary*10.00)/100.00;
		
		double others=(monthlySalary*5.00)/100.00;
		
		System.out.println("Your Salary Break Up Plan Is Below And it will change Company to Company");
		
		System.out.println("BASIC = "+basicSalary);
		System.out.println("HRA = "+HRA);
		System.out.println("Conveyance = "+conveyance);
		System.out.println("Medical = "+medical);
		System.out.println("Others = "+others);
		System.out.println("Total In hand is = "+monthlySalary);
		
		
		try{
		Document mydocument=new Document(PageSize.A4,50,50, 50, 50);
		
		PdfWriter writer=PdfWriter.getInstance(mydocument, new FileOutputStream("F:\\Project\\"+name+".pdf"));
		
		mydocument.open();
		
		Anchor anchor=new Anchor("Salary Slip of the Employee "+name);
		
		anchor.setName("Salary Slip");
		
		Paragraph first_Para=new Paragraph();
		
		first_Para.setSpacingBefore(50);
		
		first_Para.add(anchor);
		
		mydocument.add(first_Para);
		
		
		com.itextpdf.text.List list=new com.itextpdf.text.List(true,false,10);
		
		list.add(new ListItem("BASIC = "+basicSalary));
		list.add(new ListItem("HRA = "+HRA));
		list.add(new ListItem("Conveyance = "+conveyance));
		list.add(new ListItem("Medical = "+medical));
		list.add(new ListItem("Others = "+others));
		list.add(new ListItem("Total In hand is = "+monthlySalary));
		
		mydocument.add(list);
		
		mydocument.add(new Paragraph("NOTE: We are Not Deducting any tax only PF and normal tax we are Deducting . The deduction may vary Company To Company",FontFactory.getFont(FontFactory.COURIER,14,Font.BOLD,new CMYKColor(0, 255, 0, 0))));
		
		Image acadgild_Logo=Image.getInstance("C:\\Users\\sumitranchi003\\Desktop\\AcadGild Logo.png");
		
		acadgild_Logo.setAbsolutePosition(180f, 10f);
		
		mydocument.add(acadgild_Logo);
		
		mydocument.close();
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//PdfWriter.get
		
		
		
	}

	@Override
	public String generateEmloyeeId(String name) {
		long value=System.currentTimeMillis();
		String valueId=Long.toString(value);
		return deptId+"_"+valueId;
	}
}
