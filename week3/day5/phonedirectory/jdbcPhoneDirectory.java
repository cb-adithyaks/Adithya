package com.chargebee.adithya.training.jdbc;

import java.sql.*;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.*;


class jdbcPhoneDirectory{



	static List <CSVRecord> records =null;
	static int count;

	
					//Create the table
    public static void createTable(Database db) throws SQLException{
    		String DB=
    			"use phone_directory;";
    		String createTable=
    			"create table phone_directory.directory (name varchar(20) not null,address varchar(40) not null,mobile varchar(20),home varchar(20),work varchar(20));";
    		String dropTable=
    			"drop table if exists phone_directory.directory ;";
    		db.createTable(DB,createTable,dropTable);
	}



					//Gets the input from the source file


	public static void insertValues(Database db) throws SQLException{
		String insertValueString=
    			"insert into phone_directory.directory values(";	
			for (int i=1;i<records.size();i++){
				CSVRecord record=records.get(i);
				insertValueString+=record.get("name")+",";
				insertValueString+=record.get("address")+",";
				insertValueString+=record.get("mobile")+",";
				insertValueString+=record.get("home")+",";
				insertValueString+=record.get("work")+");";
				db.insertValue(insertValueString);
			}
	}
	
	public static void insertValue(Database db, String name,String address,String mobile,String home,String work) throws SQLException{
		String insertValueString=
    			"insert into phone_directory.directory values(";
		insertValueString+=name+",";
				insertValueString+=address+",";
				insertValueString+=mobile+",";
				insertValueString+=home+",";
				insertValueString+=work+");";	
		db.insertValue(insertValueString);
	}

	
					//Searches the databases for full name match
	public static void searchByName(Database db,String name) throws SQLException{
		PreparedStatement queryStatement=null;
		String queryString=
		"select name,address,mobile,home,work from phone_directory.directory where name = "+name+";";
		
	}	

					//searches the databases for partial match
	public static void searchByPartial(Database db,String name) throws SQLException{
		PreparedStatement queryStatement=null;
		String queryString=
		"select name,address,mobile,home,work from phone_directory.directory where name like('%'"+ name +"'%');";
		
	}	

					//searches the databases for number match
	public static void searchByNumber(Database db,String number) throws SQLException{
		PreparedStatement queryStatement=null;
		String queryString=
		"select name,address,mobile,home,work from phone_directory.directory where home = "+number+" or work= "+number+" or mobile= "+number+";";
		db.searchByNumber(queryString);
	}


					//main method
	public static void main(String args[]) throws SQLException,IOException,ClassNotFoundException{
		
		Scanner scanner=new Scanner(System.in);
		Connection conn = null;
		int choice;
		String name;
		String number;
		try{
			File source=new File("directory.csv");
			String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	 		String DB_URL = "jdbc:mysql://localhost/phone_directory";
   			String USER = "root";
   			String PASS = "";
			String fields[]={"name","address","mobile","home","work"};		
			//conn = DriverManager.getConnection(DB_URL,USER,PASS);				//connection is created
			Database db=new Database(JDBC_DRIVER,DB_URL,USER,PASS,fields);
			createTable(db);
			records=CsvReader.getRecords(source);
			System.out.println(records);
			insertValues(db);
			do{
				System.out.println("\n\n\n\n\n1.Search by name\n2.Search by partial name\n3.Search by phone number\n4.Insert or update");
				choice=scanner.nextInt();
				switch(choice){							//recieves users choice
					case 1:								//search based on name
						System.out.println("Enter the name of the person whose number is to be searched");
						name=scanner.next();
						searchByName(db,name);
						break;
					case 2:								//search based on partial name
						System.out.println("Enter the partial name of the person whose details are needed");
						name=scanner.next();
						searchByPartial(db,name);
						break;
					case 3:								//search based on number
						System.out.println("Enter the phone number of the person to be searched");
						number=scanner.next();
						searchByNumber(db,number);
						break;
					case 4:								
						System.out.println("\n\nEnter 1 to insert \nEnter any other to update");
						int ch=scanner.nextInt();
						if(ch==1){
							System.out.println("Enter the details : ");
							System.out.println("Name :");String name1=scanner.next();
							System.out.println("Address :");String address=scanner.next();
							System.out.println("Mobile :");String mobile=scanner.next();
							System.out.println("Home :");String home=scanner.next();
							System.out.println("Work :");String work=scanner.next();
							insertValue(db,name1,address,mobile,home,work);
	
						}
						else{
						//update(con);
						}	
						break;
					default:
						System.out.println("Please enter a valid choice");
						break;
				}	
			}while(choice<4);
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
}





