package com.chargebee.adithya.training.jdbc;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.*;

public class CsvReader{
	public static List <CSVRecord> getRecords(File source){
		try{
			CSVParser parser=new CSVParser(new FileReader(source),CSVFormat.DEFAULT.withRecordSeparator("\n").withHeader("name","address","mobile","home","work"));
			List<CSVRecord> records=parser.getRecords();
			return records;
		}catch(Exception e){}
		return new ArrayList<CSVRecord>();
	}
}
