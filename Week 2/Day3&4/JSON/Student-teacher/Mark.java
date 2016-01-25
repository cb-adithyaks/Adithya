package com.chargebee.adithya.training.json;

public class Mark{
	private int Mark;
	private String Subject;
	public Mark(int Mark,String Subject){
		this.Mark=Mark;
		this.Subject=Subject;
	}
	public String getSubject(){	
		return Subject;
	}
	public int getMark(){
		return Mark;
	}
}
