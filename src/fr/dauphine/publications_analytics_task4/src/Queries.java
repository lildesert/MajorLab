package fr.dauphine.publications_analytics_task4.src;

import java.util.HashMap;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class Queries {
	//Question 1
	public HashMap<String, Integer> getNumberOfAuthorAppearances(String file_name,String authorName) {

		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" + xml_file + "\")/dblp where $x/author = " + authorName
				+ " return distinct-values(for $y in $x/author where $y/author != " + authorName 
				+" return $y/author/text())";
		
		System.out.println("XQuery query:" + query);
		HashMap<String, Integer> listAuthor = new HashMap();

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			XQSequence seq = exp.executeQuery(query);
			
			XQExpression exp2 = conn.createExpression();
			XQSequence seq2;
			
			while(seq.next())	{
			
				String query2 = "for $x in doc(\"" + xml_file + "\")/dblp where $x/author = " + seq.getAtomicValue()
						+ " return distinct-values(for $y in $x/author "
						+ " return $y/author/text())";
				seq2 = exp.executeQuery(query2);
				listAuthor.put(seq.getAtomicValue(), seq2.count());
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return listAuthor;

	}

}
