package fr.dauphine.publications_analytics.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class UserStory3 {

	//Question 3
	public List<String> get_list_of_years_appearancesC(String file_name) {
			
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return distinct-values($x/*/year/text())";
		
		System.out.println("XQuery query:"+query);
		
		List<String> listYear = new ArrayList();

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			while(seq.next())	{
				listYear.add(seq.getItemAsString(null));
			}
			
			System.out.println("Number of years of is "+ listYear.size());
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		Collections.sort(listYear);
		return listYear;
	}

	//Vincent
	//Question 3.A
	public int get_number_of_publications_per_year(String file_name,String year) {
		
		int number_of_year_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
					" return count(for $y in $x/* where $y/year= \"" + year +
				"\" return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();
			
			number_of_year_appearances = seq.getInt();

			System.out.println("Number of publications for the year " + year + " is "+number_of_year_appearances);
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_year_appearances;
		
	}

	//Vincent
	//Question 3.B
	public int get_number_of_publicationsConference_per_year(String file_name,String year) {
		
		int number_of_year_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
					" return count(for $y in $x/inproceedings where $y/year= \"" + year +
				"\" return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();
			
			number_of_year_appearances = seq.getInt();

			System.out.println("Number of publications proceedings for the year " + year + " is "+number_of_year_appearances);
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_year_appearances;
		
	}

	//Vincent
	//Question 3.C
	public int get_number_of_journalArticles_per_year(String file_name,String year) {
		
		int number_of_year_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
					" return count(for $y in $x/article where $y/year= \"" + year +
				"\" return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();
			
			number_of_year_appearances = seq.getInt();

			System.out.println("Number of journal articles for the year " + year + " is "+number_of_year_appearances);
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_year_appearances;
		
	}

	//Vincent
	//Question 3.D
	public int get_number_of_book_per_year(String file_name,String year) {
		
		int number_of_year_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
					" return count(for $y in $x/book where $y/year= \"" + year +
				"\" return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();
			
			number_of_year_appearances = seq.getInt();

			System.out.println("Number of book for the year " + year + " is "+number_of_year_appearances);
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_year_appearances;
		
	}

	//Vincent
	//Question 3.E
	public int get_number_of_chapter_per_year(String file_name,String year) {
		
		int number_of_year_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
					" return count(for $y in $x/incollection where $y/year= \"" + year +
				"\" return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			seq.next();
			
			number_of_year_appearances = seq.getInt();

			System.out.println("Number of incollection for the year " + year + " is "+number_of_year_appearances);
			
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_year_appearances;
		
	}
}
