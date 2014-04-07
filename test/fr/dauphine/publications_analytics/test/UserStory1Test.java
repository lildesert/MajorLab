package fr.dauphine.publications_analytics.test;
import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;
import fr.dauphine.publications_analytics.src.*;

public class UserStory1Test {
	

	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory1 us1 = new UserStory1();
		
		Question1ATest(us1);
		Question1BTest(us1);
		Question1CTest(us1);
		Question1DTest(us1);
		Question1ETest(us1);
	}
	
	public void Question1DTest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(358, us1.getNumberOfJournalArticles(file_name));
	}
}