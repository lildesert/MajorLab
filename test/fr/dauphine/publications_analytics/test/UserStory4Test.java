package fr.dauphine.publications_analytics.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.XMLPublication;

public class UserStory4Test {

	//@Test
		public void Test_number_of_author_publications_per_year() throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{
				for(int j = 0;j<listAuthor.size();j++)	{

					//s'il a ecrit qlq chose cette annŽe
					nbPublication = xb.get_number_of_publications_per_year(file_name,listYear.get(i),listAuthor.get(j));

					if(nbPublication>0)
						cptAuthor ++;
				}	
				nbPublication=0;
				yearPublicationMap.put(listYear.get(i),cptAuthor);
				cptAuthor = 0;
			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a publication this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
		public void Test_number_of_author_conferenceProceedings_per_year() throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();
			System.out.println("Proceedings");
			for(int i = 0;i<listYear.size();i++)	{
				for(int j = 0;j<listAuthor.size();j++)	{

					//s'il a ecrit qlq chose cette annŽe
					nbPublication = xb.get_number_of_conferenceProceedings_per_year(file_name,listYear.get(i),listAuthor.get(j));

					if(nbPublication>0)
						cptAuthor ++;
				}	
				nbPublication=0;
				yearPublicationMap.put(listYear.get(i),cptAuthor);
				cptAuthor = 0;
			}
			System.out.println("Processing ...");
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a conference proceedings this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
		public void Test_number_of_author_articles_per_year() throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{
				for(int j = 0;j<listAuthor.size();j++)	{

					//s'il a ecrit qlq chose cette annŽe
					nbPublication = xb.get_number_of_articles_per_year(file_name,listYear.get(i),listAuthor.get(j));

					if(nbPublication>0)
						cptAuthor ++;
				}	
				nbPublication=0;
				yearPublicationMap.put(listYear.get(i),cptAuthor);
				cptAuthor = 0;
			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a journal article this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
			public void Test_number_of_author_books_per_year() throws Exception	{
				String file_name = "dblp_curated_sample.xml";
				XMLPublication xb = new XMLPublication();
				List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
				List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
				int cptAuthor = 0,nbPublication=0;
				
				//year:number of author
				HashMap<String,Integer> yearPublicationMap = new HashMap();

				for(int i = 0;i<listYear.size();i++)	{
					for(int j = 0;j<listAuthor.size();j++)	{

						//s'il a ecrit qlq chose cette annŽe
						nbPublication = xb.get_number_of_books_per_year(file_name,listYear.get(i),listAuthor.get(j));

						if(nbPublication>0)
							cptAuthor ++;
					}	
					nbPublication=0;
					yearPublicationMap.put(listYear.get(i),cptAuthor);
					cptAuthor = 0;
				}
				for(int j = 0;j<listYear.size();j++)
					System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a book this year ="+ yearPublicationMap.get(listYear.get(j)));
			}
		
		@Test
		public void Test_number_of_bookChapter_books_per_year() throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			XMLPublication xb = new XMLPublication();
			List<String> listYear = xb.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = xb.get_list_of_authors_appearancesC(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{
				for(int j = 0;j<listAuthor.size();j++)	{

					//s'il a ecrit qlq chose cette annŽe
					nbPublication = xb.get_number_of_booksChapter_per_year(file_name,listYear.get(i),listAuthor.get(j));

					if(nbPublication>0)
						cptAuthor ++;
				}	
				nbPublication=0;
				yearPublicationMap.put(listYear.get(i),cptAuthor);
				cptAuthor = 0;
			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a book chapter this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
}
