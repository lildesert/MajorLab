package fr.dauphine.publications_analytics.src;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class UserStory5 {
	
	public List<String> get_list_of_publications_appearancesC(String file_name,String typeOfPublication) {
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return distinct-values($x/"+ typeOfPublication + "/title/text())";
		
		System.out.println("XQuery query:"+query);
		
		List<String> listPublication = new ArrayList();

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();


			XQSequence seq = exp.executeQuery(query);			

			while(seq.next())	{
				listPublication.add(seq.getItemAsString(null));
			}
						
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		Collections.sort(listPublication);
		return listPublication;
	}
		
		//Question 2.C
		public List <Integer> getNumberOfTaskPerAuthor(String file_name, String typeOfPublication) {
			
			int number_of_task= 0;
			List <Integer> results = new LinkedList();

			String xml_file = getClass().getResource(file_name).toExternalForm();
			
			String query = "for $x in doc(\"" +xml_file+ "\")/dblp/" + typeOfPublication +
					" return count(for $y in $x/author return 1)";
		
			System.out.println("XQuery query:"+query);

			try{
				XQDataSource ds = new SaxonXQDataSource();
				XQConnection conn = ds.getConnection();
				XQExpression exp = conn.createExpression();
		
		
				XQSequence seq = exp.executeQuery(query);			
		
				while(seq.next())	{
					results.add(seq.getInt()); //getItemAsString(null));
				}
										
				seq.close();
		
			} catch (XQException err) {
				System.out.println("Failed as expected: " + err.getMessage());
			}
			
			return results;
			
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



