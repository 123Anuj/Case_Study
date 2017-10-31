package com.departments;

public class ManagementDepartment extends Department{

	static String deptId="MGMT_101";
	int noOfEmployees;
	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		System.out.println("The management department will work on the Management process");
	}
	
	protected boolean approveLeaves(String empId,String typeOfLeave,int noOfdays){
		
		
		return true;
	}
	protected void giveIncentives(String empId){
		
	}

	@Override
	public String generateEmloyeeId(String name) {
		// TODO Auto-generated method stub
		long value=System.currentTimeMillis();
		String valueId=Long.toString(value);
		return deptId+"_"+valueId;
	}

}
