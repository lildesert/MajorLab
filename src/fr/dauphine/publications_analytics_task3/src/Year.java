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
			nbAuth = us4.getNumberOfAppearancePerYear(fileName,listYear.get(i),"incollection");
			authorForPublication.add(nbAuth);
		}
		
		result.put("mean", Calcul.mean(authorForPublication));
		result.put("median", Calcul.median(authorForPublication));
		result.put("mode", Calcul.mode(authorForPublication));
		
		return result;
	}
	
		//Vincent Lauren
	public static HashMap<String, Double> getAverageNumberOfPublicationsInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> publicationForYear = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		
		for(int i = 0;i<listYear.size();i++)
		{
			publicationForYear.add(us3.get_number_of_publications_per_year(fileName,listYear.get(i)));
		}
		
		result.put("mean", Calcul.mean(publicationForYear));
		result.put("median", Calcul.median(publicationForYear));
		result.put("mode", Calcul.mode(publicationForYear));
		
		return result;
	}
	
	public static HashMap<String, Double> getAverageNumberOfpublicationsConferenceInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> confpublicationForYear = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		
		for(int i = 0;i<listYear.size();i++)
		{
			confpublicationForYear.add(us3.get_number_of_publicationsConference_per_year(fileName,listYear.get(i)));
		}
		
		result.put("mean", Calcul.mean(confpublicationForYear));
		result.put("median", Calcul.median(confpublicationForYear));
		result.put("mode", Calcul.mode(confpublicationForYear));
		
		return result;
	}
	
	public static HashMap<String, Double> getAverageNumberOfJournalArticlesInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> journalArticleForYear = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		
		for(int i = 0;i<listYear.size();i++)
		{
			journalArticleForYear.add(us3.get_number_of_journalArticles_per_year(fileName,listYear.get(i)));
		}
		
		result.put("mean", Calcul.mean(journalArticleForYear));
		result.put("median", Calcul.median(journalArticleForYear));
		result.put("mode", Calcul.mode(journalArticleForYear));
		
		return result;
	}

	public static HashMap<String, Double> getAverageNumberOfBookInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> bookForYear = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		
		for(int i = 0;i<listYear.size();i++)
		{
			bookForYear.add(us3.get_number_of_book_per_year(fileName,listYear.get(i)));
		}
		
		result.put("mean", Calcul.mean(bookForYear));
		result.put("median", Calcul.median(bookForYear));
		result.put("mode", Calcul.mode(bookForYear));
		
		return result;
	}
	

	public static HashMap<String, Double> getAverageNumberOfBookChapterInAYear(String fileName)
	{
		HashMap<String, Double> result = new HashMap<String, Double>();
		List<Integer> chapterbookForYear = new LinkedList<Integer>();
		
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		
		for(int i = 0;i<listYear.size();i++)
		{
			chapterbookForYear.add(us3.get_number_of_book_per_year(fileName,listYear.get(i)));
		}
		
		result.put("mean", Calcul.mean(chapterbookForYear));
		result.put("median", Calcul.median(chapterbookForYear));
		result.put("mode", Calcul.mode(chapterbookForYear));
		
		return result;
	}
	
}
