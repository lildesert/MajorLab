package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fr.dauphine.publications_analytics.src.UserStory3;
import fr.dauphine.publications_analytics.src.UserStory4;

public class Year {

	public static HashMap<String, Double> GetAverageNumberAuthorForPublicationInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> authorForPublication = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		UserStory4 us4 = new UserStory4();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		int nbAuth = 0;
		
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)
		{
			nbAuth = us4.getNumberOfAppearancePerYear(fileName,listYear.get(i),"*");
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
	public static HashMap<String, Double> GetAverageNumberAuthorForConfProceedInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> authorForPublication = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		UserStory4 us4 = new UserStory4();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		int nbAuth = 0;
		
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)
		{
			nbAuth = us4.getNumberOfAppearancePerYear(fileName,listYear.get(i),"inproceedings");
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
	public static HashMap<String, Double> GetAverageNumberAuthorForArticlesInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> authorForPublication = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		UserStory4 us4 = new UserStory4();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		int nbAuth = 0;
		
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)
		{
			nbAuth = us4.getNumberOfAppearancePerYear(fileName,listYear.get(i),"article");
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
	public static HashMap<String, Double> GetAverageNumberAuthorForBooksInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> authorForPublication = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		UserStory4 us4 = new UserStory4();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		int nbAuth = 0;
		
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)
		{
			nbAuth = us4.getNumberOfAppearancePerYear(fileName,listYear.get(i),"book");
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
	public static HashMap<String, Double> GetAverageNumberAuthorForBookChaptersInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> authorForPublication = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		UserStory4 us4 = new UserStory4();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		int nbAuth = 0;
		
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)
		{
			nbAuth = us4.get_number_of_booksChapter_per_year(fileName, listYear.get(i));
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
}
