package com.chargebee.adithya.training.ServiceStation;

public class Invoice{
	private Person customer;
	private Vehicle vehicle;
	private int amount_total;
	private Person employee_assigned;
	public Invoice(Person cust,Vehicle v,int a,Person emp){
		customer=cust;
		vehicle=v;
		amount_total=a;
		employee_assigned=emp;
		if(customer.getEmp_id()!=0){
			amount_total-=0.1*amount_total;
		}
	}
	public String printInvoice(){
		String ret="Owner name : "+customer.getName()+"\t\tVehicle_type : "+vehicle.getService()+","+vehicle.getBrand()+"\nVehicle color : "+vehicle.getColor()+"\t\tService Type : "+vehicle.getServiceType()+"\nAmount : "+amount_total+"\t\t\tEmployee assigned : "+employee_assigned.getName();
		return ret;
	}
}