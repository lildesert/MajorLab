package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fr.dauphine.publications_analytics.src.UserStory2;

public class Author {
	
	public HashMap<String, Double> getAverageNumberOfPublications(UserStory2 us2, String file_name) throws Exception {
		
		List<String> listAuthor = us2.getAuthor(file_name);
		List <Integer> results = new LinkedList();
		
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfPublicationForOneAuthor(file_name, listAuthor.get(i)));
		}
		return Calcul.computeAll(results);
	}
	
	public HashMap<String, Double> getAverageNumberJournalArticles(UserStory2 us2, String file_name) throws Exception {
		
		List<String> listAuthor = us2.getAuthor(file_name);
		List<Integer> results = new LinkedList();
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfJournalArticlesPerAuthor(file_name, listAuthor.get(i)));
		}
		
		return Calcul.computeAll(results);
	}
	
	public HashMap<String, Double> getAverageNumberConferencesProcedings(UserStory2 us2, String file_name) throws Exception {
		
		List<String> listAuthor = us2.getAuthor(file_name);
		List<Integer> results = new LinkedList();
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfConferencesProcedingsPerAuthors(file_name, listAuthor.get(i)));
		}
		
		return Calcul.computeAll(results);
	}
	
	public HashMap<String, Double> getAverageNumberBooks(UserStory2 us2, String file_name) throws Exception {
		
		List<String> listAuthor = us2.getAuthor(file_name);
		List<Integer> results = new LinkedList();
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfBooksPerAuthor(file_name, listAuthor.get(i)));
		}
				
		return Calcul.computeAll(results);
	}
	
	public HashMap<String, Double> getAverageNumberBooksChapters(UserStory2 us2, String file_name) throws Exception {
		
		List<String> listAuthor = us2.getAuthor(file_name);
		List<Integer> results = new LinkedList();
		for (int i = 0; i < listAuthor.size(); i++) {
			results.add(us2.getNumberOfBookchaptersPerAuthor(file_name, listAuthor.get(i)));
		}
			
		return Calcul.computeAll(results);
	}
}
