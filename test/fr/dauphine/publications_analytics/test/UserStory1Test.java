package fr.dauphine.publications_analytics.test;
import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import fr.dauphine.publications_analytics.src.*;

public class UserStory1Test {
	

	@Test
	public void TestPrincipal() throws Exception
	{
		Question1ATest();
		Question1BTest();
		Question1CTest();
		Question1DTest();
		Question1ETest();
	}
	
	public void Question1DTest() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(358, UserStory1.getNumberOfJournalArticles(file_name));
	}
}