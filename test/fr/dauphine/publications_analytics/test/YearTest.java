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
		double meanTest = 4.75; //72.84848484848484
		double medianTest = 4.5; //57.0
		double modeTest = 3.0; //3.0
		
		//Act
		HashMap<String, Double> mapResult = Year.GetAverageNumberAuthorForPublicationInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Conf Proceed
	public void Question4BTest(String fileName) {

		//Arrange
		double meanTest = 1.75; //41.27272727272727
		double medianTest = 0.0; //44.0
		double modeTest = 0.0; //3.0
		
		//Act
		HashMap<String, Double> mapResult = Year.GetAverageNumberAuthorForConfProceedInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Articles
	public void Question4CTest(String fileName) {

		//Arrange
		double meanTest = 2.25; //42.121212121212125
		double medianTest = 4.5; //15.0
		double modeTest = 0.0; //5.0
		
		//Act
		HashMap<String, Double> mapResult = Year.GetAverageNumberAuthorForArticlesInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//Books
	public void Question4DTest(String fileName) {

		//Arrange
		double meanTest = 0.5; //0.7575757575757576
		double medianTest = 0.0; //7.0
		double modeTest = 0.0;
		
		//Act
		HashMap<String, Double> mapResult = Year.GetAverageNumberAuthorForBooksInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
	//BookChapters
	public void Question4ETest(String fileName) {

		//Arrange
		double meanTest = 0.5; //2.909090909090909
		double medianTest = 0.0; //3.0
		double modeTest = 0.0; //0.0
		
		//Act
		HashMap<String, Double> mapResult = Year.GetAverageNumberAuthorForBookChaptersInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
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
		HashMap<String, Double> mapResult = Year.getAverageNumberOfPublicationsInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
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
		HashMap<String, Double> mapResult = Year.getAverageNumberOfpublicationsConferenceInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
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
		HashMap<String, Double> mapResult = Year.getAverageNumberOfJournalArticlesInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
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
		HashMap<String, Double> mapResult = Year.getAverageNumberOfBookInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
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
		HashMap<String, Double> mapResult = Year.getAverageNumberOfBookChapterInAYear(fileName);
		double meanResult = mapResult.get("mean");
		double medianResult = mapResult.get("median");
		double modeResult = mapResult.get("mode");
		
		//Assert
		assertEquals(meanTest, meanResult, 0);
		assertEquals(medianTest, medianResult, 0);
		assertEquals(modeTest, modeResult, 0);
	}
	
}
