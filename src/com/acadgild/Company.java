package com.acadgild;

/**
 * The<code> Company class</code> contains final data. It cannot be instantiated.
 * <p>This is an abstract class which contain the static and fields which will not change randomly. You can change 
 * the details or add some other functionalities according to your Company.</p>
 * @author Anuj Gautam
 *
 */
public abstract class Company {

	public static final String CEO="Mr.Vikal Jain";
	public static final String CFO="Mr.Vinod Dham";
	public static final String CTO="Mr.Rahul Jain";
	 static final int numberOfDepartent=4;
	static final int noOfEmployees=100;
	
 /**
 * void doWork()
 * As this is an abstract method defined in the parent class and who so ever override this method can implement
 * in its own way.
 * @param It is not taking any parameters
 * @return void
 */
protected abstract void doWork(); }
