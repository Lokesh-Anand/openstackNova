package org.myorg;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.myorg.*;

public class dbscan {
	
	int[] vis;
	int clusterid=0;
	Set<String> tmpA = new HashSet<String>();
	Set<String> tmpB = new HashSet<String>();
	public void calc(ArrayList<String> dataset, double eps, int minpts,ArrayList<String> reqids,String opt1)
	{
		
		vis = new int[dataset.size()];
		int[] cluster = new int[dataset.size()];
		String[] tr={""};
		
		
		for(int i=0;i<vis.length;i++)
			vis[i]=0;
		for(int i=0;i<cluster.length;i++)
		{
			cluster[i]=0;
		}
		
     for (int i = 0; i < dataset.size(); i++) 
       {
        		
        		
        		Set<String> datapoint = new HashSet<String>();
        		String[] d = dataset.get(i).split(",");
        		//System.out.println(dataset.get(i));
        		for(int j=0; j<d.length; j++)
        		{
        			//System.out.println(d[j]);
        			String[] d1=d[j].split("%");
        			datapoint.add(d1[0]);
        		}
        		
        		if(vis[i]!=1)
        		{
        			vis[i]=1;
        			
        			Set<String> neighbors = new HashSet<String>(regionQuery(dataset,datapoint,i, eps));
        			//System.out.println(neighbors);
        			
        			if (neighbors.size()<minpts)
        			{
        				
        				cluster[i]=9999;
        				
        			}
        			
        			else
        			{
        			/*System.out.println("New  cluster found");
        			System.out.println("Cluster points: "+datapoint);
        			try
        			{
        			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        			String str = bufferedReader.readLine();
        			System.out.println(str);
        			}
        			catch(Exception e)
        			{
        				
        			}*/
        			
        			clusterid++;
        			cluster = expandCluster(dataset,datapoint,i, eps,neighbors,cluster,vis,clusterid,minpts);
        			
        			        			
        			
        			}
        		}
        		    
       }
     
     //assign clusterid to outlier
     for(int h=0;h<cluster.length;h++)
     {
    	 
    	 //System.out.println(dataset.size());
    	 if(cluster[h]==9999)
    	 {
    		 Set<String> outlier = new HashSet<String>();
     			String[] out = dataset.get(h).split(",");
     		for(int k=0; k<out.length; k++)
    		{
     			String[] d1=out[k].split("%");
    			
    			outlier.add(d1[0]);
    		}
     		
     		/*ArrayList<Integer> intList = new ArrayList<Integer>();
     		for (int index = 0; index < cluster.length; index++)
     	    {
     	        intList.add(cluster[index]);
     	    }
     		
     		Set<Integer> unique = new HashSet<Integer>(intList);
     		intList.removeAll(intList);
     	    intList.addAll(unique);*/
     	   
     		double[] odt = new double[cluster.length];
     		
     		
     		ArrayList<Integer> traversed = new ArrayList<Integer>();
     		for (int index = 0; index < cluster.length; index++)
     	    {
     	        traversed.add(0);
     	    }
     		//System.out.println(traversed);
     		
     		
     		
     		//for (int s = 0; s < intList.size(); s++) 
     		//{
     			
     		for (int k = 0; k < dataset.size(); k++) 
            {
     			Set<String> tmp = new HashSet<String>(outlier);
     			if(traversed.get(k)!=1 && cluster[k]!=9999)
     			{
     				int cid=cluster[k];
     				
     				for (int index = 0; index < cluster.length; index++)
     	     	    {
     					if(cluster[index]==cid)
     						traversed.set(index,1);
     					
     	     	    }
     				
     				String[] d = dataset.get(k).split(",");
    				Set<String> curpoint = new HashSet<String>();
            		for(int j=0; j<d.length; j++)
            		{
            			String d1[]=d[j].split("%");
            			
            			curpoint.add(d1[0]);
            		}
            		
            		int sizeh1 = tmp.size();
    				tmp.retainAll(curpoint);
    				curpoint.removeAll(tmp);
    				int union = sizeh1 + curpoint.size();
    				int intersection = tmp.size();
            		
            		odt[k]= (double)intersection/union;
            		
            		//System.out.println("here");
            		
     			}
            }
     		//}
     		int hid=0;
     		double highest=0;
     		for(int z=0;z<odt.length;z++)
     		{
     			if(odt[z]> highest)
     			{
     				highest=odt[z];
     				hid=cluster[z];
     			}
     				
     			
     		}
     		
     		cluster[h]= hid*100;
    	 }
    	 
    	     }
     //assigning clusterid to outlier ends
     
     try
     {
    	 FileWriter fil = new FileWriter("/home/hduser/res.txt",true);
    	 for(int q=0;q<cluster.length;q++)
 		{
    		 fil.append(reqids.get(q)+",");
    		 if(cluster[q]==4 || cluster[q]==400)
    			 fil.append("Create VM,");
    		 else if(cluster[q]==1 || cluster[q]==100)
    			 fil.append("Delete VM,");
    			 else if(cluster[q]==2 || cluster[q]==200)
    				 fil.append("Snapshot VM,");
    				 else if(cluster[q]==3|| cluster[q]==300)
    					 fil.append("Rebuild VM,");
    					 else 
    						 fil.append("Resume VM,");
    		 if(cluster[q]>=100)
    			 fil.append("Fail\n");
    		 else
    			 fil.append("Success\n");
 		}
    	 fil.close();
    	 
     }
    catch(Exception ex)
    {
    	
    }
     
     //finding anomalous sequence
     int outid=0;
     for(int q=0;q<cluster.length;q++)
		{
    	 	if(cluster[q]>100)
    	 	{
    	 		
    	 		tr = dataset.get(q).split(",");
    			for(int m1=0; m1<tr.length; m1++)
    			{
    				String t2[]=tr[m1].split("%");
    				tmpA.add(t2[0]);
    				
    			}
    	 		
    	 		
    	 		
    	 		
    	 		for(int v=0;v<cluster.length;v++)
    			{
    	 			if((cluster[q]/100)==cluster[v])
    	 			{
    	 				outid=v;
    	 				break;
    	 			}
    			}
    	 		
    	 		//trying to modify
    	 		String[] t1 = dataset.get(outid).split(",");
    			for(int m1=0; m1<t1.length; m1++)
    			{
    				String t2[]=t1[m1].split("%");
    				tmpB.add(t2[0]);
    				
    			}
    			tmpA.removeAll(tmpB);
    			String sorted="",line="";
    			for(int e=0;e<tr.length;e++)
    			{
    				for (String s : tmpA)
    				{
    					if(tr[e].contains(s+"%"))
    						line=line+tr[e]+",";
    					
    				}
    				
    			}
    			sorted=sort_tsp(line);
    			String [] tmp = sorted.split(",");
    			try
    			{
    			FileWriter fi = new FileWriter("/home/hduser/results"+q+".html",true);
    			fi.append("<html><table border=\"1\"><tr><th>File</th><th>Method</th><th>Severity</th><th>Signature</th></tr>");
    			fi.close();
    			for(int f=0;f<tmp.length;f++)
    			{
    				String [] tmp1 = tmp[f].split("%"); 
    			
    				navigate_ref_files(tmp1[0],q);
    			}
    			FileWriter fl = new FileWriter("/home/hduser/results"+q+".html",true);
    			fl.append("</table></html>");
    			fl.close();
    			}
    			catch(Exception e)
    			{
    				
    			}
    	 		//end of trying to modify
    			
    		    //getting original log lines
    		    ArrayList<String> opt = new ArrayList<String>();
    		    try
    		    {
    		    	FileWriter foo = new FileWriter("/home/hduser/res"+q+".html",true);
        			foo.append("<html><table border=\"1\"><tr><th>SEVERITY</th><th>MESSAGE</th></tr>");
        			foo.close();
    		    String lne="";
    		    FileReader f101 =  new FileReader(opt1);
    		                    BufferedReader f121 = new BufferedReader(f101);
    		                    
    		                    for(int i=0;(lne=f121.readLine()) != null ;i++)
    		                    {
    		                   
    		                    if(lne.contains(reqids.get(q)))
    		                    {
    		                   
    		                    String [] temp = sorted.split(",");
    		                    String prev="";
    		                    for(int f=0;f<temp.length;f++)
    		                {
    		                    String [] tmp1 = temp[f].split("%");
    		                   
    		                    if(lne.contains(tmp1[1]))
    		                    {
    		                    //System.out.println(tmp1[1]);
    		                    try{
    		                    if(Integer.valueOf(tmp1[0]) < 1647)
    		                    {
    		                    FileReader f1 =  new FileReader("/home/hduser/Downloads/FINAL_REFERENCE8.csv");
    		                    BufferedReader f11 = new BufferedReader(f1);
    		                    String t ="";
    		                    for(int j=0;(t = f11.readLine()) != null;j++)
    		                    {
    		                    String qi[]=t.split(",");
    		                   
    		                   
    		                    if(qi[5].trim().equalsIgnoreCase(tmp1[0].trim()))
    		                    {
    		                    //System.out.println("ORIGINAL LINE------->"+lne);
    		                    String list[] = qi[4].split("#");
    		                    int mtch=0;
    		                    for(int ji=0;ji<list.length-1;ji++)
    		                    {
    		                   
    		                    if(lne.contains(list[ji]))//do you want to add space on either sides for robustness?
    		                    {
    		                    mtch++;//number of words that match
    		                    }
    		                   
    		                    //check if number of matching words equals the total words, then it is a complete match
    		                    if(mtch==Integer.valueOf(list[list.length-1]))
    		                    {
    		                    //append the line to output list
    		                    opt.add(lne);
    		                   // if(!(tmp1[1].equalsIgnoreCase(prev)))
    		                   // {
    		                    //System.out.println("ORIGINAL LINE------->"+lne);
    		                    FileWriter foo1 = new FileWriter("/home/hduser/res"+q+".html",true);
    		                    
    		                    String pattern = ".* (DEBUG|INFO|AUDIT|TRACE|ERROR|WARNING) .*";
    		        			Matcher m = Pattern.compile(pattern).matcher(lne);
    		        			if(m.find())
    		        			{
    		        				
	    		        			
    		        				if(m.group(1).equalsIgnoreCase("error"))
    		        				{
    		        					String pattern1 = ".*\\] (.*)";
    	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
    	    		        			
    	    		        			if(m1.find())
    	    		        			{
    		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:red\">"+m.group(1)+"</td><td><span style=\" color:red\">"+m1.group(1)+"</td></tr>");
    	    		        			}
    		        				}
    		        				else if(m.group(1).equalsIgnoreCase("warning"))
    		        				{
    		        					String pattern1 = ".*\\] (.*)";
    	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
    	    		        			
    	    		        			if(m1.find())
    	    		        			{
    		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:orange\">"+m.group(1)+"</td><td><span style=\" color:orange\">"+m1.group(1)+"</td></tr>");
    	    		        			}
    		        					
    		        				}
    		        				else
    		        				{
    		        					String pattern1 = ".*\\] (.*)";
    	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
    	    		        			if(m1.find())
    		        					foo1.append("<tr><td>"+m.group(1)+"</td><td>"+m1.group(1)+"</td></tr>");
    		        				}
    		        			}
    		        			
    		                    
    		                    foo1.close();
    		                 
    		                   
    		                    }
    		                    }
    		                                       	
    		                    }
    		                   
    		                    }
    		                     f1.close();                  	
    		                    }
    		                    else if(Integer.valueOf(tmp1[1]) < 1888)
    		                    {
    		                    	FileReader f1 =  new FileReader("/home/hduser/Downloads/FINAL_REFERENCE_EXCPS8.csv");
        		                    BufferedReader f11 = new BufferedReader(f1);
        		                    String t ="";
        		                    for(int j=0;(t = f11.readLine()) != null;j++)
        		                    {
        		                    String qi[]=t.split(",");
        		                   
        		                   
        		                    if(qi[5].trim().equalsIgnoreCase(tmp1[0].trim()))
        		                    {
        		                    //System.out.println("ORIGINAL LINE------->"+lne);
        		                    String list[] = qi[4].split("#");
        		                    int mtch=0;
        		                    for(int ji=0;ji<list.length-1;ji++)
        		                    {
        		                   
        		                    if(lne.contains(list[ji]))//do you want to add space on either sides for robustness?
        		                    {
        		                    mtch++;//number of words that match
        		                    }
        		                   
        		                    //check if number of matching words equals the total words, then it is a complete match
        		                    if(mtch==Integer.valueOf(list[list.length-1]))
        		                    {
        		                    //append the line to output list
        		                    opt.add(lne);
        		                    //if(!(tmp1[1].equalsIgnoreCase(prev)))
        		                    //System.out.println("ORIGINAL LINE------->"+lne);
        		                    FileWriter foo1 = new FileWriter("/home/hduser/res"+q+".html",true);
        		                    String pattern = ".* (DEBUG|INFO|AUDIT|TRACE|ERROR|WARNING) .*";
        		        			Matcher m = Pattern.compile(pattern).matcher(lne);
        		        			if(m.find())
        		        			{
        		        				
    	    		        			
        		        				if(m.group(1).equalsIgnoreCase("error"))
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			
        	    		        			if(m1.find())
        	    		        			{
        		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:red\">"+m.group(1)+"</td><td><span style=\" color:red\">"+m1.group(1)+"</td></tr>");
        	    		        			}
        		        				}
        		        				else if(m.group(1).equalsIgnoreCase("warning"))
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			
        	    		        			if(m1.find())
        	    		        			{
        		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:orange\">"+m.group(1)+"</td><td><span style=\" color:orange\">"+m1.group(1)+"</td></tr>");
        	    		        			}
        		        					
        		        				}
        		        				else
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			if(m1.find())
        		        					foo1.append("<tr><td>"+m.group(1)+"</td><td>"+m1.group(1)+"</td></tr>");
        		        				}
        		        			}
        		        			
        		                    foo1.close();
        		                    
        		                   
        		                    }
        		                    }
        		                                       	
        		                    }
        		                   
        		                    }
        		                    f1.close();
    		                    }
    		                    else
    		                    {
    		                    	FileReader f1 =  new FileReader("/home/hduser/Downloads/MESSAGE8.csv");
        		                    BufferedReader f11 = new BufferedReader(f1);
        		                    String t ="";
        		                    for(int j=0;(t = f11.readLine()) != null;j++)
        		                    {
        		                    String qi[]=t.split(",");
        		                   
        		                   
        		                    if(qi[5].trim().equalsIgnoreCase(tmp1[0].trim()))
        		                    {
        		                    //System.out.println("ORIGINAL LINE------->"+lne);
        		                    String list[] = qi[4].split("#");
        		                    int mtch=0;
        		                    for(int ji=0;ji<list.length-1;ji++)
        		                    {
        		                   
        		                    if(lne.contains(list[ji]))//do you want to add space on either sides for robustness?
        		                    {
        		                    mtch++;//number of words that match
        		                    }
        		                   
        		                    //check if number of matching words equals the total words, then it is a complete match
        		                    if(mtch==Integer.valueOf(list[list.length-1]))
        		                    {
        		                    //append the line to output list
        		                    opt.add(lne);
        		                    //if(!(tmp1[1].equalsIgnoreCase(prev)))
        		                   // System.out.println("ORIGINAL LINE------->"+lne);
        		                    FileWriter foo1 = new FileWriter("/home/hduser/res"+q+".html",true);
        		                    String pattern = ".* (DEBUG|INFO|AUDIT|TRACE|ERROR|WARNING) .*";
        		        			Matcher m = Pattern.compile(pattern).matcher(lne);
        		        			if(m.find())
        		        			{
        		        				
    	    		        			
        		        				if(m.group(1).equalsIgnoreCase("error"))
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			
        	    		        			if(m1.find())
        	    		        			{
        		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:red\">"+m.group(1)+"</td><td><span style=\" color:red\">"+m1.group(1)+"</td></tr>");
        	    		        			}
        		        				}
        		        				else if(m.group(1).equalsIgnoreCase("warning"))
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			
        	    		        			if(m1.find())
        	    		        			{
        		        						foo1.append("<tr><td><span style=\"font-weight:bold; color:orange\">"+m.group(1)+"</td><td><span style=\" color:orange\">"+m1.group(1)+"</td></tr>");
        	    		        			}
        		        					
        		        				}
        		        				else
        		        				{
        		        					String pattern1 = ".*\\] (.*)";
        	    		        			Matcher m1 = Pattern.compile(pattern1).matcher(lne);
        	    		        			if(m1.find())
        		        					foo1.append("<tr><td>"+m.group(1)+"</td><td>"+m1.group(1)+"</td></tr>");
        		        				}
        		        			}
        		                   
        		                   
        		        			foo1.close();
        		                    }
        		                    }
        		                                       	
        		                    }
        		                   
        		                    }
        		                    f1.close();
    		                    	
    		                    	
    		                    }
    		                   // FileWriter fooo = new FileWriter("/home/hduser/res"+q+".html",true);
    		                   // fooo.append("</table></html>");
    		                   // fooo.close();
    		                    }
    		                    catch(Exception e)
    		                    {
    		                   
    		                    }
    		                    }
    		                    prev=tmp1[1];
    		                }
    		                    }
    		                   
    		                    }
    		    }
    		    catch(Exception e)
    		    {
    		   
    		    }
    		   
    		   
    		   
    		    //getting original log lines end
    	 		
    	 		
    	 	}
		}
     
     
		
	}
	
	public static int[] expandCluster(ArrayList<String> dataset,Set<String> datapoint,int i, double eps,Set<String> neighbors,int[] cluster,int[] vis,int clusterid,int minpts)
	{
		
		//System.out.println(datapoint);
		/*add P to cluster C
		   for each point P' in NeighborPts 
		      if P' is not visited
		         mark P' as visited
		         NeighborPts' = regionQuery(P', eps)
		         if sizeof(NeighborPts') >= MinPts
		            NeighborPts = NeighborPts joined with NeighborPts'
		      if P' is not yet member of any cluster
		         add P' to cluster C*/
		ArrayList<String> nb = new ArrayList<String>();
		
		nb.addAll(neighbors);
		cluster[i]=clusterid;
		
		//System.out.println(Integer.valueOf(nb.get(0)));
		
		for(int j=0; j<neighbors.size();j++)
		{
			
		int cur=Integer.valueOf(nb.get(j));
		//System.out.println(cur);
		Set<String> dpt = new HashSet<String>();
		String[] d = dataset.get(cur).split(",");
		for(int m=0; m<d.length; m++)
		{
			String d1[] = d[m].split("%");
			dpt.add(d1[0]);
			
		}
		
		if(vis[cur]!=1)
		{
			vis[cur]=1;		
			
			Set<String> nbrs = new HashSet<String>(regionQuery(dataset,dpt,cur, eps));
			
			if (nbrs.size() >= minpts)
				neighbors.addAll(nbrs);
			
		}
		if(cluster[cur]==0)
			cluster[cur]=clusterid;
		
		
		
				
	}
		
		//System.out.println("DONE 1 iteration");
		return cluster;
	}
	
	public static Set<String> regionQuery(ArrayList<String> dataset,Set<String> datapoint,int i, double eps)
	{
		Set<String> neighbors = new HashSet<String>();
		neighbors.add(java.lang.Integer.toString(i));
		
		
		for (int k = 0; k < dataset.size(); k++) 
        {
			Set<String> tmp = new HashSet<String>(datapoint);
			
				
				String[] d = dataset.get(k).split(",");
				Set<String> point = new HashSet<String>();
        		for(int j=0; j<d.length; j++)
        		{
        			String d1[] =d[j].split("%");
        			point.add(d1[0]);
        		}
        		//System.out.println(datapoint);
        		//System.out.println(point);
        		//System.out.println("");
				int sizeh1 = datapoint.size();
				tmp.retainAll(point);
				point.removeAll(tmp);
				int union = sizeh1 + point.size();
				int intersection = tmp.size();
				
				//System.out.println((double)intersection/union);
				if((double)intersection/union >= eps)
				{
					
					neighbors.add(java.lang.Integer.toString(k));
					
				}
				
			
			
        }
		
		return neighbors;
		
	}
	
	public static String sort_tsp(String line)
	{
		
		
		String sorted="";
		
		
		String list2[] = line.split(",");
		
		
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
		
		try
		{
			for(int i=0;i < (list2.length-1);i++)
			{
				
				
			
				for(int y=0; y < (list2.length-i-1); y++)
					
				{
					String list3[]=list2[y].split("%");
					Date date1 = formatter.parse(list3[1]);
					
					String list4[]=list2[y+1].split("%");
					Date date2 = formatter.parse(list4[1]);
				
					if(date1.after(date2))

					{
						String tmp = list2[y];
										
						list2[y] = list2[y+1];

						list2[y+1] = tmp;

					}

				}

			}
			
			for(int i=0;i<list2.length;i++)
			{
				
				sorted+=list2[i]+",";
			}
			
			
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
			
	return sorted;	
	}
	
	public static void navigate_ref_files(String val,int outid)
	{
		String t="";
		try
		{
		FileWriter f = new FileWriter("/home/hduser/results"+outid+".html",true);
		
		if(Integer.valueOf(val) < 1647)
		{
			
		FileReader f1 =  new FileReader("/home/hduser/Downloads/FINAL_REFERENCE8.csv");
		BufferedReader f11 = new BufferedReader(f1);
		for(int j=0;(t = f11.readLine()) != null;j++)
		{
			String q[]=t.split(",");
			q[5]=q[5].trim();
			
			if(q[5].equalsIgnoreCase(val))
			{
				f.append("<tr>");
				//System.out.println("Message Signature ---->"+q[3]);
				
				//System.out.println("From File ---->"+q[0]);
				f.append("<td>"+q[0]+"</td>");
				//System.out.println("Method----->"+q[1]);
				f.append("<td>"+q[1]+"</td>");
				//System.out.println("Severity----->"+q[2]);
				f.append("<td>"+q[2]+"</td>");
				f.append("<td>"+q[3]+"</td>");
				//System.out.println("-------------------------------------------------");
				
				f.append("</tr>");
			}
			
		}
		}
		else if(Integer.valueOf(val) < 1888)
		{
			FileReader f2 =  new FileReader("/home/hduser/Downloads/FINAL_REFERENCE_EXCPS8.csv");
			BufferedReader f22 = new BufferedReader(f2);
			for(int j=0;(t = f22.readLine()) != null;j++)
			{
				String q[]=t.split(",");
				q[5]=q[5].trim();
				
				if(q[5].equalsIgnoreCase(val))
				{
					f.append("<tr>");
					
					
					
					f.append("<td>"+q[0]+"</td>");
					
					f.append("<td>"+q[1]+"</td>");
					
					f.append("<td>"+q[2]+"</td>");
					f.append("<td>"+q[3]+"</td>");
					f.append("</tr>");
				}
				
			}
			
		}
		else
		{
			FileReader f3 =  new FileReader("/home/hduser/Downloads/MESSAGE8.csv");
			BufferedReader f33 = new BufferedReader(f3);
			for(int j=0;(t = f33.readLine()) != null;j++)
			{
				String q[]=t.split(",");
				q[5]=q[5].trim();
				
				if(q[5].equalsIgnoreCase(val))
				{
					f.append("<tr>");
					
					
					
					f.append("<td>"+q[0]+"</td>");
					
					f.append("<td>"+q[1]+"</td>");
					
					f.append("<td>"+q[2]+"</td>");
					f.append("<td>"+q[3]+"</td>");
					f.append("</tr>");
				}
				
			}
			
		}
		
		f.close();
	}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");				
        }
        catch(IOException ex) {
            System.out.println("Error reading file");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	}

