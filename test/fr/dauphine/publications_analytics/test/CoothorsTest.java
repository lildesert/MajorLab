package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import fr.dauphine.publications_analytics_task4.src.Queries;

public class CoothorsTest {
	@Test
	public void TestPrincipal() throws Exception
	{
		String file_name = "dblp_2.xml";
		Question1Test(file_name);
		Question2Test(file_name);
		Question3Test(file_name);

	}
	
	public void Question1Test(String file_name) throws Exception	{
		HashMap<String, Integer> result = new HashMap();
		Queries queries = new Queries ();
		String author = "Stefano Ceri";
		result = queries.getNumberOfAuthorAppearances(file_name, author);
		System.out.println(result.get("Stefano Ceri"));
		System.out.println("taille = " + result.size());
		//assertEquals(1, result.get("Piero Fraternali"),0);
 
		
	}
	
	public void Question2Test(String file_name) throws Exception	{
		HashMap<String, Integer> result = new HashMap();
		Queries queries = new Queries ();
		String author = "Stefano Ceri";
		result = queries.getNumberOfAuthorAppearancesPerYear(file_name, author, "1997", "1998");
		System.out.println(result.get("Stefano Ceri"));
		System.out.println("taille = " + result.size());
		//assertEquals(1, result.get("Piero Fraternali"),0);
 
		
	}
	
	public void Question3Test(String file_name) throws Exception	{
		HashMap<String, Integer> result = new HashMap();
		Queries queries = new Queries ();
		String author = "Stefano Ceri";
		result = queries.getNumberOfAuthorAppearancesPerPublicationType(file_name, author, "book");
		System.out.println(result.get("Stefano Ceri"));
		System.out.println("taille = " + result.size());
		//assertEquals(1, result.get("Piero Fraternali"),0);
 
		
	}

}
