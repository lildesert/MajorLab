package fr.dauphine.publications_analytics.src;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class UserStory1 {

	//Question 1.A
	public int getNumberOfPublications(String file_name) {

		int number_of_publications = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/* return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_publications = seq.getInt();

			System.out.println("Number of publications of is "
					+ number_of_publications);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_publications;
	}

	//Question 1.B
	public int getNumberOfAuthorAppearances(String file_name) {

		int number_of_author_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/*/author return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_author_appearances = seq.getInt();

			System.out.println("Number of authors of is "
					+ number_of_author_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_author_appearances;

	}

	//Question 1.C
	public int getNumberOfConferenceProcessing(String fileName) {

		int nbConf = 0;

		String xml_file = getClass().getResource(fileName).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/inproceedings return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			nbConf = seq.getInt();

			System.out.println("Number of inprocessing of is " + nbConf);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return nbConf;
	}

	//Question 1.D
	public int getNumberOfJournalArticles(String file_name) {

		int number_of_journal_articles = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/article return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_journal_articles = seq.getInt();

			System.out.println("Number of articles of is "
					+ number_of_journal_articles);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_journal_articles;

	}

	// Vincent
	// Question 1.E
	public int getNumberOfBookAppearances(String file_name) {

		int number_of_author_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/book return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_author_appearances = seq.getInt();

			System.out.println("Number of books of is "
					+ number_of_author_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_author_appearances;

	}

	// Vincent
	// Question 1.F
	public int getNumberOfChaptersAppearances(String file_name) {

		int number_of_author_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/incollection return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_author_appearances = seq.getInt();

			System.out.println("Number of chapters of is "
					+ number_of_author_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_author_appearances;

	}

}
