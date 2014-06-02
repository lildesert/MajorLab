package fr.dauphine.publications_analytics_task4.src;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import UI.UISingleton;
import net.sf.saxon.xqj.SaxonXQDataSource;

public class Queries {
	
	private HashMap<String, Integer> display(HashMap<String, Integer> listAuthors, String authorName){
		System.out.println(authorName + " (" + listAuthors.get(authorName) + ") : ");
		for (Entry<String, Integer> e : listAuthors.entrySet()) {
		    String key = e.getKey();
		    Object value = e.getValue();
		    if (!key.equals(authorName) ){
		    	System.out.println(e.getKey() + " (" + e.getValue() + ")");
		    }
		}	
		return listAuthors;
	}
	
	//Question 1
	public HashMap<String, Integer> getNumberOfAuthorAppearances(String file_name,String authorName) {

		String xml_file = "";
		try {
			xml_file = UISingleton.getInstance().getXmlFile().toURI().toURL().toExternalForm();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException pe) {
			xml_file = getClass().getResource(file_name).toExternalForm();
		}
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
		"return distinct-values(for $y in $x/* where $y/author= \"" + authorName + 
		"\" return $y/author/text())";
		
		
		System.out.println("XQuery query:" + query);
		HashMap<String, Integer> listAuthor = new HashMap();

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQSequence seq = exp.executeQuery(query);
			
			XQExpression exp2 = conn.createExpression();
			XQSequence seq2;
			String coauthor;
			while(seq.next())	{
				coauthor = seq.getAtomicValue();
				String query2 = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
						"return count(distinct-values(for $y in $x/* where $y/author= \"" + coauthor + 
						"\" return $y/author/text()))";				
				List<String> listCocoAuthor = new LinkedList();

				seq2 = exp.executeQuery(query2);
				seq2.next();
				listAuthor.put(coauthor, seq2.getInt()-1);
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return display(listAuthor, authorName);

	}
	
	//Question 2
	public HashMap<String, Integer> getNumberOfAuthorAppearancesPerYear(String file_name,String authorName, String year1, String year2) {
		String query ="";
		String xml_file = "";
		try {
			xml_file = UISingleton.getInstance().getXmlFile().toURI().toURL().toExternalForm();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException pe) {
			xml_file = getClass().getResource(file_name).toExternalForm();
		}
		if(year1 == year2){
			 query = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
			"return distinct-values(for $y in $x/* where $y/author= \"" + authorName + "\" and $y/year= \"" + year1 + 
			"\" return $y/author/text())";}
		else{
			query = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
				"return distinct-values(for $y in $x/* where $y/author= \"" + authorName + "\" and $y/year >= \"" + year1 
				+ 
				"\" and $y/year <= \"" + year2 + 
				"\" return $y/author/text())";}
		
		
		System.out.println("XQuery query:" + query);
		HashMap<String, Integer> listAuthor = new HashMap();

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQSequence seq = exp.executeQuery(query);
			
			XQExpression exp2 = conn.createExpression();
			XQSequence seq2;
			String coauthor;
			while(seq.next())	{
				coauthor = seq.getAtomicValue();
				String query2 = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
						"return count(distinct-values(for $y in $x/* where $y/author= \"" + coauthor + 
						"\" return $y/author/text()))";				
				List<String> listCocoAuthor = new LinkedList();

				seq2 = exp.executeQuery(query2);
				seq2.next();
				listAuthor.put(coauthor, seq2.getInt()-1);
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return display(listAuthor, authorName);

	}
	
	//Question 3
	//See names of the co authors for each author in the publication set for different publication types (par publication type)
	public HashMap<String, Integer> getNumberOfAuthorAppearancesPerPublicationType(String file_name,String authorName, String type) {
		String xml_file = "";
		try {
			xml_file = UISingleton.getInstance().getXmlFile().toURI().toURL().toExternalForm();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException pe) {
			xml_file = getClass().getResource(file_name).toExternalForm();
		}

		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
				"return distinct-values(for $y in $x/" + type + " where $y/author= \"" + authorName + 
				"\" return $y/author/text())";
			 
		
		
		System.out.println("XQuery query:" + query);
		HashMap<String, Integer> listAuthor = new HashMap();

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQSequence seq = exp.executeQuery(query);
			
			XQExpression exp2 = conn.createExpression();
			XQSequence seq2;
			String coauthor;
			while(seq.next())	{
				coauthor = seq.getAtomicValue();
				String query2 = "for $x in doc(\"" +xml_file+ "\")/dblp " + 
						"return count(distinct-values(for $y in $x/* where $y/author= \"" + coauthor + 
						"\" return $y/author/text()))";				
				List<String> listCocoAuthor = new LinkedList();

				seq2 = exp.executeQuery(query2);
				seq2.next();
				listAuthor.put(coauthor, seq2.getInt()-1);
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return display(listAuthor, authorName);

	}
	
	// Visualize 
	

}
