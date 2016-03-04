package com.chargebee.adithya.training.jdbc;
import java.sql.*;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.*;

public class Database{
	final String JDBC_DRIVER;  
   	final String DB_URL;
   	final String USER;
   	final String PASS;
	final String[] fields;
	Connection con;
	Database(String JDBC_DRIVER, String DB_URL, String USER, String PASS, String[] fields){
		this.JDBC_DRIVER=JDBC_DRIVER;		
		this.DB_URL=DB_URL;
		this.USER=USER;
		this.PASS=PASS;
		this.fields=fields;
		try{
			Class.forName(JDBC_DRIVER);		
			con = DriverManager.getConnection(DB_URL,USER,PASS);	//Creating Connection
		}catch(Exception e){}
	}

	public  void createTable(String DB, String createTable, String dropTable) throws SQLException{
    		PreparedStatement tableStatement=null;
    		try{
    			con.setAutoCommit(false);
    			tableStatement=con.prepareStatement(dropTable);
    			tableStatement.executeUpdate();
    			tableStatement=con.prepareStatement(createTable);
			tableStatement.executeUpdate();
    			tableStatement=con.prepareStatement(DB);
			tableStatement.executeUpdate();
    			con.commit();
		}catch(SQLException e){					//Error handling
			if(con==null){
				System.out.println("CONNECTION PROBLEM - CREATE TABLE");
			}
			else{
				try{
					System.err.print("Transaction is being rolled back");
					con.rollback();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		}finally{
			if (tableStatement !=null) {
				tableStatement.close();
			}
			con.setAutoCommit(true);
		}
	}
	public void insertValue(String query) throws SQLException{
		PreparedStatement tableStatement = con.prepareStatement(query);
		try{
			
			con.setAutoCommit(false);
			tableStatement.executeUpdate();	
			con.commit();
			
		}catch(SQLException e){			//Error handling
			if(con!=null){
				try {
                		System.err.print("Transaction is being rolled back");
               		con.rollback();
            		}catch(SQLException se){
            			se.printStackTrace();
            		}
            	}else{
            		System.err.print("CONNECTION ERROR");
           	}		
		}finally{
			if (tableStatement !=null) {
				tableStatement.close();
			}
			con.setAutoCommit(true);
		}
	}
	
	public  void toDisplay(PreparedStatement queryStatement) throws SQLException{
		ResultSet rs=null;
		int count=0;
		int i=0;
		try{
			rs=queryStatement.executeQuery();
			while(rs.next()){
				System.out.print(fields[i]+rs.getString(fields[i++])+"\n");
				System.out.print(fields[i]+rs.getString(fields[i++])+"\n");
				System.out.print(fields[i]+rs.getString(fields[i++])+"\n");
				System.out.print(fields[i]+rs.getString(fields[i++])+"\n");
				System.out.print(fields[i]+rs.getString(fields[i++])+"\n");
				System.out.println("\n\n");
				count++;
			}
			if(count==0){
				System.out.println("Sorry the searched value was not found!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
		}
	}

					//Searches the databases for full name match
	public  void searchByName(String query) {
		PreparedStatement tableStatement=null;
		try{
			tableStatement= con.prepareStatement(query);
			toDisplay(tableStatement);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{tableStatement.close();}catch(Exception e){}
		}
	}	

					//searches the databases for partial match
	public  void searchByPartial(String query) throws SQLException{
		PreparedStatement queryStatement=null;
		try{
			queryStatement= con.prepareStatement(query);
			toDisplay(queryStatement);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{queryStatement.close();}catch(Exception e){}
		}
	}	

					//searches the databases for number match
	public  void searchByNumber(String query) throws SQLException{
		PreparedStatement queryStatement=null;
		try{
			queryStatement=con.prepareStatement(query);
			toDisplay(queryStatement);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{queryStatement.close();}catch(Exception e){}
		}
	}


	
}
