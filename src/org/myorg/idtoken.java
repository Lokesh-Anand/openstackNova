package org.myorg;
import java.util.*;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
class idtoken {
    
    public static String[][] main(String args[]) throws IOException
    {String [] ts_list={}; 
        BufferedReader br = new BufferedReader(new FileReader("/home/hduser/input.txt"));
        String line,ts;int j=0;String arr[][]=new String[100][500];
        while ((line = br.readLine()) != null) 
        {
            String[] tokens =line.split("##",2);
            ts=tokens[1].trim();
            ts=ts.replace('[',' ');  //removing [
            ts=ts.replace(']',' ');  //removing ]
            ts=ts.trim();
            //System.out.println(ts);
            ts_list=ts.split(",");
            String t;
            //System.out.println(tokens[0]);
		arr[j][0]=tokens[0];int k=1;//System.out.println(arr[j][0]);
            for(int i=0;i<ts_list.length;i++)
            {
                ts_list[i]=ts_list[i].trim();
                //System.out.println(ts_list[i]);
                String[] final_ts=ts_list[i].split("%");
               /* t=final_ts[1].replaceAll(":","");String s=t.replace(".","");
		long z=Long.parseLong(s);*/
		try{arr[j][k]=final_ts[0];}catch(Exception e){}
		
              // System.out.println(arr[j][k]);
                k++;
            }
         
	List<String> list1 = new ArrayList<String>();
	
	for(int d=0;d<ts_list.length;d++)
		 {list1.add(arr[j][d+1]); }
	//System.out.println(list1.get(d)); 
	/*try
	{	//Comparator cmp = Collections.reverseOrder();  
		
		Collections.sort(list1);}
		catch(Exception e){}*/
	for(int c=0;c<ts_list.length;c++)
      {
	arr[j][c+1]=list1.get(c);

      }        
j++;
}
    br.close();




for(int t=0;t<26;t++)
	for(int s=0;s<200;s++)
	if(arr[t][s]!=null)	
	System.out.println(arr[t][s]);

return arr;


}}/*
List<String> list1 = new ArrayList<String>();
	for(int l=0;l<100;l++)	
	{for(int k=0;k<200;k++)
	{
          try{list1.add(arr[l][k+1]);}catch(Exception e){}
	  
        }try
	{Collections.sort(list1);}
		catch(Exception e){}
	for(int c=1;c<ts_list.length+1;c++)
      {
	arr[l][c]=list1.get(c-1);

      }*/

     

	
    /*String arrcopy[][]=new String[100][ts_list.length];
     
      for (int i=0; i <arr.length; i++) {
        arrcopy[i] = Arrays.copyOf(arr[i], arr[i].length);
      }
	
        for(int i=0;i<100;i++)
	{
				
		Arrays.sort(arrcopy[i]);
		
	}
        for (final String[] s : arrcopy) {
            for(int a=0;j<s.length;j++)
		System.out.println(s[a]);
        }*/


