package fr.dauphine.publications_analytics_task3.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import fr.dauphine.publications_analytics.src.*;

public class Publication {
	

	@Test
	public void Question1ATest() throws Exception {
		UserStory5 us5 = new UserStory5();
		String file_name = "dblp_curated_sample.xml";
		
		List <Integer> results = new LinkedList();
		
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		results = us5.getNumberOfTaskPerAuthor(file_name,"*");
		
		System.out.print("nombre de publication " + results.size());

		double mean = Calcul.mean(results);
		double median = Calcul.median(results);
		int mode = Calcul.mode(results);
		
		System.out.println("Mean = " + mean + ", median = " + median + "mode = " + results);
	}
	
}
