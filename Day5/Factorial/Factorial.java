package com.chargebee.adithya.training.Factorial;
import java.util.*;



class Factorial implements Iterable<Integer>{
	private int l;
	private int u;
	Factorial(int l,int u){
		this.l = l;
		this.u = u;
	}

	class FactorialIterator implements Iterator<Integer>{
  		public FactorialIterator(){

  		}
		public boolean hasNext(){
			return ((Factorial.this.u-(Factorial.this.l)+1)>0);
		}
		
		private int factorial(Integer number){
			if(number.equals(0)){
				return 1;
			}else{
				return number * factorial(number-1);
			}
		}
		
		public Integer next(){
			return Factorial.this.l++;
		}
		public String toString(){
			String str = String.valueOf(factorial(Factorial.this.l-1));
			return str;
		}
	}

	public Iterator<Integer> iterator(){
		return(new FactorialIterator());
	}

	public static void main(String args[]){
		int lowerLimit,upperLimit;
		String str="";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter lower limit: ");
		lowerLimit = scanner.nextInt();
		System.out.print("Enter Upper limit:");
		upperLimit = scanner.nextInt();
		Factorial fact = new Factorial(lowerLimit,upperLimit);
		Iterator itr=fact.iterator();
		System.out.print();
		while(itr.hasNext()){
			itr.next();
			if(itr.hasNext()){
				str+=itr.toString()+",";
			}
			else{
				str+=itr.toString()+".\n";
			}
		}
		System.out.print(str);


	}
}