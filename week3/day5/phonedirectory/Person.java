

package com.chargebee.adithya.training.jdbc;

import java.util.ArrayList;


public class Person
{
	private String name;
	private String address;
	private ArrayList<Phone> phone;
	Person()
	{
		phone=new ArrayList<Phone>();
	}
	Person(String name,String address,Phone phone)
	{
		this.name=name;
		this.address=address;
		this.phone=new ArrayList<Phone>();
		this.phone.add(phone);
	}

    public void addPhone(Phone phone)
    {
    this.phone.add(phone);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Phone> getPhone() {
        return phone;
    }

    public void setPhone(ArrayList<Phone> phone) {
        this.phone = phone;
    }
        
};
