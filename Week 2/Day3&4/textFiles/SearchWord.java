package com.chargebee.adithya.training.files;
import java.util.*;
import java.io.*;

public class SearchWord{
	
	public static ArrayList<String> findWord(String line, String word){
		String temp;
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<line.length();i++){
			int end=line.indexOf(' ',i);
			if(end==-1){
				end=line.length()-1;
			}
			temp=line.substring(i,end);
			if(temp.equals(word)){
				ret.add(String.valueOf(i+1));
			}
		}
		return ret;
	}
	public static void main(String ar[])throws Exception{
		File file=new File("sample.txt");
		BufferedReader br=new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
    	String line = br.readLine();	
    	String answer="";
    	int i=1;
    	String word=(new Scanner(System.in)).nextLine();
    	ArrayList<String> found=new ArrayList<String>();
		while (line != null) {
			found=findWord(line,word);
			if(found.size()>=1){
				answer+="Line "+i+": "+found.toString()+"\n";
			}
        		sb.append(line);
        		sb.append(System.lineSeparator());
        		line = br.readLine();
        		i++;
    	}
    	String fileName=word+".locations"+".txt";
    	File output=new File(fileName);
    	output.createNewFile();
    	FileOutputStream out = new FileOutputStream(output);
    	out.write(answer.getBytes());
	}
}