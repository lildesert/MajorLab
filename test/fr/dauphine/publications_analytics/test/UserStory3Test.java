package fr.dauphine.publications_analytics.test;

import java.util.HashMap;
import java.util.List;

import fr.dauphine.publications_analytics.src.XMLPublication;

public class UserStory3Test {

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
		//@Test
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
		//@Test
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
		
		
			
		
		//@Test
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
}
