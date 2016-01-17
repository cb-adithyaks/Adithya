package com.chargebee.adithya.training.servicestation;

public class ServiceStation{
	private String name;
	private String address;
	private String contact;
	public String getLoc(){
		name="****Speed serve vehicle service centre****\n";
		address="No:40,3rd main road,madipakkam,chennai-43\n";
		contact="044-43562374, +91-9345678901";
		return(name+address+contact+".\n");
	}
	public static int calculateServiceCharge(String service,String service_type){
		int service_charge=0;
		if(service_type.equals("Normal service")){
			if(service.equals("Car")){
				service_charge=5000;
			}
			else if(service.equals("Bike")){
				service_charge=3000;
			}
			else{
				service_charge=10000;
			}
		}
		else if(service_type.equals("Engine breakdown")){
			if(service.equals("Car")){
				service_charge=10000;
			}
			else if(service.equals("Bike")){
				service_charge=5000;
			}
			else{
				service_charge=20000;
			}
		}
		else{
			if(service.equals("Car")){
				service_charge=15000;
			}
			else if(service.equals("Bike")){
				service_charge=10000;
			}
			else{
				service_charge=30000;
			}
		}
		return service_charge;
	}
	public static void printServiceCharge(String veh_type){
		System.out.println(veh_type+"\t\t\t Normal_service\t\t"+calculateServiceCharge(veh_type,"Normal service"));
		System.out.println(veh_type+"\t\t\t Engine breakdown\t"+calculateServiceCharge(veh_type,"Engine breakdown"));
		System.out.println(veh_type+"\t\t\t Any other\t\t"+calculateServiceCharge(veh_type,"Any other"));
	}
	public static void main(String ar[]){
		System.out.println(new ServiceStation().getLoc());
		System.out.println("Service charges for vehicles are as follows : \n\n");
		System.out.println("Vehicle_type\t\tService_type\t\tService_cost");
		printServiceCharge("Car");
		printServiceCharge("Bike");
		printServiceCharge("Bus");
		System.out.println("\n************Invoice for Normal Customer and employee************\n");
		Vehicle vehicle=new Vehicle("Ford","White","Normal Service","Car");
		vehicle.setServiceCharge(calculateServiceCharge("Car","Normal Service"));
		Person employee=new Person("Vicky",23,"9344123456",112);
		Person customer=new Person("Adithya",21,"8939705452");
		Invoice invoice=new Invoice(customer,vehicle,vehicle.getServiceCharge(),employee);
		System.out.println(invoice.printInvoice());
		
		System.out.println("\n\n******Invoice for Customer(Employee) and employee-->Special dicount=10%******\n");
		vehicle=new Vehicle("Apache","White","Full Service","Bike");
		vehicle.setServiceCharge(calculateServiceCharge("Bike","Full Service"));
		employee=new Person("Ashwin",23,"9344123456",123);
		customer=new Person("Ajay",21,"9087762173",134);
		invoice=new Invoice(customer,vehicle,vehicle.getServiceCharge(),employee);
		System.out.println(invoice.printInvoice());
	}
}