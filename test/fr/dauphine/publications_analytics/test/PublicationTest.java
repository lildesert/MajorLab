package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.UserStory2;
import fr.dauphine.publications_analytics.src.UserStory5;
import fr.dauphine.publications_analytics_task3.src.*;

public class PublicationTest {
	
	String file_name = "dblp_2.xml";
	
	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory5 us5 = new UserStory5();
		Question5ATest(us5);
		Question5BTest(us5);
		Question5CTest(us5);
		Question5DTest(us5);
		Question5ETest(us5);
	}
	
	public void Question5ATest(UserStory5 us5) throws Exception	{
		Publication publication = new Publication();
		HashMap<String, Double> result = new HashMap();
		result = publication.getAverageNumberOfAuthorsPerPublication(us5, file_name);
		Calcul.display(result);
		assertEquals(4.0, result.get("mean"),0);
		assertEquals(7.0, result.get("median"),0);
		assertEquals(2.0, result.get("mode"),0);
	}
	
	public void Question5BTest(UserStory5 us5) throws Exception	{
		Publication publication = new Publication();
		HashMap<String, Double> h = new HashMap();
		h= publication.getAverageNumberOfAuthorsPerJournalArticle(us5, file_name);
		Calcul.display(h);
		assertEquals(4.5, h.get("mean"),0);
		assertEquals(4.5, h.get("median"),0);
		assertEquals(4.0, h.get("mode"),0);
	}
	
	public void Question5CTest(UserStory5 us5) throws Exception	{
		Publication publication = new Publication();
		HashMap<String, Double> h = new HashMap();
		h= publication.getAverageNumberOfAuthorsPerConferenceProceeding(us5, file_name);
		Calcul.display(h);
		assertEquals(7.0, h.get("mean"),0);
		assertEquals(7.0, h.get("median"),0);
		assertEquals(7.0, h.get("mode"),0);
	}
	
	public void Question5DTest(UserStory5 us5) throws Exception	{
		Publication publication = new Publication();
		HashMap<String, Double> h = new HashMap();
		h= publication.getAverageNumberOfAuthorsPerBookChapter(us5, file_name);
		Calcul.display(h);
		assertEquals(2.0, h.get("mean"),0);
		assertEquals(2.0, h.get("median"),0);
		assertEquals(2.0, h.get("mode"),0);
	}
	
	public void Question5ETest(UserStory5 us5) throws Exception	{
		Publication publication = new Publication();
		HashMap<String, Double> h = new HashMap();
		h= publication.getAverageNumberOfAuthorsPerBook(us5, file_name);
		Calcul.display(h);
		assertEquals(2.0, h.get("mean"),0);
		assertEquals(2.0, h.get("median"),0);
		assertEquals(2.0, h.get("mode"),0);
	}
	
/*	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory5 us5 = new UserStory5();
		Publication publication = new Publication();
		
		HashMap<String, Double> h = new HashMap();
		
		h = publication.getAverageNumberOfAuthorsPerPublication(us5);
		
		Calcul.display(h);
		
	}*/

}