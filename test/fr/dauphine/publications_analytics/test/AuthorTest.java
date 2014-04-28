package fr.dauphine.publications_analytics.test;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.UserStory2;
import fr.dauphine.publications_analytics_task3.src.*;

public class AuthorTest {
	
	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory2 us2 = new UserStory2();
		Author author = new Author();
		
		
		author.getAverageNumberOfPublications(us2);
	}
}
