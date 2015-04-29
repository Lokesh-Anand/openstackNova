package org.myorg;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class Wordcount {
	 
	
	
	public static class Map extends Mapper<LongWritable, Text, Text, Text> {
		 //private final static IntWritable one = new IntWritable(1);
		 private Text word = new Text();
		 private Text word1 = new Text();
		 private Text opt = new Text();
		 private Text opt1 = new Text();
		 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		 String line = value.toString();
		 //line=line.replaceFirst("([0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]) ([0-9][0-9]:[0-9][0-9]:[0-9][0-9])(.[0-9][0-9][0-9])", "<TIMESTAMP>");
		 //line=line.replaceFirst("DEBUG", "0");
		 //line=line.replaceFirst("AUDIT", "1");
		 //line=line.replaceFirst("INFO", "2");
		 //line=line.replaceFirst("\\[(.*)?req(.*)?\\]", "<REQID>");
		 opt.set(line);
		 opt1.set("line"); 
		 String reqid = "NULL";
		 word1.set(reqid);
		// if(line.contains("[req")){
		 	String pattern = "(\\[.*?req.*?\\])",mg3="";
			Matcher m = Pattern.compile(pattern).matcher(line);
			//reqid = line.substring(line.indexOf("req"),line.lastIndexOf("]"));
			if(m.find())
			{
			word.set(m.group(1)+"##");
			context.write(word, opt);
			}
		// }		 
		 //StringTokenizer tokenizer = new StringTokenizer(line);
		 //while (tokenizer.hasMoreTokens()) {
		// else
			 //context.write(word1, opt1);
		 //}
		  }
		 }
	 
	 
		 public static class Reduce extends Reducer<Text, Text, Text, Vector<Text>> {

		 public void reduce(Text key, Iterable<Text> values, Context context)
		 throws IOException, InterruptedException {
		 //int sum = 0;
		 //while (values.hasNext()) {
		 //sum += values.next().get();
		 //}
			 String keay = key.toString();
			// if(!"NULL".equals(key))
			// {
				 if(keay.contains("93cb0b394426"))
				 {
			 Vector<Text> vals = new Vector<Text>(); 
		        for (Text val : values){
		             //make copy of val before adding to the Vector
		            String val1 = val.toString();
		            val1 = "\n\n" + val1 + "\n\n";
		            val.set(val1);
		        	vals.add(new Text(val));
		        	
		       }
		        //context.write(key, vals);
				 }
			// }
		  //93cb0b394426      
		// context.write(key, vals);
		 }
		 }
		 
		 
		 public static void main(String[] args) throws Exception {
		 Configuration conf = new Configuration();
		 Job job = new Job(conf, "wordcount");
		 job.setOutputKeyClass(Text.class);
		 job.setOutputValueClass(Text.class);
		 job.setMapperClass(Map.class);
		 //job.setReducerClass(Reduce.class);
		 job.setInputFormatClass(TextInputFormat.class);
		 job.setOutputFormatClass(TextOutputFormat.class);
		 FileInputFormat.addInputPath(job, new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path(args[1]));
		 job.waitForCompletion(true);
		 }

}
