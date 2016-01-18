package com.chargebee.adithya.training.prefix;
import java.util.*;

public class MapWordsWithPrefix{
	public ArrayList<String> removeDuplicates(ArrayList<String> list) {
		ArrayList<String> result = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		for (String item : list) {
	    		if (!set.contains(item)) {
				result.add(item);
				set.add(item);
	    		}
		}
	return result;
    }
	public TreeMap<String,ArrayList<String>> mapByPrefix(ArrayList<String> words){
		TreeMap<String,ArrayList<String>> map =new TreeMap<String,ArrayList<String>>();
		Iterator itr=words.iterator();
		ArrayList<String> word= new ArrayList<String>();
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
			word=map.get(key);
			word.add(value);
			word=removeDuplicates(word);
			map.put(key,word);															//Adding words in list to map with key by their prefix
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