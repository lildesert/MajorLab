package fr.dauphine.publications_analytics_task4.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.HashMap;

public class CSVMaker {
	
	public static void makeCSV(String filename, HashMap<String, Integer> listAuthors) {
		File outputFile = new File(filename);
		try {
			FileWriter out = new FileWriter(outputFile);
			
			for (Entry<String, Integer> e : listAuthors.entrySet()) {
			    String key = e.getKey();
			    Object value = e.getValue();
			    
			    out.write(key);
			    out.write(',');
			    out.write(value.toString());
			    out.write('\n');
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
