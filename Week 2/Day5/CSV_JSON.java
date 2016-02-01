package com.chargebee.adithya.training.csvjson;

import org.json.*;
import org.json.simple.parser.*;  
import org.json.simple.parser.*;  

import org.apache.commons.csv.*;

import java.text.SimpleDateFormat;

import java.io.*;
import java.util.*;

public class CSV_JSON{
	private List<CSVRecord> inputRecords;
	private JSONObject jsonObject;
	private Set<String> fileHeaders;

	public CSV_JSON(){
		inputRecords = new ArrayList<CSVRecord>();
	}

	public void readInputCSV(String filename) throws Exception{
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader();
			fileReader = new BufferedReader(new FileReader(filename));
			csvFileParser = new CSVParser(fileReader,csvFileFormat);

			inputRecords = csvFileParser.getRecords();
			fileHeaders = csvFileParser.getHeaderMap().keySet();
			
		}finally{
			fileReader.close();
			csvFileParser.close();	
		}
		
	}

	public void parseConfigJson(String filename) throws Exception{
		JSONParser parser = new JSONParser();
		Object obj =parser.parse(new BufferedReader(new FileReader(filename))); 
		jsonObject = new JSONObject(obj.toString());
	}

	public void writeOutputCSV(String filename) throws Exception{
		BufferedWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;	
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");	
		try{
			fileWriter = new BufferedWriter(new FileWriter(filename));			
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileFormat);

			setOutputFileHeader(csvFilePrinter);

			Iterator<CSVRecord> records = inputRecords.iterator();
			while(records.hasNext()){
				//System.out.println(records.next());
				changeFormat(csvFilePrinter,records.next());	
			}
		}finally{
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		}
	}
	
	private void setOutputFileHeader(CSVPrinter csvPrinter) throws Exception{
		Set<String> headerList = new LinkedHashSet<String>();	
		String str="";	
		for(String header : fileHeaders){
			//System.out.println(header);
			JSONObject valueObject = jsonObject.optJSONObject(header);
			//System.out.println(valueObject.getString("type"));
			if(!valueObject.getString("type").equals("Customer")){		
				headerList.add(valueObject.getString("column"));
			}
			else{
				str=valueObject.getString("column");
			}
		}
		headerList.add(str);
		csvPrinter.printRecord(headerList);
	}
	
	public String changeDateFormat(String oldPattern, String newPattern,String value) throws Exception{
		if(value.equals("")){
			return "";
		}
		SimpleDateFormat oldDateFormat = new SimpleDateFormat(oldPattern);
		SimpleDateFormat newDateFormat = new SimpleDateFormat(newPattern);
		
		Date date = (Date)oldDateFormat.parse(value);
		return newDateFormat.format(date);
	}

	public String changetoDouble(String decimalValue, Double value){
		
		Double val=Double.parseDouble(decimalValue);
		//System.out.println(value/val);
		return Double.toString(value/val);
	}

	


	private void changeFormat(CSVPrinter csvPrinter,CSVRecord record) throws Exception{
		 
		//This loop converts all the column values to config file format.
		String last="";												//used for appending customer details at last in record
		for(String heading : fileHeaders){
			
			JSONObject valueObject = jsonObject.optJSONObject(heading);	
			String type = (valueObject != null) ? valueObject.getString("type") : null;
			if(type != null){
				//System.out.println(type);
				switch(type){
					case "Date"		:	
										csvPrinter.print(changeDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",valueObject.getString("new format").toString(),record.get(heading)));	
										break;
					case "Divide"	:	
										csvPrinter.print(changetoDouble(valueObject.getString("value"),Double.parseDouble(record.get(heading))));	
										break;
										
					case "Customer"		
									:
										if(!valueObject.getString("field").equals("")){
											last+=valueObject.getString("field")+"\""+record.get(heading)+"\"";
											if(valueObject.getString("field").equals(",\"Company\" : ")){
												last+="}";
											}
										}	
										break;
										
					case "default"    :	csvPrinter.print(record.get(heading));	
										
				}
				
			}
			
  			
  		}
  		csvPrinter.print(last);
  		csvPrinter.println();
	}
	public static void main(String args[]) throws Exception{
		
		CSV_JSON csv = new CSV_JSON();
		csv.readInputCSV("input.csv");
		csv.parseConfigJson("config.json");
		csv.writeOutputCSV("output.csv");

	}
	
}