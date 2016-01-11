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
  		private int ci;

  		public FactorialIterator(){
  			ci = Factorial.this.l;
  		}

		
		public boolean hasNext(){
			return (ci <= Factorial.this.u);
		}

		
		public Integer next(){
			if(this.hasNext()){
				int current = ci;
				ci++ ;
				return current;
			}
			return -1;
		}
	}

	public Iterator<Integer> iterator(){
		return(new FactorialIterator());
	}

	private int factorial(Integer number){
		if(number.equals(0)){
			return 1;
		}else{
			return number * factorial(number-1);
		}
	}

	
	public String toString(){
		String str = "";
		Iterator<Integer> it = iterator();

		while(it.hasNext()){
			int value = it.next();
			if(it.hasNext()&&value!=-1){
				str = str + factorial(value) + ", ";	
			}else{
				str =str+ factorial(value) +"\n";		
			}	
		}
		
		return str;
	}
}

public class FactorialPrint{

	public static void main(String args[]){
		int lowerLimit,upperLimit;
		String str;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter lower limit:");
		lowerLimit = scanner.nextInt();
		System.out.print("Enter Upper limit:");
		upperLimit = scanner.nextInt();

		Factorial fact = new Factorial(lowerLimit,upperLimit);

		str = fact.toString();
		System.out.print(str);


	}
}