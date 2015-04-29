
package org.myorg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class residentifier 
{
public static List<String> main(String [] args) throws IOException
{
String []id_list={};

	String t="";
	FileReader f10 =  new FileReader("/home/hduser/testing.csv");
	BufferedReader f12 = new BufferedReader(f10);
	String id;int i;i=0;List<String> list1 = new ArrayList<String>();
	for(int v=0;(t = f12.readLine()) != null;v++)
	{
		if(t.contains("Memory")||t.contains("memory"))
		{	
			String[] tokens=t.split(",",2);
			//System.out.println("true");
			String []s=tokens[1].split("&&",3);
			for(int y=0;y<s.length;y++)	
			{	
			//System.out.println(s[y]);
			list1.add(s[y]);
			
			
			}
			
		}
		
		
	}
	Set<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	set.addAll(list1);
	list1 = new ArrayList<String>(set);List<String> list2 = new ArrayList<String>();
	list1.remove("");
	for(String s:list1)			
	System.out.println(s);	
	
	idtoken tk=new idtoken();
	String[][] id1={{}};
	id1=tk.main(null);
	for(int t1=0;t1<26;t1++)
		for(int s=0;s<200;s++)
		if(id1[t1][s]!=null)	
		{
			for(String b:list1)
			if(id1[t1][s].equals(b))
			list2.add(id1[t1][0]);
			
			
		}
	Set<String> set1 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);	
	set1.addAll(list2);
	list2 = new ArrayList<String>(set1);
	
	for(String f:list2)
		System.out.println(f);
	return list2;
	
	
	

	
}
}