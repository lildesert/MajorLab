package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fr.dauphine.publications_analytics.src.UserStory2;

public class Author {
	
	public void getAverageNumberOfPublicatons(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		List <Integer> results = new LinkedList();
		
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfPublicationForOneAuthor(file_name, listAuthor.get(i)));
		}

		float mean = Calcul.mean(results);
		float median = Calcul.median(results);
		float mode = Calcul.mode(results);
		
		System.out.println("Mean = " + mean + ", median = " + median + "mode = " + results);
	}

}
