package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.UserStory2;
import fr.dauphine.publications_analytics.src.UserStory3;
import fr.dauphine.publications_analytics.src.UserStory4;
import fr.dauphine.publications_analytics_task3.src.*;

public class AuthorTest {
	
	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory2 us2 = new UserStory2();
		String file_name = "dblp_2.xml";
		Question2ATest(us2, file_name);
		Question2BTest(us2, file_name);
		Question2CTest(us2, file_name);
		Question2DTest(us2, file_name);
		Question2ETest(us2, file_name);
	}
	
	public void Question2ATest(UserStory2 us2, String file_name) throws Exception	{
		Author author = new Author();
		HashMap<String, Double> result = new HashMap();
		result = author.getAverageNumberOfPublications(us2, file_name);
		assertEquals(1.25, result.get("mean"), 0);
		assertEquals(1.0, result.get("median"), 0);
		assertEquals(1.0, result.get("mode"), 0);
		
	}
	
	public void Question2BTest(UserStory2 us2, String file_name) throws Exception	{
		Author author = new Author();
		HashMap<String, Double> result = new HashMap();
		result = author.getAverageNumberJournalArticles(us2, file_name);
		assertEquals(0.5625, result.get("mean"), 0);
		assertEquals(0.5, result.get("median"), 0);
		assertEquals(0.0, result.get("mode"), 0);
	}
	
	
	public void Question2CTest(UserStory2 us2, String file_name) throws Exception	{
		Author author = new Author();
		HashMap<String, Double> result = new HashMap();
		result = author.getAverageNumberConferencesProcedings(us2, file_name);
		assertEquals(0.4375, result.get("mean"), 0);
		assertEquals(0, result.get("median"), 0);
		assertEquals(0, result.get("mode"), 0);
	}
	
	
	public void Question2DTest(UserStory2 us2, String file_name) throws Exception	{
		Author author = new Author();
		HashMap<String, Double> result = new HashMap();
		result = author.getAverageNumberBooks(us2, file_name);
		assertEquals(0.125, result.get("mean"), 0);
		assertEquals(0.5, result.get("median"), 0);
		assertEquals(0, result.get("mode"), 0);
	} 
	
	public void Question2ETest(UserStory2 us2, String file_name) throws Exception	{
		Author author = new Author();
		HashMap<String, Double> result = new HashMap();
		result = author.getAverageNumberBooksChapters(us2, file_name);
		assertEquals(0.125, result.get("mean"), 0);
		assertEquals(0.0, result.get("median"), 0);
		assertEquals(0, result.get("mode"), 0);
		
	}
}
