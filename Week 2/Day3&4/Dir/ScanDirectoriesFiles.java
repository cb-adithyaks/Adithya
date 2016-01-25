package com.chargebee.adithya.training.files;
import java.io.*;
import java.util.*;
public class ScanDirectoriesFiles {

	public static void main(String[] args) {
		File dir = new File("/Users/cb-adityaks/Downloads/Git"); // current directory
		System.out.println(displayDirectoryExtensions(dir,new HashSet<String>(),new HashMap<String,Integer>()));
	}
	public static String getExtension(String name){
		int i=name.lastIndexOf('.');
		if(i>1){
			return name.substring(i+1);
		}else{
			return "";
		}
	}
	public static HashMap<String,Integer> displayDirectoryExtensions(File dir,Set<String> extensions,HashMap<String,Integer>extension_count) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					displayDirectoryExtensions(file,extensions,extension_count);
				} else {
					String ext=getExtension(file.getName());
					System.out.println(ext);
					extensions.add(ext);
					if(extension_count.get(ext)==null){
						extension_count.put(ext,0);	
					}
					int count=extension_count.get(ext);
					extension_count.put(ext,count+1);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extension_count;
	}

}
