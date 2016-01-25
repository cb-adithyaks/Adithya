package com.chargebee.adithya.training.files;
import java.io.*;
import java.util.*;
public class MoveDirectoriesFiles {

	public static void main(String[] args) {
		File dir = new File("/Users/cb-adityaks/Downloads/Testing"); // current directory
		File mkdir = new File("/Users/cb-adityaks/Downloads/Testing/ks");
		mkdir.mkdirs();
		displayDirectoryExtensions(dir,new HashMap<String,Integer>(),mkdir);
	}
	
	public static void displayDirectoryExtensions(File dir,HashMap<String,Integer>fileName_count,File movdir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					displayDirectoryExtensions(file,fileName_count,movdir);
				} else {
					String fileName=file.getName();
					int count=fileName_count.containsKey(fileName)? fileName_count.get(fileName) : 0;
					fileName_count.put(file.getName(),++count);
					if(count>1){
						int index=fileName.lastIndexOf('.');
						if(index==-1){
							index=0;
						}
						fileName=fileName.substring(0,index)+"-"+count+fileName.substring(index);
					}
					file.renameTo(new File(movdir+"/"+fileName));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
