package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;
import fr.dauphine.publications_analytics.src.UserStory2;
import fr.dauphine.publications_analytics.src.UserStory3;
import fr.dauphine.publications_analytics.src.UserStory4;

public class Year {

	public double GetMeanNumberAuthorForPublicationInAYear(String fileName)
	{
		List<Double> authorForPublication = new LinkedList<Double>();
		
		UserStory2 us2 = new UserStory2();
		UserStory3 us3 = new UserStory3();
		
		List<String> listYear = us3.get_list_of_years_appearancesC(fileName);
		List<String> listAuthor = us2.getAuthor(fileName);
		int cptAuthor = 0,nbPublication=0;
		
		//year:number of author
		HashMap<String,Integer> yearPublicationMap = new HashMap();

		for(int i = 0;i<listYear.size();i++)	{
				//s'il a ecrit qlq chose cette année
				nbPublication = getNumberOfAppearancePerYear(fileName,listYear.get(i),"*");
			
			yearPublicationMap.put(listYear.get(i),nbPublication);

		}
		for(int j = 0;j<listYear.size();j++)
		{
			System.out.println("Année = " + listYear.get(j) + " Number of author who wrote a publication this year ="+ yearPublicationMap.get(listYear.get(j)));
		}
	}
	
	public int getNumberOfAppearancePerYear(String file_name, String year,
			String name) {

		int number_of_year_appearances = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $author in distinct-values(doc(\"" + xml_file
				+ "\")/dblp/*/author) " + " return count(for $x in doc(\""
				+ xml_file + "\")/dblp/" + name
				+ " where $x/author = $author and $x/year = " + year
				+ " return 1)";

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
	
}
