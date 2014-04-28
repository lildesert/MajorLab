package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.List;

import fr.dauphine.publications_analytics.src.UserStory2;

public class Author {
	
	public void Question2ATest(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		System.out.print("nombre d'auteur " + listAuthor.size());
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		for (int i = 0; i < listAuthor.size(); i++) {
			authorPublicationMap.put(listAuthor.get(i), us2
					.getNumberOfPublicationForOneAuthor(file_name,
							listAuthor.get(i)));
		}

		for (int j = 0; j < listAuthor.size(); j++) 
			System.out.println("Auteur = " + listAuthor.get(j)
					+ " Number of publications ="
					+ authorPublicationMap.get(listAuthor.get(j)));
	}

}
