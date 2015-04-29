package org.myorg;
import java.io.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


import org.myorg.*;
public class cosineprepro {
	
	public static void main(String [] args) {
		String line="";
		
	
	try {
		
	
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(args[0]);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
     // This will reference one line at a time
        
        ArrayList<String> reqids = new ArrayList<String>();
        ArrayList<String> dataset = new ArrayList<String>();
        ArrayList<String> tsp = new ArrayList<String>();
        
        while((line = bufferedReader.readLine()) != null) 
        {
        	
        	String tsmp="";
        	
        	String patternStr="(\\[(.*)?\\])##";
        	Pattern p = Pattern.compile(patternStr);
        	Matcher m = p.matcher(line);
        	
        	if(m.find()){
        	
        		reqids.add(m.group(1));
        	}
        	
        	line=line.replaceAll("\\[(.*)?\\]##","");
        	
        	
        	String patternStr1="%(.*?,) ";
        	Pattern p1 = Pattern.compile(patternStr1);
        	Matcher m1 = p1.matcher(line);
        	
        	while(m1.find()){
        	
        		tsmp=tsmp+m1.group(1);
        	}
        	
        	
        	
        	//line=line.replaceAll("%.*? ",",");
        	//line=line.replaceAll("%.*?\\]","\\]");
        	line=line.replaceAll("9999,","");
        	line=line.replaceAll("\\[","");
        	line=line.replaceAll("\\]","");        	
        	line=line.replaceAll("\\[","");
        	line=line.replaceAll("\\]","");
        	line=line.replaceAll("\\s+","");
        	dataset.add(line);
        	
        	tsp.add(tsmp);
        }
        
        dbscan db = new dbscan();
        db.calc(dataset,0.80,2,reqids,args[1]);
    	
    	
        		
	} 
	
	catch(Exception ex) {
		System.out.println(ex);
    }
	System.out.println("done");
	}
	


}
