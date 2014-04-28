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
		
		//Vincent Lauren
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
		
	}



