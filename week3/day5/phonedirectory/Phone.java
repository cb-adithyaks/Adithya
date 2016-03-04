
package com.chargebee.adithya.training.jdbc;


public class Phone
{
	private String tag;
	private String number;
        Phone()
        {}
	Phone(String tag,String number)
	{
		this.tag=tag;
		this.number=number;
	}
	public void setTag(String tag)
	{
		this.tag=tag;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getTag()
	{
		return this.tag;
	}
	public String getNumber()
	{
		return this.number;
	}
};

