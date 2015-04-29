package org.myorg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortStartInstances {

public static void main(String[] args) throws IOException{
BarChartDemo b=new BarChartDemo();
String p[][]=b.getP();


List<String> list1 = new ArrayList<String>();
int i=0;
for(String[] str:p) {
	
	   for(String value:str) {
		  // if(value!=null)
	      System.out.println(value);
	   }
	}

for(String[] str:p) {
	
	   for(String value:str) {
	      if(value!=null)
		  {
	    	 System.out.println("true");
		  list1.add(value);
	      }
	   }
	Collections.sort(list1);
	   
	   
for(String s:list1)
	System.out.println(s);

}


}}
