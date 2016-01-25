package com.chargebee.adithya.training.files;
import java.io.*;
import java.util.*;

public class RemoveDuplicatesCSV{
	public static void main(String ar[])throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("sample.csv"));
		ArrayList<String> lines=new ArrayList<String>();
		String line;
		while((line = br.readLine()) != null){
          		if(!lines.contains(line)){
           			lines.add(line);
          		 }
      		}
      	File output=new File("output.csv");
    	output.createNewFile();
    	FileOutputStream out = new FileOutputStream(output);
    	for(String line1: lines){
    		line1+="\n";
    		out.write(line1.getBytes());
    	}
      	br.close();
	}
}