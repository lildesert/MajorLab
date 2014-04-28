package fr.dauphine.publications_analytics.test;

import junit.framework.*;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.dauphine.publications_analytics_task3.src.Year;

public class YearTest {

	@Test
	public void TestPrincipal()
	{
		String fileName = "dblp_curated_sample.xml";
		
		Question4ATest(fileName);
	}
	
	//Publication
	public void Question4ATest(String fileName) {

		//Arrange
		double meanTest = 6.606060606060606;
		double medianTest = 7.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult);
		assertEquals(medianTest, medianResult);
		assertEquals(modeTest, modeResult);
	}
	
	//Conf Proceed
	public void Question4BTest(String fileName) {

		//Arrange
		double meanTest = 6.606060606060606;
		double medianTest = 7.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult);
		assertEquals(medianTest, medianResult);
		assertEquals(modeTest, modeResult);
	}
	
	//Articles
	public void Question4CTest(String fileName) {

		//Arrange
		double meanTest = 6.606060606060606;
		double medianTest = 7.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult);
		assertEquals(medianTest, medianResult);
		assertEquals(modeTest, modeResult);
	}
	
	//Books
	public void Question4DTest(String fileName) {

		//Arrange
		double meanTest = 6.606060606060606;
		double medianTest = 7.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult);
		assertEquals(medianTest, medianResult);
		assertEquals(modeTest, modeResult);
	}
	
	//BookChapters
	public void Question4ETest(String fileName) {

		//Arrange
		double meanTest = 6.606060606060606;
		double medianTest = 7.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult);
		assertEquals(medianTest, medianResult);
		assertEquals(modeTest, modeResult);
	}
	
}
