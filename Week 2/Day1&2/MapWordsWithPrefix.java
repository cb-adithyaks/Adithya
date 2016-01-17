package com.chargebee.adithya.training.prefix;
import java.util.*;

public class MapWordsWithPrefix{
	
	public TreeMap<String,ArrayList<String>> mapByPrefix(ArrayList<String> words){
		TreeMap<String,ArrayList<String>> map =new TreeMap<String,ArrayList<String>>();
		Iterator itr=words.iterator();
		String value;
		while(itr.hasNext()){
        		value=itr.next().toString();
        		String key="";
			for(int i=0;i<3&&i<value.length();i++){
				key=value.substring(0,i+1);
			}
			if(map.get(key)==null){
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(value);															//Adding words in list to map with key by their prefix
        	}
		return map;
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
	
		TreeMap<String,ArrayList<String>> sortedMap=new MapWordsWithPrefix().mapByPrefix(words);
        		
		System.out.println("Words by Prefix(Sorted) : "+sortedMap);
					
	}
}