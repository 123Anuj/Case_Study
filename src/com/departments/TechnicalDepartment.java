package com.departments;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TechnicalDepartment extends Department implements Serializable{
 
 
 // instance variables to be serialized
 
	String deptId="Tech_102";
	 int noOfEmployees=0;
	 int times=0;
	 int a=0;
	 String temp=null;
	 
	  public TechnicalDepartment(int a,int b, String s,int value) {
		// TODO Auto-generated constructor stub
		  noOfEmployees=a;
		  times=b;
		  temp=s;
		  this.a=value;
	}
	  
	 public TechnicalDepartment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public	void doWork() {
		// TODO Auto-generated method stub
		System.out.println("The technical department works on the Technical part");
	}

	/*public String generateEmpId(String name){
		// TODO Auto-generated method stub
		long value=System.currentTimeMillis();
		String valueId=Long.toString(value);
		return deptId+"_"+valueId;
	}*/


	@Override
	public	String generateEmloyeeId(String name) {
		// TODO Auto-generated method stub
		
		long value=System.currentTimeMillis();
		String valueId=Long.toString(value);
		return deptId+"_"+valueId;
	}
	
	}
	
	


