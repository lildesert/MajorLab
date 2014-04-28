package fr.dauphine.publications_analytics_task3.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class Publication {
	public List<String> getAuthor(String file_name) {

		List<String> authors = new ArrayList<String>();

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return distinct-values($x/*/author/text())";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			while (seq.next()) {
				authors.add(seq.getItemAsString(null));
			}

			System.out.println("Liste auteurs " + authors);
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		Collections.sort(authors);
		return authors;

	}

	// David
	//Question 2.A
	public int getNumberOfAuthorForOnePublication(String file_name,
			String publication) {

		int number_of_authors = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/* where $y/publication=\"" + publication
				+ "\" return 1)";

		//System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_authors = seq.getInt();

			//System.out.println("Number of authors of is "
				//	+ number_of_authors);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_authors;

	}

	// Vincent
	// Question 2.B
	//Pas sur de garder
	/*public double get_mean_number_of_authors_per_publicationC(String file_name) {

		double mean = 0.0;

		double num_publications = this.get_number_of_publicationsC(file_name);
		double num_authors = this.get_number_of_author_appearancesC(file_name);

		mean = num_authors / num_publications;

		return mean;

	}*/

	// Vincent
	// Question 2.B
	public int getNumberOfConferencesProcedingsPerAuthors(
			String file_name, String author) {

		int number_of_author_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\""
				+ xml_file
				+ "\")/dblp "
				+ " return count(for $y in $x/inproceedings where $y/author= \""
				+ author + "\" return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_author_appearances = seq.getInt();

			System.out
					.println("Number of conference proceedings for the author "
							+ author + " is " + number_of_author_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_author_appearances;

	}
	
	//Question 2.C
	public int getNumberOfJournalArticlesPerAuthor(String file_name, String author) {
		
		int number_of_journal_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/article where $y/author= '" + author + "' return 1)";
				
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_journal_per_author = seq.getInt();
	
			System.out.println("Number of articles per author of is "+number_of_journal_per_author);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_journal_per_author;
		
	}
	
	//Question 2.D
	public int getNumberOfBooksPerAuthor(String file_name, String author) {
		
		int number_of_books_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/book where $y/author= \"" + author + "\" return 1)";
				
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_books_per_author = seq.getInt();
	
			System.out.println("Number of books per author of is " + number_of_books_per_author);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_books_per_author;
		
	}
	
	//Question 2.E
	public int getNumberOfBookchaptersPerAuthor(String file_name, String author) {
		
		int number_of_bookchapters_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/incollection where $y/author= \"" + author + "\" return 1)";
				
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_bookchapters_per_author = seq.getInt();
	
			System.out.println("Number of bookchapters per author of is " + number_of_bookchapters_per_author);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_bookchapters_per_author;
		
	}
}
