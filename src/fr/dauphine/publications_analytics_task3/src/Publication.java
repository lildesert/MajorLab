package fr.dauphine.publications_analytics_task3.src;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import fr.dauphine.publications_analytics.src.*;
//import fr.dauphine.publications_analytics.test.hashmap;

public class Publication {
	
	
	@Test
	public HashMap<String, Double> getAverageNumberOfAuthorsPerPublication(UserStory5 us5, String file_name) throws Exception {
		List<Integer> results = new LinkedList();
		results = us5.getNumberOfTaskPerAuthor(file_name,"*");

		return Calcul.computeAll(results);
	}
	
	@Test
	public HashMap<String, Double> getAverageNumberOfAuthorsPerJournalArticle(UserStory5 us5, String file_name) throws Exception {
		List<Integer> results = new LinkedList();
		results = us5.getNumberOfTaskPerAuthor(file_name,"article");
				
		return Calcul.computeAll(results);
	}
	
	@Test
	public HashMap<String, Double> getAverageNumberOfAuthorsPerConferenceProceeding(UserStory5 us5, String file_name) throws Exception {
		List<Integer> results = new LinkedList();
		results = us5.getNumberOfTaskPerAuthor(file_name,"inproceedings");
				
		return Calcul.computeAll(results);
	}
	
	@Test
	public HashMap<String, Double> getAverageNumberOfAuthorsPerBookChapter(UserStory5 us5, String file_name) throws Exception {
		List<Integer> results = new LinkedList();
		results = us5.getNumberOfTaskPerAuthor(file_name,"incollection");
				
		return Calcul.computeAll(results);
	}
	
	@Test
	public HashMap<String, Double> getAverageNumberOfAuthorsPerBook(UserStory5 us5, String file_name) throws Exception {
		List<Integer> results = new LinkedList();
		results = us5.getNumberOfTaskPerAuthor(file_name,"book");
				
		return Calcul.computeAll(results);
	}
	
/*	@Test
	public void Question1ATest() throws Exception {
		UserStory5 us5 = new UserStory5();
		String file_name = "dblp_curated_sample.xml";
		
		List <Integer> results = new LinkedList();
		
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		results = us5.getNumberOfTaskPerAuthor(file_name,"*");
		
		System.out.print("nombre de publication " + results.size());

		double mean = Calcul.mean(results);
		double median = Calcul.median(results);
		//int mode = Calcul.mode(results);
		
		System.out.println("Mean = " + mean + ", median = " + median + "mode = " + results);
	} */
	
}
