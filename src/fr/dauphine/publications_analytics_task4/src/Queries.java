package fr.dauphine.publications_analytics_task4.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
		
		String query = "for $x in doc(\"" + xml_file + "\")/dblp where $x/*/author = \"" + authorName
				+ "\" return distinct-values($x/*/author/text())";
		
		
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
				String query2 = "for $x in doc(\"" + xml_file + "\")/dblp where $x/*/author = \"" + coauthor
						+ "\" return count(for $y in $x/* where $y/author != \"" +
						coauthor +
						"\" return 1)";
						//"  return distinct-values($x/*/author/text())";
				
				/*List<String> listCocoAuthor = new LinkedList();

				seq2 = exp.executeQuery(query2);
				seq2.next();
				System.out.println("nombre = " + seq2.getInt());
				listAuthor.put(coauthor, listCocoAuthor.size());*/
				System.out.println("Author = " +coauthor );
			}
			seq.close();
			
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return listAuthor;

	}

}
