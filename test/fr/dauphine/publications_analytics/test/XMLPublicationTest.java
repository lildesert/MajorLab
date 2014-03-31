package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.XMLPublication;

public class XMLPublicationTest {

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
	
	//@Test
	public void should_have_1_articles_per_author() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(1, xb.get_number_of_journal_per_author(file_name, "Francesco Caruso"));
	}
	
	//@Test
	public void should_have_1_books_per_author() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(0, xb.get_number_of_books_per_author(file_name, "Francesco Caruso"));
	}
	
	//@Test
	public void should_have_1_bookchapters_per_author() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(1, xb.get_number_of_bookchapters_per_author(file_name, "Lei Dang"));
	}
	
	
	//Vincent
	@Test
	public void should_support_multiple_books() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(8,
				xb.get_number_of_books_appearancesC(file_name));

	}
	
	@Test
	public void should_support_multiple_chapters() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(39,
				xb.get_number_of_chapters_appearancesC(file_name));

	}
	
	@Test
	public void should_support_multiple_conferencesProcedings_per_authorsC() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
		
		for(int i = 0;i<listAuthor.size();i++)	{
			System.out.println(listAuthor.get(i));
		}
	}
	
	//@Test
	public void Test_confProceeding_per_authorsC() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
		System.out.print("nombre d'auteur " + listAuthor.size());
		HashMap<String,Integer> authorPublicationMap = new HashMap();
		
		for(int i = 0;i<listAuthor.size();i++)	{
			authorPublicationMap.put(listAuthor.get(i), xb.get_number_of_conferencesProcedings_per_authorsC(file_name,listAuthor.get(i)));
		}
		
		for(int j = 0;j<listAuthor.size();j++)
			System.out.println("Auteur = " + listAuthor.get(j) + " Number of conf="+ authorPublicationMap.get(listAuthor.get(j)));
	
	}
	
	//@Test
	public void Test_books_per_authorsC() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
		HashMap<String,Integer> authorPublicationMap = new HashMap();
		
		for(int i = 0;i<listAuthor.size();i++)	{
			authorPublicationMap.put(listAuthor.get(i), xb.get_number_of_books_per_author(file_name,listAuthor.get(i)));
		}
		for(int j = 0;j<listAuthor.size();j++)
			System.out.println("Auteur = " + listAuthor.get(j) + " Number of book="+ authorPublicationMap.get(listAuthor.get(j)));
	
	}
	
	//@Test
	public void Test_booksChapter_per_authorsC() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
		HashMap<String,Integer> authorPublicationMap = new HashMap();
		for(int i = 0;i<listAuthor.size();i++)	{
			authorPublicationMap.put(listAuthor.get(i), xb.get_number_of_bookchapters_per_author(file_name,listAuthor.get(i)));
		}
		for(int j = 0;j<listAuthor.size();j++)
			System.out.println("Auteur = " + listAuthor.get(j) + " Number of book chapter="+ authorPublicationMap.get(listAuthor.get(j)));
	
	}
	
	
	//@Test
	public void Test_number_of_publication_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		for(int i = 0;i<listYear.size();i++)	{
			yearPublicationMap.put(listYear.get(i), xb.get_number_of_publications_per_year(file_name,listYear.get(i)));
		}
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of publication="+ yearPublicationMap.get(listYear.get(j)));
	
	}
	//@Test
	public void Test_number_of_publicationsConference_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		for(int i = 0;i<listYear.size();i++)	{
			yearPublicationMap.put(listYear.get(i), xb.get_number_of_publicationsConference_per_year(file_name,listYear.get(i)));
		}
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of publication conference="+ yearPublicationMap.get(listYear.get(j)));
	
	}
	@Test
	public void Test_number_of_journalArticles_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		for(int i = 0;i<listYear.size();i++)	{
			yearPublicationMap.put(listYear.get(i), xb.get_number_of_journalArticles_per_year(file_name,listYear.get(i)));
		}
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of journal articles="+ yearPublicationMap.get(listYear.get(j)));
	
	}
	@Test
	public void Test_number_of_book_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		for(int i = 0;i<listYear.size();i++)	{
			yearPublicationMap.put(listYear.get(i), xb.get_number_of_book_per_year(file_name,listYear.get(i)));
		}
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of book="+ yearPublicationMap.get(listYear.get(j)));
	
	}
	
	// TODO
	@Test
	public void Test_number_of_author_publications_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();

		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);

		//year:number of author
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		
		for(int i = 0;i<listYear.size();i++)	{
			for(int j = 0;j<listAuthor.size();j++)	{
				//TODO
				yearPublicationMap.put(listYear.get(i), xb.get_number_of_publications_per_year(file_name,listYear.get(i),listAuthor.get(j)));
			}
		}
		
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of chapter="+ yearPublicationMap.get(listYear.get(j)));
	
	}
	@Test
	public void Test_number_of_chapter_per_year() throws Exception	{
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
		HashMap<String,Integer> yearPublicationMap = new HashMap();
		for(int i = 0;i<listYear.size();i++)	{
			yearPublicationMap.put(listYear.get(i), xb.get_number_of_chapter_per_year(file_name,listYear.get(i)));
		}
		for(int j = 0;j<listYear.size();j++)
			System.out.println("AnnŽe = " + listYear.get(j) + " Number of chapter="+ yearPublicationMap.get(listYear.get(j)));
	
	}	
	
	//David
	@Test
	public void conferenceProceedingNumberTest() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(527,
				xb.getNumberOfConferenceProcessing(file_name));
		
	}
	
	@Test
	public void number_of_publication_for_one_authorTest() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(1,
				xb.get_number_of_publication_for_one_author(file_name, "Dale Vincent"));
		
	}
	
	@Test
	public void getAuthorTest() throws Exception {
		String file_name = "dblp_curated_sample.xml";
		XMLPublication xb = new XMLPublication();
		assertEquals(1139,
				xb.getAuthor(file_name).size());
		
	}

}

