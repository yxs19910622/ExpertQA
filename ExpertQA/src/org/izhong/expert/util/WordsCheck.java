package org.izhong.expert.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordsCheck {
	
	public static List getWords(){
		
		List<String> banWords = new ArrayList();  //禁用词  
	      
	    //初始化将敏感词库全部加载到集合中  
	          
	        try{  
	            String path = WordsCheck.class.getClassLoader().getResource("/mingan").getPath();  //得到类目录 
	            File files[] = new File(path).listFiles();          //得到目录下的所有文件  
	            for(File file : files){     
	                //如果不是文件返回  
	                if(!file.isFile()){  
	                    continue;  
	                }  
	                //如果不是txt文件返回  
	                if(!file.getName().endsWith(".txt")){  
	                    continue;  
	                }  
	                //读txt文件  
	                BufferedReader br = new BufferedReader(new FileReader(file));  
	                String line = null;   
	                while((line=br.readLine())!=null){  
	                    String s[] = line.split("\\|");
	                    String str = null;
	                    str = s[0].replaceAll(" ", "");
	                    if(!banWords.contains(str)){
	                    	banWords.add(str);
	                    }
	                }  
	            }  
	  
	        }catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	        
	        return banWords;
	}
	
	
}