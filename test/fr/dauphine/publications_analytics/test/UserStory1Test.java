package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.*;

public class UserStory1Test {

	@Test
	public void TestPrincipal() throws Exception {
		
		UserStory1 us1 = new UserStory1();

		Question1ATest(us1);
		Question1BTest(us1);
		Question1CTest(us1);
		Question1DTest(us1);
		Question1ETest(us1);
		Question1FTest(us1);
	}

	public void Question1ATest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(932, us1.getNumberOfPublications(file_name));
	}
	
	public void Question1BTest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(4367, us1.getNumberOfAuthorAppearances(file_name));
	}
	
	public void Question1CTest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(527, us1.getNumberOfConferenceProcessing(file_name));
	}

	public void Question1DTest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(358, us1.getNumberOfJournalArticles(file_name));
	}

	public void Question1ETest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(8, us1.getNumberOfBookAppearances(file_name));
	}

	public void Question1FTest(UserStory1 us1) throws Exception {
		String file_name = "dblp_curated_sample.xml";
		assertEquals(39, us1.getNumberOfChaptersAppearances(file_name));
	}
}