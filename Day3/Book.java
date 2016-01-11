/** Book stall application
*/
package com.chargebee.training.day3;
import java.util.*;

class Book{
	private String name;
	private Author authors[];
	private Double price;
	private int qtyInStock;
	
	public Book(String name, Author authors[],Double price,int qtyInStock){
	    this.name=name;
	    this.authors=authors;
	    this.price=price;
	    this.qtyInStock=qtyInStock;
	}
	public Book(String name, Author author, Double price, int qtyInStock){
	    this.name=name;
	    authors[0]=author;
	    this.price=price;
	    this.qtyInStock=qtyInStock;
	}
	public String getName(){
	    return name;
	}
	public Author[] getAuthors(){
	    return authors;
	}
	public double getPrice(){
	    return price;
	}
	public void setPrice(double price){
	    this.price=price;
	}
	public int getQtyInStock(){
	    return qtyInStock;
	}
	public String toDisplay(){
	    String ret=name+" by ";
	    try{
	        for(int i=0;i<authors.length;i++){
	            ret+=authors[i].toDisplay()+",";				
	        }
	    }catch(Exception e){}
	    ret+="\nPrice: $"+price+"\nNo of books available: "+qtyInStock;
	    return ret;
	}
	public void printAuthors(){
	    for(int i=0;i<authors.length;i++){
	        try{
	            System.out.println((i+1)+". "+authors[i].toDisplay());
	        }catch(Exception e){}
	    }
	}
	public void addAuthor(Author author){
	    int i=0;
	    try{
	        for(i=0;!(authors[i].name.equals(""));i++){
	        }
	    }catch(Exception e){}
	    authors[i]=author;
	}
	public static Book addBook(){
	    Scanner in=new Scanner(System.in);
	    System.out.print("Enter the Book name : ");
	    String name=in.next();
	    System.out.print("Enter the Book price : ");
	    Double price=in.nextDouble();
	    System.out.print("Enter the Book quantity: ");
	    int qty=in.nextInt();
	    Author authors[]=new Author[10];
	    int i=0;
	    while(true){
		System.out.println("Enter Author name : ");
		String name1=in.next();
		System.out.println("Enter Author email : ");
		String email=in.next();
		System.out.println("Enter Author gender(M/F) : ");
		String gender=in.next();
		authors[i++]=new Author(name1,email,gender.charAt(0));
		System.out.println("Enter yes to add more authors : ");
		String ch=in.next();
		if(!ch.toLowerCase().equals("yes")){
				break;
		}
	    }
	    Book book=new Book(name,authors,price,qty);
	    return book;
       	}
	static int find(Book book[], int n, String bk){
	    for(int i=0;i<n;i++){
		if(book[i].getName().toLowerCase().equals(bk)){
	            return i;
		}
	    }
	    return -1;
	}
	public static void main(String ar[]){
	    Scanner in=new Scanner(System.in);
	    Book books[]=new Book[10];
	    int j,i=0;
	    j=0;
        while(true){
        		if(j==-1){
        			break;
        		}
			System.out.println(" 1. Enter a new book\n 2. Add an author for particular book\n 3. Display the authors for a particular book\n 4.Print book details \nAny other to Exit");
			int ch=in.nextInt();			
			switch(ch){
		    	case 1:{
					books[i++]=addBook();
					break;			
		    	}
		    	case 2:{
					System.out.println("Enter Book name : ");
					String bk=in.next();	
					j=find(books,i,bk);
					if(j==-1){
			    			System.out.println("Book not found! try again");
			    			break;
					}
					System.out.println("Enter Author name : ");
					String name=in.next();
					System.out.println("Enter Author email : ");
					String email=in.next();
		        		System.out.println("Enter Author gender(M/F) : ");
					String gender=in.next();
					Author auth=new Author(name,email,gender.charAt(0));
					books[j].addAuthor(auth);	
					break;
		    	}
		    	case 3:{
					System.out.println("Enter Book name : ");
					String bk=in.next();
					j=find(books,i,bk);
					if(j==-1){
			    			System.out.println(bk+" Book not found!, try again");
			    			break;
					}
					books[j].printAuthors();
					break;
		    	}
		    	case 4:{
					for(j=0;j<i;j++){
			    			System.out.println(books[j].toDisplay()+",");
					}
					break;
		    	}
		    	default:{
					j=-1;
		    	}
	    		}//switch
    	}//while
	}//main
}//class
