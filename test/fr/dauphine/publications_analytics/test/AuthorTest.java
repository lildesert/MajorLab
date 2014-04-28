package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

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
		Question2ATest(us2);
		Question2BTest(us2);
		Question2CTest(us2);
		Question2DTest(us2);
		Question2ETest(us2);
	}
	
	public void Question2ATest(UserStory2 us2) throws Exception	{
		Author author = new Author();
		assertEquals(3, author.getAverageNumberOfPublications(us2));
	}
	
	public void Question2BTest(UserStory2 us2) throws Exception	{
		Author author = new Author();
		assertEquals(3, author.getAverageNumberJournalArticles(us2));
	}
	
	public void Question2CTest(UserStory2 us2) throws Exception	{
		Author author = new Author();
		assertEquals(3, author.getAverageNumberConferencesProcedings(us2));
	}
	
	public void Question2DTest(UserStory2 us2) throws Exception	{
		Author author = new Author();
		assertEquals(3, author.getAverageNumberBooks(us2));
	}
	
	public void Question2ETest(UserStory2 us2) throws Exception	{
		Author author = new Author();
		assertEquals(3, author.getAverageNumberBooksChapters(us2));
	}
}
