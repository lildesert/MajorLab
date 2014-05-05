package fr.dauphine.publications_analytics.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import fr.dauphine.publications_analytics_task3.src.Year;

public class YearTest {

	@Test
	public void TestPrincipal()
	{
		//String fileName = "dblp_curated_sample.xml";
		String fileName = "dblp_2.xml";
		Question3ATest(fileName);
		Question3BTest(fileName);
		Question3CTest(fileName);
		Question3DTest(fileName);
		Question3ETest(fileName);
		Question4ATest(fileName);
		Question4BTest(fileName);
		Question4CTest(fileName);
		Question4DTest(fileName);
		Question4ETest(fileName);
	}
	
	//Publication
	public void Question4ATest(String fileName) {

		//Arrange
		double meanTest = 72.84848484848484;
		double medianTest = 57.0;
		double modeTest = 3.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Conf Proceed
	public void Question4BTest(String fileName) {

		//Arrange
		double meanTest = 41.27272727272727;
		double medianTest = 44.0;
		double modeTest = 3.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Articles
	public void Question4CTest(String fileName) {

		//Arrange
		double meanTest = 42.121212121212125;
		double medianTest = 15.0;
		double modeTest = 5.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Books
	public void Question4DTest(String fileName) {

		//Arrange
		double meanTest = 0.7575757575757576;
		double medianTest = 7.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//BookChapters
	public void Question4ETest(String fileName) {

		//Arrange
		double meanTest = 2.909090909090909;
		double medianTest = 3.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("mean");
		double medianResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("median");
		double modeResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//3.A
	public void Question3ATest(String fileName) {

		//Arrange
		double meanTest = 1.25;
		double medianTest = 1.0;
		double modeTest = 1.0;
		
		//Act
		double meanResult = Year.getAverageNumberOfPublicationsInAYear(fileName).get("mean");
		double medianResult = Year.getAverageNumberOfPublicationsInAYear(fileName).get("median");
		double modeResult = Year.getAverageNumberOfPublicationsInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//3.B
	public void Question3BTest(String fileName) {

		//Arrange
		double meanTest = 0.25;
		double medianTest = 0.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.getAverageNumberOfpublicationsConferenceInAYear(fileName).get("mean");
		double medianResult = Year.getAverageNumberOfpublicationsConferenceInAYear(fileName).get("median");
		double modeResult = Year.getAverageNumberOfpublicationsConferenceInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}

	//3.C
	public void Question3CTest(String fileName) {

		//Arrange
		double meanTest = 0.5;
		double medianTest = 1.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.getAverageNumberOfJournalArticlesInAYear(fileName).get("mean");
		double medianResult = Year.getAverageNumberOfJournalArticlesInAYear(fileName).get("median");
		double modeResult = Year.getAverageNumberOfJournalArticlesInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//3.D
	public void Question3DTest(String fileName) {

		//Arrange
		double meanTest = 0.25;
		double medianTest = 0.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.getAverageNumberOfBookInAYear(fileName).get("mean");
		double medianResult = Year.getAverageNumberOfBookInAYear(fileName).get("median");
		double modeResult = Year.getAverageNumberOfBookInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//3.E
	public void Question3ETest(String fileName) {

		//Arrange
		double meanTest = 0.25;
		double medianTest = 0.0;
		double modeTest = 0.0;
		
		//Act
		double meanResult = Year.getAverageNumberOfBookChapterInAYear(fileName).get("mean");
		double medianResult = Year.getAverageNumberOfBookChapterInAYear(fileName).get("median");
		double modeResult = Year.getAverageNumberOfBookChapterInAYear(fileName).get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
}
