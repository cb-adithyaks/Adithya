package com.chargebee.adithya.training.files;
import java.util.*;
import java.io.*;

public class textFile{
	public static void main(String ar[])throws Exception{
		File file=new File("sample.txt");
		BufferedReader br=new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
    	String line = br.readLine();	
		while (line != null) {
        		sb.append(line);
        		sb.append(System.lineSeparator());
        		line = br.readLine();
    	}
    	HashMap<String,Integer> wordCount=new HashMap<String,Integer>();
    	String everything = sb.toString();
    	for(int i=0;i<everything.length();i++){
    		int end=everything.indexOf(' ',i);
    		if(end==-1){
    			end=everything.length();
    		}
    		String word=everything.substring(i,end);
    		i=end;
    		int count=wordCount.containsKey(word)?wordCount.get(word):0;
    		wordCount.put(word,count+1);
    	}
    	System.out.println(wordCount);
    	File output=new File("output.txt");
    	output.createNewFile();
    	FileOutputStream out = new FileOutputStream("output.txt");
    	out.write(wordCount.toString().getBytes());
	}
}