package fr.dauphine.publications_analytics.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.*;

public class UserStory2Test {

	@Test
	public void TestPrincipal() throws Exception {

		UserStory2 us2 = new UserStory2();

		Question2ATest(us2);
		Question2BTest(us2);
		Question2CTest(us2);
		Question2DTest(us2);
		Question2ETest(us2);
	}

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

	public void Question2BTest(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		System.out.print("nombre d'auteur " + listAuthor.size());
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		for (int i = 0; i < listAuthor.size(); i++) {
			authorPublicationMap.put(listAuthor.get(i), us2
					.getNumberOfConferencesProcedingsPerAuthors(file_name,
							listAuthor.get(i)));
		}

		for (int j = 0; j < listAuthor.size(); j++)
			System.out.println("Auteur = " + listAuthor.get(j)
					+ " Number of conf="
					+ authorPublicationMap.get(listAuthor.get(j)));

	}

	public void Question2CTest(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		System.out.print("nombre d'auteur " + listAuthor.size());
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		for (int i = 0; i < listAuthor.size(); i++) {
			authorPublicationMap.put(listAuthor.get(i), us2
					.getNumberOfJournalArticlesPerAuthor(file_name,
							listAuthor.get(i)));
		}

		for (int j = 0; j < listAuthor.size(); j++)
			System.out.println("Auteur = " + listAuthor.get(j)
					+ " Number of journal articles ="
					+ authorPublicationMap.get(listAuthor.get(j)));
	}

	public void Question2DTest(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		for (int i = 0; i < listAuthor.size(); i++) {
			authorPublicationMap
					.put(listAuthor.get(i),
							us2.getNumberOfBooksPerAuthor(file_name,
									listAuthor.get(i)));
		}
		for (int j = 0; j < listAuthor.size(); j++)
			System.out.println("Auteur = " + listAuthor.get(j)
					+ " Number of book="
					+ authorPublicationMap.get(listAuthor.get(j)));

	}

	public void Question2ETest(UserStory2 us2) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		List<String> listAuthor = us2.getAuthor(file_name);
		HashMap<String, Integer> authorPublicationMap = new HashMap();
		for (int i = 0; i < listAuthor.size(); i++) {
			authorPublicationMap.put(
					listAuthor.get(i),
					us2.getNumberOfBookchaptersPerAuthor(file_name,
							listAuthor.get(i)));
		}
		for (int j = 0; j < listAuthor.size(); j++)
			System.out.println("Auteur = " + listAuthor.get(j)
					+ " Number of book chapter="
					+ authorPublicationMap.get(listAuthor.get(j)));

	}
}
