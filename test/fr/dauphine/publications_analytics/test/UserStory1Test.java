package fr.dauphine.publications_analytics.test;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.XMLPublication;

public class UserStory1Test {
	
	//@Test
	public void should_support_one_publication() throws Exception {
		String file_name = "dblp_1.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(1, xb.get_number_of_publicationsB(file_name));
	}

	//@Test
	public void should_support_multiple_publications() throws Exception {
		String file_name = "dblp_2.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(3, xb.get_number_of_publicationsC(file_name));
		
	}

	//@Test
	public void should_support_two_author_appearances() throws Exception {
		String file_name = "dblp_1.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(2, xb.get_number_of_author_appearancesB(file_name));
	}
	
	//@Test
	public void should_support_seven_author_appearances() throws Exception {
		String file_name = "dblp_2.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(7, xb.get_number_of_author_appearancesC(file_name));
		
	}
	
	//@Test
	public void should_have_two_as_a_mean() throws Exception {
		String file_name = "dblp_1.xml";
		double delta = 0.0;
		XMLPublication xb = new XMLPublication();
		assertEquals(2.0, xb.get_mean_number_of_authors_per_publicationB(file_name),delta);
	}
	
	//@Test
	public void should_have_two_thirtythree_as_mean() throws Exception {
		String file_name = "dblp_2.xml";
		double delta = 0.004;
		XMLPublication xb = new XMLPublication();
		assertEquals(2.33, xb.get_mean_number_of_authors_per_publicationC(file_name),delta);
	}
	
	//@Test
	public void should_have_1_articles() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(358, xb.get_number_of_journal_articles(file_name));
	}