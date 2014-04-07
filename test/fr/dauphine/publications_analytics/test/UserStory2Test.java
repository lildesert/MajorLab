package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.assertEquals;

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
		
//		@Test
		public void number_of_publication_for_one_authorTest() throws Exception {
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			assertEquals(1,
					xb.get_number_of_publication_for_one_author(file_name, "Dale Vincent"));
			
		}
		
		//@Test
		public void getAuthorTest() throws Exception {
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			assertEquals(1139,
					xb.getAuthor(file_name).size());
			
		}
		
		//@Test
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
}
