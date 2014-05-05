package fr.dauphine.publications_analytics.src;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class UserStory4 {

	public int getNumberOfAppearancePerYear(String file_name, String year,
			String name) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ " return distinct-values(for $y in $x/"+name 
				+ " where $y/year = " + year
				+" return $y/author/text())";

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			List<String> authorList = new ArrayList<String>();;
			while(seq.next())
			{
				authorList.add(seq.getAtomicValue());
			}
			seq.close();
			
			number_of_year_appearances = authorList.size();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
			err.printStackTrace();
		}

		return number_of_year_appearances;

	}
}
