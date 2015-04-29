package org.myorg;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapred.JobConf;


public class match {
	public static int matchcount(String logline,String[] refline)
	{
		
		int mtchcnt=0;
		for(int i=0;i<refline.length;i++)
		{
			if(refline[i] != null)
			{
				
				String list3[] = refline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						mtchcnt++;
					}
				}
			}
		}
		return mtchcnt;
	}
	public static String match(String logline,String[] refline)
	{
		String matchinglines="";
		
		for(int i=0;i<refline.length;i++)
		{
			
			if(refline[i] != null)
			{
				
				String list3[] = refline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						//append the refline to a list
						matchinglines+=refline[i]+"&";
						
					}
				}
			}
		}
		return matchinglines;
	}
	
	
	public static String matchall(String logline,String[] refline,String[] expline,String[] msgline)
	{
		String matchinglines="";
		
		for(int i=0;i<refline.length;i++)
		{
			
			if(refline[i] != null)
			{
				
				String list3[] = refline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						//append the refline to a list
						matchinglines+=refline[i]+"&";
						
					}
				}
			}
			
		}
		for(int i=0;i<expline.length;i++)
		{
			
			if(expline[i] != null)
			{
				
				String list3[] = expline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						//append the refline to a list
						matchinglines+=expline[i]+"&";
						
					}
				}
			}
			
		}
		for(int i=0;i<msgline.length;i++)
		{
			
			if(msgline[i] != null)
			{
				
				String list3[] = msgline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						//append the refline to a list
						matchinglines+=msgline[i]+"&";
						
					}
				}
			}
			
		}
		return matchinglines;
	}
	
	public static int matchcountall(String logline,String[] refline,String[] expline,String[] msgline)
	{
		int mtchcnt=0;
		for(int i=0;i<refline.length;i++)
		{
			
			if(refline[i] != null)
			{
				
				String list3[] = refline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						//append the refline to a list
						mtchcnt++;
						
					}
				}
			}
			
		}
		for(int i=0;i<expline.length;i++)
		{
			
			if(expline[i] != null)
			{
				
				String list3[] = expline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						mtchcnt++;
						
					}
				}
			}
			
		}
		for(int i=0;i<msgline.length;i++)
		{
			
			if(msgline[i] != null)
			{
				
				String list3[] = msgline[i].split(",");
				String list4[] = list3[4].split("#");
				int mtch=0;
				for(int j=0;j<list4.length-1;j++)
				{
					
					if(logline.contains(list4[j]))//do you want to add space on either sides for robustness?
					{
						mtch++;//number of words that match
					}
					
					//check if number of matching words equals the total words, then it is a complete match
					if(mtch==Integer.valueOf(list4[list4.length-1]))
					{
						mtchcnt++;
						
					}
				}
			}
			
		}
		return mtchcnt;
	}
	
	public static String multiplematches(int mtchcnt,String matchinglines,String prev)
	{
		String p="9999";
		String nonambi="";
		//check if multiple matches
		if(mtchcnt>1)
		{
			//get the highest total words
			int hcnt=0,highest=0;
			String lines[]=matchinglines.split("&");
			
			for(int i=0;i<lines.length;i++)
			{
				String lines1[]=lines[i].split(",");
				String lines2[]=lines1[4].split("#");
				if(highest==0)
					highest=Integer.valueOf(lines2[lines2.length-1]);
				else if(Integer.valueOf(lines2[lines2.length-1])>highest)
					highest=Integer.valueOf(lines2[lines2.length-1]);
																
			}
			for(int i=0;i<lines.length;i++)
			{
				String lines1[]=lines[i].split(",");
				String lines2[]=lines1[4].split("#");
				if(Integer.valueOf(lines2[lines2.length-1])==highest)
					hcnt++;
			}
			//if more than 1 line have highest total words, then ambiguous
			if(hcnt>1)
			//print all the lines with highest total words
			{
				
				String ambi="";
				int flag=0;
				String val="0";
				for(int i=0;i<lines.length;i++)
				{
					
					String lines1[]=lines[i].split(",");
					String lines2[]=lines1[4].split("#");
					
					if(Integer.valueOf(lines2[lines2.length-1])==highest)
					{
							ambi+=lines1[4]+"---";
							
							if(flag==0)
							{
								if(Integer.valueOf(lines1[5])-Integer.valueOf(prev)==1)
								{
									
									val=lines1[5];
									nonambi=lines1[4];
									flag++;
								}
								else
								{
									val+=lines1[5]+"&&";
								}
							}
							
					}
					
				}
				
				//System.out.println(val);
				
				try
				{
				FileWriter writer = new FileWriter("/home/hduser/testing.csv",true);
				if(flag != 1)
				{
					writer.append(ambi);
					writer.append(',');
				}
				else
				{
					writer.append(nonambi);
					writer.append(',');
				}
				writer.append(val);
				writer.append('\n');
				writer.flush();
			    writer.close();
			    p=val;
				}
				catch(FileNotFoundException ex) 
			    {
			        System.out.println(ex);				
			    }
			    catch(IOException ex) 
			    {
			        System.out.println("Error reading file");					
			        // Or we could just do this: 
			        // ex.printStackTrace();
			    }
			
			}
			else
			{
				//get the line with highest number of total words
				//print the line with highest
				for(int i=0;i<lines.length;i++)
				{
					String lines1[]=lines[i].split(",");
					String lines2[]=lines1[4].split("#");
					if(Integer.valueOf(lines2[lines2.length-1])==highest)
					{
						//System.out.println(lines1[5]);
						try
						{
						FileWriter writer = new FileWriter("/home/hduser/testing.csv",true);
						writer.append(lines1[4]);
						writer.append(',');
						writer.append(lines1[5]);
						writer.append('\n');
						writer.flush();
					    writer.close();
					    p=lines1[5];
						}
						catch(FileNotFoundException ex) 
					    {
					        System.out.println(ex);				
					    }
					    catch(IOException ex) 
					    {
					        System.out.println("Error reading file");					
					        // Or we could just do this: 
					        // ex.printStackTrace();
					    }
						
					}
					
				}
				
			}
			
			
		}
		else //if single line matches
		{
			//print the matching line
			String lines[]=matchinglines.split("&");
			String lines1[]=lines[0].split(",");
			//System.out.println(lines1[5]);
			try
			{
			
			FileWriter writer = new FileWriter("/home/hduser/testing.csv",true);
			writer.append(lines1[4]);
			writer.append(',');
			writer.append(lines1[5]);
			writer.append('\n');
			writer.flush();
		    writer.close();
		    p=lines1[5];
			}
			catch(FileNotFoundException ex) 
		    {
		        System.out.println(ex);				
		    }
		    catch(IOException ex) 
		    {
		        System.out.println("Error reading file");					
		        // Or we could just do this: 
		        // ex.printStackTrace();
		    }
			
		}
		return p;
	}
	
	
	
	
	 public static class Map extends Mapper<LongWritable, Text, Text, Text> {
		 //private final static IntWritable one = new IntWritable(1);
		 private Text word = new Text();
		 private Text word1 = new Text();
		 private Text opt = new Text();
		 private Text opt1 = new Text();
		 int refcnt,expcnt,msgcnt;
		 String prev="9999";
		
		 String reflines[]=new String[2000];
		 String reflines2[]=new String[2000];
		 String reflines3[]=new String[2000];
		 String explines[]=new String[500];
		 String explines2[]=new String[500];
		 String msglines[]=new String[1000];
		 String msglines2[]=new String[1000];
		 
		 String refline="",expline="",msgline="",res="";
		
		 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			 
			 String logline = value.toString();
			 String tsp="";
			 String pattern = "(\\[(.*)?req(.*)?\\](##))",mg3="";
			 Matcher m = Pattern.compile(pattern).matcher(logline);
			 
			 String pattern5 = "\\d\\d:\\d\\d:\\d\\d.\\d\\d\\d";
			 Matcher m5 = Pattern.compile(pattern5).matcher(logline);
			 
			 if(m5.find())
			 {
				 tsp=m5.group();
			 }
			 
			
			 if(m.find())
			 opt.set(m.group(1));
			 else
			 opt.set("NIL");	 
			 
			 
			 
			 FileReader reffile = new FileReader("/home/hduser/Downloads/FINAL_REFERENCE8.csv");
			 BufferedReader ref_file = new BufferedReader(reffile);
			 for(refcnt=0;(refline = ref_file.readLine()) != null;refcnt++)
	    	 {
	    		reflines[refcnt]=refline;
	    					
	    	 }
			 	
			FileReader expfile = new FileReader("/home/hduser/Downloads/FINAL_REFERENCE_EXCPS8.csv");
	        BufferedReader exp_file = new BufferedReader(expfile);    	
	    	for(expcnt=0;(expline = exp_file.readLine()) != null;expcnt++)
	    	{
	    		explines[expcnt]=expline;
	    					
	    	}
	    		
	    	//read messages reference log file and store each line as a srtring in a array
			FileReader msgfile = new FileReader("/home/hduser/Downloads/MESSAGE8.csv");
	        BufferedReader msg_file = new BufferedReader(msgfile);    	
	    	for(msgcnt=0;(msgline = msg_file.readLine()) != null;msgcnt++)
	    	{
	    		msglines[msgcnt]=msgline;
	    					
	    	}
	    	
	    	if(logline.contains("Running cmd (subprocess):"))
    		{
    			
 		    	prev="1803";
 		    	word.set(prev+"%"+tsp);
 		    	context.write(opt, word);
    		}
    		else if(logline.contains("Result was "))
    		{
    			
 		    	prev="1804";
 		    	word.set(prev+"%"+tsp);
 		    	context.write(opt, word);
    		}
    		else
    		{
    			//extract level from log line
    			String pattern1 = "(INFO|DEBUG|AUDIT|ERROR|WARNING)";
    			Matcher level = Pattern.compile(pattern1).matcher(logline);
				if(level.find())
				{
					//extract all reference log lines with log level
					for(int i=0;i<refcnt;i++)
					{
						//split reference log line into fields
		        		String list1[] = reflines[i].split(",");
		        		if(level.group().contains(list1[2].toUpperCase()) || level.group().contains(list1[2].toLowerCase()))
						{
		        			//extract and store all ref lines with matching level from reflines	into reflines2
		        			reflines2[i] = reflines[i];		        			
						}
					}
					
					//check if logline has file name
					String pattern2 = "((/.+)+)/((.+)\\.py)";
	        		Matcher filename = Pattern.compile(pattern2).matcher(logline);
	        		if(filename.find())
					{
						//extract and store all ref lines with matching filename from reflines2 into reflines3
						for(int i=0;i<reflines2.length;i++)
						{
							if(reflines2[i] != null)
							{
								String list2[] = reflines2[i].split(",");
								if(list2[0].contains(filename.group(3)))
									reflines3[i]=reflines2[i];
							}
						}
													
						
						//message matching
						String matchinglines=match(logline,reflines3);
						int mtchcnt=matchcount(logline,reflines3);
					
						//if message matches
						if(mtchcnt!=0)
						{
							prev=multiplematches(mtchcnt,matchinglines,prev);
							if(prev.contains("&&"))
							{
								String lis[]=prev.split("&&");
								prev=lis[0];
								for(int h=0;h<lis.length;h++)
								{
									word.set(lis[h]+"%"+tsp);
					 		    	context.write(opt, word);
								}
								
							}
							else
							{
							word.set(prev+"%"+tsp);
			 		    	context.write(opt, word);
							}
						}
						else //if message does not match
						{
							
							//extract and store all exp lines with matching filename from explines into explines2
							for(int i=0;i<explines.length;i++)
							{
								if(explines[i] != null)
								{
									String list2[] = explines[i].split(",");
									if(list2[0].contains(filename.group(3)))
										explines2[i]=explines[i];
								}
							}
							
							//message matching
							String matchinglines5=match(logline,explines2);
							int mtchcnt5=matchcount(logline,explines2);
							
							if(mtchcnt5!=0)
							{
								
								prev=multiplematches(mtchcnt5,matchinglines5,prev);
								if(prev.contains("&&"))
								{
									String lis[]=prev.split("&&");
									prev=lis[0];
									for(int h=0;h<lis.length;h++)
									{
										word.set(lis[h]+"%"+tsp);
						 		    	context.write(opt, word);
									}
									
								}
								else
								{
								word.set(prev+"%"+tsp);
				 		    	context.write(opt, word);
								}
									
							}
							else
							{
								//extract and store all msg lines with matching filename from msglines into msgines2
								for(int i=0;i<msglines.length;i++)
								{
									if(msglines[i] != null)
									{
										String list2[] = msglines[i].split(",");
										if(list2[0].contains(filename.group(3)))
											msglines2[i]=msglines[i];
										
									}
								}
								
								
								//message matching
								String matchinglines6=match(logline,msglines2);
								int mtchcnt6=matchcount(logline,msglines2);
								if(mtchcnt6!=0)
								{
									
									prev=multiplematches(mtchcnt6,matchinglines6,prev);
									if(prev.contains("&&"))
									{
										String lis[]=prev.split("&&");
										prev=lis[0];
										for(int h=0;h<lis.length;h++)
										{
											word.set(lis[h]+"%"+tsp);
							 		    	context.write(opt, word);
										}
										
									}
									else
									{
									word.set(prev+"%"+tsp);
					 		    	context.write(opt, word);
									}
									
										
								}
								else
								{
									word.set(Integer.toString(9999)+"%"+tsp);
	                 		    	context.write(opt, word);
								}
							}
							
						}
						
					}
	        		//if filename not found in logline
					else 
					{
						String matchinglines1=matchall(logline,reflines,explines,msglines);
						int mtchcnt1=matchcountall(logline,reflines,explines,msglines);
					
						//check if the message matches?
						if(mtchcnt1!=0)
						{
							
							prev=multiplematches(mtchcnt1,matchinglines1,prev);
							if(prev.contains("&&"))
							{
								String lis[]=prev.split("&&");
								prev=lis[0];
								for(int h=0;h<lis.length;h++)
								{
									word.set(lis[h]+"%"+tsp);
					 		    	context.write(opt, word);
								}
								
							}
							else
							{
							word.set(prev+"%"+tsp);
			 		    	context.write(opt, word);
							}
							
								
						}
						else //if message does not match
						{
							
             		    	word.set(Integer.toString(9999)+"%"+tsp);
             		    	context.write(opt, word);

						}
						
																			
					}
					
				}
				else
				{
					System.out.println("Level not found"+logline);
				}
					
					
					
					
				}
    		}
	    	
	 }
//-----------------------------------------------------------------------------------------
	 
	 public static class Reduce extends Reducer<Text, Text, Text, Vector<Text>> {

		 public void reduce(Text key, Iterable<Text> values, Context context)
		 throws IOException, InterruptedException {
		 //int sum = 0;
		 //while (values.hasNext()) {
		 //sum += values.next().get();
		 //}
			 
			// if(!"NULL".equals(key))
			// {
				 
			 Vector<Text> vals = new Vector<Text>(); 
		        for (Text val : values){
		             //make copy of val before adding to the Vector
		            String val1 = val.toString();
		            val.set(val1);
		        	vals.add(new Text(val));
		        	
				 }
			// }
		  //93cb0b394426      
		context.write(key, vals);
		 }
		 }
	 
 //----------------------------------------------------------------------------------
	
	
	public static void main(String[] args) throws Exception 
	{
		 Configuration conf = new Configuration();
		 Job job = new Job(conf, "match");
		 job.setOutputKeyClass(Text.class);
		 job.setOutputValueClass(Text.class);
		 job.setMapperClass(Map.class);
		 job.setReducerClass(Reduce.class);
		  job.setInputFormatClass(TextInputFormat.class);
		 job.setOutputFormatClass(TextOutputFormat.class);
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 job.waitForCompletion(true);
	 }

}


