package com.chargebee.adithya.training.PhoneDirectory;
public class Address{
		private String flat_no;
		private String road;
		private String city;
		public Address(String flat_no,String road,String city){
			this.flat_no=flat_no;
			this.road=road;
			this.city=city;
		}
		public String getAddress(){
		return (flat_no+","+road+","+city+".");
		}
		public String getCity(){
		return city;
		}
}