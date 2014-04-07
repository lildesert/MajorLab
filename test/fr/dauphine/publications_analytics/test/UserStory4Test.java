package fr.dauphine.publications_analytics.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import fr.dauphine.publications_analytics.src.UserStory4;
import fr.dauphine.publications_analytics.src.UserStory3;
import fr.dauphine.publications_analytics.src.UserStory2;

public class UserStory4Test {
	
	@Test
	public void TestPrincipal() throws Exception
	{
		UserStory4 us4 = new UserStory4();
		UserStory3 us3 = new UserStory3();
		UserStory2 us2 = new UserStory2();
		Question4ATest(us2, us3, us4);
		Question4BTest(us2, us3, us4);
		Question4CTest(us2, us3, us4);
		Question4DTest(us2, us3, us4);
		Question4ETest(us2, us3, us4);
	}

	//@Test
		public void Question4ATest(UserStory2 us2, UserStory3 us3, UserStory4 us4) throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			List<String> listYear = us3.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = us2.getAuthor(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{
					//s'il a ecrit qlq chose cette annŽe
					nbPublication = us4.getNumberOfAppearancePerYear(file_name,listYear.get(i),"*");
				
				yearPublicationMap.put(listYear.get(i),nbPublication);

			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a publication this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
		public void Question4BTest(UserStory2 us2, UserStory3 us3, UserStory4 us4) throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			List<String> listYear = us3.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = us2.getAuthor(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();
			System.out.println("Proceedings");
			for(int i = 0;i<listYear.size();i++)	{


					//s'il a ecrit qlq chose cette annŽe
					nbPublication = us4.getNumberOfAppearancePerYear(file_name,listYear.get(i),"inproceedings");


				yearPublicationMap.put(listYear.get(i),nbPublication);

			}
			System.out.println("Processing ...");
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a conference proceedings this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
		public void Question4CTest(UserStory2 us2, UserStory3 us3, UserStory4 us4) throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			List<String> listYear = us3.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = us2.getAuthor(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{


					//s'il a ecrit qlq chose cette annŽe
					nbPublication = us4.getNumberOfAppearancePerYear(file_name,listYear.get(i),"article");

				yearPublicationMap.put(listYear.get(i),nbPublication);

			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a journal article this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
		
		//@Test
			public void Question4DTest(UserStory2 us2, UserStory3 us3, UserStory4 us4) throws Exception	{
				String file_name = "dblp_curated_sample.xml";
				List<String> listYear = us3.get_list_of_years_appearancesC(file_name);
				List<String> listAuthor = us2.getAuthor(file_name);
				int cptAuthor = 0,nbPublication=0;
				
				//year:number of author
				HashMap<String,Integer> yearPublicationMap = new HashMap();

				for(int i = 0;i<listYear.size();i++)	{

						//s'il a ecrit qlq chose cette annŽe
						nbPublication = us4.getNumberOfAppearancePerYear(file_name,listYear.get(i),"book");

					yearPublicationMap.put(listYear.get(i),nbPublication);
				}
				for(int j = 0;j<listYear.size();j++)
					System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a book this year ="+ yearPublicationMap.get(listYear.get(j)));
			}
		
		public void Question4ETest(UserStory2 us2, UserStory3 us3, UserStory4 us4) throws Exception	{
			String file_name = "dblp_curated_sample.xml";
			List<String> listYear = us3.get_list_of_years_appearancesC(file_name);
			List<String> listAuthor = us2.getAuthor(file_name);
			int cptAuthor = 0,nbPublication=0;
			
			//year:number of author
			HashMap<String,Integer> yearPublicationMap = new HashMap();

			for(int i = 0;i<listYear.size();i++)	{
					//s'il a ecrit qlq chose cette annŽe
					nbPublication = us4.get_number_of_booksChapter_per_year(file_name,listYear.get(i));

				yearPublicationMap.put(listYear.get(i),nbPublication);
			}
			for(int j = 0;j<listYear.size();j++)
				System.out.println("AnnŽe = " + listYear.get(j) + " Number of author who wrote a book chapter this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
}
