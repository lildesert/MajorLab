package fr.dauphine.publications_analytics.src;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class UserStory4 {
	// Question 4.A
	public int get_number_of_publications_per_year(String file_name,
			String year, String author) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ " return count(for $y in $x/* where $y/year= \"" + year
				+ "\" and $y/author = \"" + author + "\" return 1)";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_year_appearances = seq.getInt();

			// System.out.println("Number of publications for the year " + year
			// + " is "+number_of_year_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_year_appearances;

	}

	// Question 4.B
	public int get_number_of_conferenceProceedings_per_year(String file_name,
			String year, String author) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ " return count(for $y in $x/inproceedings where $y/year= \""
				+ year + "\" and $y/author = \"" + author + "\" return 1)";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_year_appearances = seq.getInt();

			// System.out.println("Number of publications for the year " + year
			// + " is "+number_of_year_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_year_appearances;

	}

	// Question 4.C
	public int get_number_of_articles_per_year(String file_name, String year,
			String author) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ " return count(for $y in $x/article where $y/year= \"" + year
				+ "\" and $y/author = \"" + author + "\" return 1)";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_year_appearances = seq.getInt();

			// System.out.println("Number of publications for the year " + year
			// + " is "+number_of_year_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_year_appearances;

	}

	// Question 4.D
	public int get_number_of_books_per_year(String file_name, String year,
			String author) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ " return count(for $y in $x/book where $y/year= \"" + year
				+ "\" and $y/author = \"" + author + "\" return 1)";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_year_appearances = seq.getInt();

			// System.out.println("Number of publications for the year " + year
			// + " is "+number_of_year_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_year_appearances;

	}

	// Question 4.E
	public int get_number_of_booksChapter_per_year(String file_name, String year) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $author in distinct-values(doc(\""
				+ xml_file
				+ "\")/dblp/*/author) "
				+ " return count(for $x in doc(\""
				+ xml_file
				+ "\")/dblp/incollection where $x/author = $author and $x/year = "
				+ year + " return 1)";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_year_appearances = seq.getInt();

			// System.out.println("Number of publications for the year " + year
			// + " is "+number_of_year_appearances);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_year_appearances;

	}

	public int getNumberOfAppearancePerYear(String file_name, String year,
			String name) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

//		String query = "for $author in distinct-values(doc(\"" + xml_file + "\")/dblp/*/author)" 
//				+ " return count(for $x in doc(\"" + xml_file + "\")/dblp/" + name
//				+ " where $x/author = $author and $x/year = " + year
//				+ " return 1)";
		
		String query = "for $author in distinct-values(doc(\"" + xml_file + "\")/dblp/*/author)" 
				+ " where doc(\"" + xml_file + "\")/dblp/*/year = " + year
				+ " return $author";
		
		//http://stackoverflow.com/questions/14030255/xquery-group-by-and-count

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			while(seq.next())
			{
				String author = seq.getAtomicValue();
				//number_of_year_appearances = seq.getInt();
			}
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
			err.printStackTrace();
		}

		return number_of_year_appearances;

	}
}
