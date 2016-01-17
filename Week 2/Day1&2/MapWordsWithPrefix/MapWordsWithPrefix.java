package com.chargebee.adithya.training.prefix;
import java.util.*;

public class MapWordsWithPrefix{
	public static void addWord(Map<String,ArrayList<String>>map , String value){
		String key="";
		for(int i=0;i<3&&i<value.length();i++){
			key=value.substring(0,i+1);
		}
		if(map.get(key)==null){
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(value);
	}
	public static void main(String ar[]){
		System.out.println("Enter the array of words : \nStop entering by giving '.'");
		ArrayList<String> words=new ArrayList<String> ();
		Scanner in=new Scanner(System.in);
	    String str;
		while(true){
			str=in.nextLine();
			if(str.equals(".")){
				break;
			}
			words.add(str);
		}
		
		Iterator itr=words.iterator();
		Map<String,ArrayList<String>> sortedMap=new TreeMap<String,ArrayList<String>>();
        while(itr.hasNext()){
        		str=itr.next().toString();
        	    addWord(sortedMap,str);
		}
		
		System.out.println("Words by Prefix(Sorted) : "+sortedMap);
					
	}
}