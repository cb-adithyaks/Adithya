package com.chargebee.adithya.training.MapWordsWithLength;
import java.util.*;
import java.io.*;

public class MapWordsWithLength{
	public static void addWord(Map<Integer,ArrayList<String>> map,String value){
		int key=value.length();
		if(map.get(key)==null){
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(value);
	}
	public static void printWords(ArrayList<String> words){
		Iterator itr=words.iterator();
		String str;
		while(true){
        		str=itr.next().toString();
        		if(itr.hasNext()){
        	    	System.out.print(str+",");
        	    }
        	    else{
        	    	System.out.println(str);
        	    	break;
        	    }
		}
		
	}
	public static void main(String ar[]){
		System.out.println("Enter the array of words : \nStop entering by giving '.'");					
		ArrayList<String> words=new ArrayList<String> ();
		Scanner in=new Scanner(System.in);
	    	String str;
	    	int key;
		while(true){
			str=in.nextLine();
			if(str.equals(".")){
				break;											//Adding Input words to list
			}
			words.add(str);
		}
		
		Iterator itr=words.iterator();
		Map<Integer,ArrayList<String>> map=new HashMap<Integer,ArrayList<String>>();
        	while(itr.hasNext()){
        		str=itr.next().toString();									//Adding words in list to map with key as their length
        	    addWord(map,str);
		}
		//System.out.println(map);
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			str=iterator.next().toString();
			key=Integer.parseInt(str);
			System.out.print("Words with length "+key+" : ");						//Printing the map
			words=map.get(key);
			printWords(words);
		}
	}
}