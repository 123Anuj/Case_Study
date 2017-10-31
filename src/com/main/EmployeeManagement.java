package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Enumeration;
import java.util.GregorianCalendar;

import java.util.Properties;
import java.util.Scanner;

import com.acadgild.Employee;


public class EmployeeManagement {

	Employee employeeLeave=new Employee();
	/**
	 * public void store(Employee employee): -
	 * 		This is a public method and used to store the details of the Employee in key value pair as: -
	 * 
	 * 			key=Is a combination of employee name and employee id
	 * 			value:- Are rest of the details like address, salary,experience,department name, designation.etc.
	 *  In this method we are using Buffered writer to store the details so that the value will not be override.
	 *  We are also using Property file so that we are able to store the details in Key value pair.
	 * @param employee
	 */
	public void store(Employee employee){
		
	
		
		FileWriter out=null;
		BufferedWriter bufferedWriter=null;
		Properties prop=new Properties();
         System.out.println();

		try{
		File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
		
		out=new FileWriter(log,true);
		 bufferedWriter=new BufferedWriter(out);
		
		 
		prop.setProperty(employee.getEmpId()+employee.getName(),"Adress = "+employee.getAdress()+","+"\n"+"Department = "+employee.getDeptName()+","+"\n"+"Designation = "+employee.getDesignation()+","+"\n"+"Year Of Experience = "+employee.getYearOfExperience()+","+"\n"+"Salary = "+employee.getSalary()+","+"\n"+"Date Of joining = "+employee.getDateOfJoining()+","+"\n"+"Leave Balance = "+employee.getLeaveBalance()+","+"\n"+"Last Leave Applied On = "+employee.getLateTimeLeaveAppliedOn());
		
		prop.store(out, "Storage");
		
		}
		catch(IOException io){
			io.getMessage();
		}
		finally{
			try{
				if(bufferedWriter !=null){
					bufferedWriter.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * public void readData(String key): - This method is used to read the details of the Employee. As it is taking key of the Employee
	 * And in key the employee has to pass its name and its Employee Id.
	 * @param key
	 * @throws ParseException 
	 */
	public void readData(String key) throws ParseException{
		String fileName="F:\\Project\\New folder\\EmployeeManagement.txt";
		
		FileWriter out=null;
		BufferedWriter bufferedWriter=null;
		
		String changedValue;
		
		Properties prop=new Properties();
		
		String value=null;
		
		BufferedReader buffer=null;
		FileReader fileReader=null;
		
		try{
			fileReader=new FileReader(fileName);
			buffer=new BufferedReader(fileReader);
			
			
			//buffer=new BufferedReader(new FileReader(fileName));
			
			
			
			
			prop.load(buffer);
			
			System.out.println("Property loades successfully");
			Enumeration<?> enumeration=prop.propertyNames();
			while(enumeration.hasMoreElements()){
				
				String keys=(String)enumeration.nextElement();
				System.out.println("All keys are := "+keys);	
			}
			 value=prop.getProperty(key);
			System.out.println("Key :- "+key+" value is - "+value );
			
		}
		catch(IOException io){
			io.getMessage();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			try{
			if(fileReader!=null){
				fileReader.close();
				
				System.out.println("File reader closed successfully");
			}
			if(buffer!=null){
				buffer.close();
				System.out.println("Buffered reader closed successfully");
			}
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	
			Scanner scan=new Scanner(System.in);
			
			
			// getting the values from the stored details for further calculation.
			
			String[] newValues=value.split(",");
			String[] dateOfJoining=null;
			String[] newString=null;
			String[] leaveBalance=null;
			
			String[] leaveApplied=null;
			
			for(int i=0;i<newValues.length;i++){
				
				
				if(newValues[i].contains("Salary")){
					newString=newValues[i].split("=");
				}
				
				if(newValues[i].contains("Date Of joining")){
					dateOfJoining=newValues[i].split("=");
				}
				 
				if(newValues[i].contains("Leave Balance")){
					leaveBalance=newValues[i].split("=");
				}
				
				
				if(newValues[i].contains("Last Leave Applied On")){
					
					 leaveApplied=newValues[i].split("=");
					
				}
			}// for loop closed
			
			// printing the fetched values to check whether they are correct or not.
			
			System.out.println("salary fetched is "+newString[1]);
			
			System.out.println("date of joining fetched is "+dateOfJoining[1]);
			
			System.out.println("leave balance fetched is "+leaveBalance[1]);
			
			System.out.println("last leave applied on "+leaveApplied[1]);
			
			System.out.println("To apply for leaves press 1 otherwise press any key to exit");
			
			int choice =scan.nextInt();
			
			switch(choice){
			
			case 1:  System.out.println("Please enter how many leaves you want to apply");
						int leave=scan.nextInt();
						
						//  1 Loop
						
						if(leave>0){
							
							System.out.println("Goes into leave>0");
							
							// we are calculating the current date here because when the employee goes into this method then that date should be considered.
							DateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Calendar cal=Calendar.getInstance();
							
							df=DateFormat.getDateInstance(DateFormat.SHORT);
							
							String str=df.format(cal.getTime());
							
							String[] currentDate=str.split("/");
							
							int month=Integer.parseInt(currentDate[0]);
							
							int day=Integer.parseInt(currentDate[1]);
							
							int year=Integer.parseInt(currentDate[2]);
							
							Calendar mycal=new GregorianCalendar(year,month,day);
							
							int days_In_Month=mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
							
							double per_day_salary;
							
							java.util.Date appliedDate=null;
							
							
							Calendar startClaender=null;
							
							Calendar endCalender=null;
							
							int diffYear=0;
							
							int diffMonths=0;
							
							int leaveBbalance=Integer.parseInt(leaveBalance[1].trim());
							
							double total_Salary=0.0;
							
							double calculated_salary=0.0;
							
							// first loop inside if(leave>0)
							
							// 1.1 Loop
							
								if(leaveApplied[1].equalsIgnoreCase(" null")){
									
				
									
									
										// converting the string value of date Into Date object.
										
			
								         System.out.println("System current date is "+str);
								         System.out.println("Joining date of employee is "+dateOfJoining[1]);
								         
								         appliedDate=new SimpleDateFormat("MM/dd/yyyy").parse(str);
								        
								         System.out.println("str parsed successfully");
								         
								         java.util.Date joiningDate=new SimpleDateFormat("MM/dd/yyyy").parse(dateOfJoining[1]);
								         System.out.println("date of joining parsed successfully");
								         
								         //After parsing it we are calculating the difference between the months from the joining date to the date of leave applied.
								         
									 startClaender=Calendar.getInstance();
									
									startClaender.setTime(joiningDate);
									
								     endCalender=Calendar.getInstance();
									
									endCalender.setTime(appliedDate);
									
									diffYear=endCalender.get(Calendar.YEAR)-startClaender.get(Calendar.YEAR);
									
									diffMonths=diffYear*12+endCalender.get(Calendar.MONTH)-startClaender.get(Calendar.MONTH);
									
									System.out.println("the difference of month is "+diffMonths);
									
									// 1.1.1 Loop
									
									if(diffMonths>0){
										
										diffMonths=diffMonths*2;
										
										
									// if diffMonth>0 closed
									
										// 1.1.1.1 Loop 
										if(leave<diffMonths){
											
											System.out.println("Inside 1.1.1.1 Loop");
											diffMonths=diffMonths-leave;
											String changed=value.replaceAll("Leave balance = "+leaveBalance[1], "Leave Balance = "+String.valueOf(diffMonths));
											changedValue=changed.replaceAll("null", str);
											
											
											System.out.println("After first replacement of null "+changedValue);

									         try{
									        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
											
									        	 out=new FileWriter(log,true);
									        	 bufferedWriter=new BufferedWriter(out);
											
											 System.out.println("The value of lastapplied before storing is "+changedValue);
									        	 prop.setProperty(key,changedValue);
											
									        	 prop.store(out, "Storage");
									        	 
									        	 System.out.println("File saved successfully");
											
									         } // try closed
									         catch(IOException io){
									        	 io.getMessage();
									        	 System.out.println("exception occurred while saving the file");
									         }// catch closed
									         
									         finally{
									        	 	try{if(bufferedWriter !=null){
							        	 				//bufferedWriter.flush();
							        	 				bufferedWriter.close();
							        	 				System.out.println("buffer writes closed.");
							        	 			}
							        	 			if(out!=null){
								        	 			//out.flush();
							        	 				System.out.println("File output stream is also closed.");
								        	 			out.close();
								        	 		}
									        	 	}	catch(Exception e){
									        	 			e.printStackTrace();
									        	 				}
									         		}/// finally closed
											
												}// 1.1.1.1 closed
										
										
										// 1.1.1.2 open
										
										 if(leave>diffMonths){
											
											 System.out.println("Leave>diffmonths as leave value is "+leave+" and diffMonths is "+diffMonths);
											 
											 total_Salary=Double.parseDouble(newString[1]);
											
											per_day_salary=total_Salary/days_In_Month;
											
										// now according to the leave we need to calculate the salary
											
											 calculated_salary=total_Salary-(per_day_salary*(leave-1));
											
											System.out.println("Now according to your leave your this month salary will be "+calculated_salary);
										
											String changed =value.replaceAll("Leave balance = "+leaveBalance[1], "Leave Balance = "+String.valueOf(diffMonths));
											
											changedValue=changed.replaceAll("null", str);
											
											System.out.println("After first replacement of null "+changedValue);

									         try{
									        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
											
									        	 out=new FileWriter(log,true);
									        	 bufferedWriter=new BufferedWriter(out);
											
											 System.out.println("The value of lastapplied before storing is "+changedValue);
									        	 prop.setProperty(key,changedValue);
											
									        	 prop.store(out, "Storage");
									        	 
									        	 System.out.println("File saved successfully");
											
									         } // try closed
									         catch(IOException io){
									        	 io.getMessage();
									        	 System.out.println("exception occurred while saving the file");
									         }// catch closed
									         
									         finally{
									        	 	try{if(bufferedWriter !=null){
							        	 				//bufferedWriter.flush();
							        	 				bufferedWriter.close();
							        	 				System.out.println("buffer writes closed.");
							        	 			}
							        	 			if(out!=null){
								        	 			//out.flush();
							        	 				System.out.println("File output stream is also closed.");
								        	 			out.close();
								        	 		}
									        	 	}	catch(Exception e){
									        	 			e.printStackTrace();
									        	 				}
									         		}// finally closed
											
										}// 1.1.1.2 closed
										 
									}// 1.1.1 closed  diffMonths>0
									
									// 1.1.2 opens
									
									else if(diffMonths<=0){
										
										System.out.println("Goes inside diffMonths<=0");
										
										
										// 1.1.2.1 opens
										
										if(leave<leaveBbalance){
											
											System.out.println("Goes into leave<leaveBbalance");
											leaveBbalance=leaveBbalance-leave;
											
											System.out.println("After deduction the leave balance is "+leaveBbalance);
											String changed=value.replaceAll("Leave Balance = "+leaveBalance[1].trim(), "Leave Balance = "+String.valueOf(leaveBbalance));
											
											System.out.println("the changed string is "+changed);
											changedValue=changed.replaceAll("null", str);
											
											System.out.println("After first replacement of null "+changedValue);

									         try{
									        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
											
									        	 out=new FileWriter(log,true);
									        	 bufferedWriter=new BufferedWriter(out);
											
											 System.out.println("The value of lastapplied before storing is "+changedValue);
									        	 prop.setProperty(key,changedValue);
											
									        	 prop.store(out, "Storage");
									        	 
									        	 System.out.println("File saved successfully");
											
									         } // try closed
									         catch(IOException io){
									        	 io.getMessage();
									        	 System.out.println("exception occurred while saving the file");
									         }// catch closed
									         
									         finally{
									        	 	try{if(bufferedWriter !=null){
							        	 				//bufferedWriter.flush();
							        	 				bufferedWriter.close();
							        	 				System.out.println("buffer writes closed.");
							        	 			}
							        	 			if(out!=null){
								        	 			//out.flush();
							        	 				System.out.println("File output stream is also closed.");
								        	 			out.close();
								        	 		}
									        	 	}	catch(Exception e){
									        	 			e.printStackTrace();
									        	 				}
									         		}// finally closed
											
										}// 1.1.2.1 closed
										
										//1.1.2.2 opens
										
										else if(leave>leaveBbalance){
											
											System.out.println("goes inside leave>leaveBbalance");
											 total_Salary=Double.parseDouble(newString[1]);
											
											per_day_salary=total_Salary/days_In_Month;
											
										// now according to the leave we need to calculate the salary
											
											 calculated_salary=total_Salary-(per_day_salary*(leave-1));
											
											System.out.println("Now according to your leave your this month salary will be "+calculated_salary);
											
											changedValue=value.replaceAll("null", str);
											
											System.out.println("After first replacement of null "+changedValue);

									         try{
									        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
											
									        	 out=new FileWriter(log,true);
									        	 bufferedWriter=new BufferedWriter(out);
											
											 System.out.println("The value of lastapplied before storing is "+changedValue);
									        	 prop.setProperty(key,changedValue);
											
									        	 prop.store(out, "Storage");
									        	 
									        	 System.out.println("File saved successfully");
											
									         } // try closed
									         catch(IOException io){
									        	 io.getMessage();
									        	 System.out.println("exception occurred while saving the file");
									         }// catch closed
									         
									         finally{
									        	 	try{if(bufferedWriter !=null){
							        	 				//bufferedWriter.flush();
							        	 				bufferedWriter.close();
							        	 				System.out.println("buffer writes closed.");
							        	 			}
							        	 			if(out!=null){
								        	 			//out.flush();
							        	 				System.out.println("File output stream is also closed.");
								        	 			out.close();
								        	 		}
									        	 	}	catch(Exception e){
									        	 			e.printStackTrace();
									        	 				}
									         		}// finally closed
											
										}// 1.1.2.2 closed
										
										
									}// 1.1.2 closed  else if(diffMonths<=0) 
									
										
									}// 1.1 closed (if last applied leave == null) 
								
								else {
									
									// in this loop we will work on if last applied leave is not equal to null.
									
									System.out.println("Your current leave applied date is "+str);
									
									System.out.println("Previous applied date id "+leaveApplied[1]);
									
									appliedDate=new SimpleDateFormat("MM/dd/yyyy").parse(str);
							        
							         System.out.println("str parsed successfully");
							         
							         java.util.Date previous_Applied_date= new SimpleDateFormat("MM/dd/yyyy").parse(leaveApplied[1].trim());
							         
							         startClaender=Calendar.getInstance();
										
										startClaender.setTime(previous_Applied_date);
										
									     endCalender=Calendar.getInstance();
										
										endCalender.setTime(appliedDate);
										
										diffYear=endCalender.get(Calendar.YEAR)-startClaender.get(Calendar.YEAR);
										
										diffMonths=diffYear*12+endCalender.get(Calendar.MONTH)-startClaender.get(Calendar.MONTH);
										
										System.out.println("the difference of month is "+diffMonths);
										
										if(diffMonths>0){
											
											leaveBbalance=leaveBbalance*diffMonths;
											
											if(leave<leaveBbalance){
												
												System.out.println("Goes into leave<leaveBbalance");
												leaveBbalance=leaveBbalance-leave;
												
												System.out.println("After deduction the leave balance is "+leaveBbalance);
												String changed=value.replaceAll("Leave Balance = "+leaveBalance[1].trim(), "Leave Balance = "+String.valueOf(leaveBbalance));
												
												System.out.println("the changed string is "+changed);
												changedValue=changed.replaceAll(leaveApplied[1], str);
												
												System.out.println("After first replacement of null "+changedValue);

										         try{
										        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
												
										        	 out=new FileWriter(log,true);
										        	 bufferedWriter=new BufferedWriter(out);
												
												 System.out.println("The value of lastapplied before storing is "+changedValue);
										        	 prop.setProperty(key,changedValue);
												
										        	 prop.store(out, "Storage");
										        	 
										        	 System.out.println("File saved successfully");
												
										         } // try closed
										         catch(IOException io){
										        	 io.getMessage();
										        	 System.out.println("exception occurred while saving the file");
										         }// catch closed
										         
										         finally{
										        	 	try{if(bufferedWriter !=null){
								        	 				//bufferedWriter.flush();
								        	 				bufferedWriter.close();
								        	 				System.out.println("buffer writes closed.");
								        	 			}
								        	 			if(out!=null){
									        	 			//out.flush();
								        	 				System.out.println("File output stream is also closed.");
									        	 			out.close();
									        	 		}
										        	 	}	catch(Exception e){
										        	 			e.printStackTrace();
										        	 				}
										         		}// finally closed
												
											}
											
											else if(leave>leaveBbalance){
												
												System.out.println("goes inside leave>leaveBbalance");
												 total_Salary=Double.parseDouble(newString[1]);
												
												per_day_salary=total_Salary/days_In_Month;
												
											// now according to the leave we need to calculate the salary
												
												 calculated_salary=total_Salary-(per_day_salary*(leave-1));
												
												System.out.println("Now according to your leave your this month salary will be "+calculated_salary);
												
												changedValue=value.replaceAll(leaveApplied[1], str);
												
												System.out.println("After first replacement of null "+changedValue);

										         try{
										        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
												
										        	 out=new FileWriter(log,true);
										        	 bufferedWriter=new BufferedWriter(out);
												
												 System.out.println("The value of lastapplied before storing is "+changedValue);
										        	 prop.setProperty(key,changedValue);
												
										        	 prop.store(out, "Storage");
										        	 
										        	 System.out.println("File saved successfully");
												
										         } // try closed
										         catch(IOException io){
										        	 io.getMessage();
										        	 System.out.println("exception occurred while saving the file");
										         }// catch closed
										         
										         finally{
										        	 	try{if(bufferedWriter !=null){
								        	 				//bufferedWriter.flush();
								        	 				bufferedWriter.close();
								        	 				System.out.println("buffer writes closed.");
								        	 			}
								        	 			if(out!=null){
									        	 			//out.flush();
								        	 				System.out.println("File output stream is also closed.");
									        	 			out.close();
									        	 		}
										        	 	}	catch(Exception e){
										        	 			e.printStackTrace();
										        	 				}
										         		}// finally closed
												
											}
											
						
										}
										
										else if(diffMonths<=0){
											
											if(leave<leaveBbalance){
												System.out.println("Goes into leave<leaveBbalance");
												leaveBbalance=leaveBbalance-leave;
												
												System.out.println("After deduction the leave balance is "+leaveBbalance);
												String changed=value.replaceAll("Leave Balance = "+leaveBalance[1].trim(), "Leave Balance = "+String.valueOf(leaveBbalance));
												
												System.out.println("the changed string is "+changed);
												changedValue=changed.replaceAll(leaveApplied[1], str);
												
												System.out.println("After first replacement of null "+changedValue);

										         try{
										        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
												
										        	 out=new FileWriter(log,true);
										        	 bufferedWriter=new BufferedWriter(out);
												
												 System.out.println("The value of lastapplied before storing is "+changedValue);
										        	 prop.setProperty(key,changedValue);
												
										        	 prop.store(out, "Storage");
										        	 
										        	 System.out.println("File saved successfully");
												
										         } // try closed
										         catch(IOException io){
										        	 io.getMessage();
										        	 System.out.println("exception occurred while saving the file");
										         }// catch closed
										         
										         finally{
										        	 	try{if(bufferedWriter !=null){
								        	 				//bufferedWriter.flush();
								        	 				bufferedWriter.close();
								        	 				System.out.println("buffer writes closed.");
								        	 			}
								        	 			if(out!=null){
									        	 			//out.flush();
								        	 				System.out.println("File output stream is also closed.");
									        	 			out.close();
									        	 		}
										        	 	}	catch(Exception e){
										        	 			e.printStackTrace();
										        	 				}
										         		}// finally closed
											}
											
											else if(leave>leaveBbalance){
												
												System.out.println("goes inside leave>leaveBbalance");
												 total_Salary=Double.parseDouble(newString[1]);
												
												per_day_salary=total_Salary/days_In_Month;
												
											// now according to the leave we need to calculate the salary
												
												 calculated_salary=total_Salary-(per_day_salary*(leave-1));
												
												System.out.println("Now according to your leave your this month salary will be "+calculated_salary);
												
												changedValue=value.replaceAll(leaveApplied[1], str);
												
												System.out.println("After first replacement of null "+changedValue);

										         try{
										        	 File log=new File("F:\\Project\\New folder\\EmployeeManagement.txt");
												
										        	 out=new FileWriter(log,true);
										        	 bufferedWriter=new BufferedWriter(out);
												
												 System.out.println("The value of lastapplied before storing is "+changedValue);
										        	 prop.setProperty(key,changedValue);
												
										        	 prop.store(out, "Storage");
										        	 
										        	 System.out.println("File saved successfully");
												
										         } // try closed
										         catch(IOException io){
										        	 io.getMessage();
										        	 System.out.println("exception occurred while saving the file");
										         }// catch closed
										         
										         finally{
										        	 	try{if(bufferedWriter !=null){
								        	 				//bufferedWriter.flush();
								        	 				bufferedWriter.close();
								        	 				System.out.println("buffer writes closed.");
								        	 			}
								        	 			if(out!=null){
									        	 			//out.flush();
								        	 				System.out.println("File output stream is also closed.");
									        	 			out.close();
									        	 		}
										        	 	}	catch(Exception e){
										        	 			e.printStackTrace();
										        	 				}
										         		}// finally closed
											}
										}
										
									
									
									
								}
									
								}// if(leave>0) closed
						
						else{
							System.out.println("Wrong input of leave");
						}
								
								
							
						break;   // case 1: break;
						
					default: break;   //default break;
						
							}// switch closed
							
							
						}// readData closed
						
	
	// Main method start from here
	
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		EmployeeManagement emp=new EmployeeManagement();
		Employee employee=new Employee();
		Scanner scan=new Scanner(System.in);
		
		while(true){
			System.out.println("Enter 1 for newly joined employee and 2 for old Employee and enter any key to exit");
			int choice=scan.nextInt();
		switch(choice){
	
		case 1: 
				scan.nextLine();
				System.out.println("Enter your Name");
				employee.setName(scan.nextLine());
				
				System.out.println("Enter your Department");
				employee.setDeptName(scan.nextLine());
				
				System.out.println("Enter your Designation");
				employee.setDesignation(scan.nextLine());
				
				System.out.println("Enter your Adress");
				employee.setAdress(scan.nextLine());
				
				System.out.println("Enter your year of experience");
				employee.setYearOfExperience(scan.nextInt());
				
				System.out.println("Enter 3 to see your employee id and salary");
				int seedetails=scan.nextInt();
				
				
				switch(seedetails){
				case 3: String id=employee.seeEmployeeId(employee.getDeptName(), employee.getName());
						employee.setEmpId(id);
						
						
						System.out.println("Your employee id is "+id+" kindly note it down for future reference");
						
						double sal=employee.seeEmployeeSalary(employee.getDeptName(),employee.getName(), employee.getEmpId(),employee.getDesignation(),employee.getYearOfExperience());
						
						employee.setSalary(sal);
						System.out.println("Your montly salary is "+sal);
						
						
						// We are using Calendar and date format class to store the current date in the system as date of joining. 
						
						
						// current system date can be reduce
						
						DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal=Calendar.getInstance();
						
						df=DateFormat.getDateInstance(DateFormat.SHORT);  
						
						String str=df.format(cal.getTime());
						
						employee.setDateOfJoining(str);
						
						System.out.println("Your Initial leave will be 2");
						
						employee.setLeaveBalance(2);
						
						employee.setLateTimeLeaveAppliedOn(null);
						
						 emp.store(employee);
						 
						break;
					default: System.out.println("Wrong Input only 3 is permitted");
					break;
				}
				break;
				
		case 2: scan.nextLine();
			System.out.println("To see Your stored details  enter your employee id");
			
				  String empId=scan.nextLine();
				  
				  
				  System.out.println("Enter your Name");
				  
				  String name=scan.nextLine();
				  String key=empId+name;
				  
				  emp.readData(key);
				  
				 
				break;
		
				default: System.exit(0);
				
		}//outer switch
		
	}//while
		
	}

}


