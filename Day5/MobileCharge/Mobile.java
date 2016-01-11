/** This application is used for understanding anonymous inner class
*/
package com.chargebee.adithya.w1d4;
import java.util.Random;
public class Mobile{
	private String name;
	private int remainingCharge;
	public void name(){
		name="Nokia";
	}
	public void remainingCharge(){
		remainingCharge=(new Random()).nextInt(100)+1;
	}
	public void setName(String n){
		name=n;
	}
	public void setRemainingCharge(int rc){
		remainingCharge=rc;
	}
	public int getRemainingCharge(){
		return remainingCharge;
	}
	public String getName(){
		return name;
	}
}
