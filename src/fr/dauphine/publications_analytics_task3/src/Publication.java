package fr.dauphine.publications_analytics_task3.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import fr.dauphine.publications_analytics.src.*;
import net.sf.saxon.xqj.SaxonXQDataSource;

public class Publication {
	

	
	public void Question1ATest(UserStory5 us5) throws Exception {
		
		String file_name = "dblp_curated_sample.xml";
		List<String> listPublication = us5.get_list_of_publications_appearancesC(file_name,"*");
		System.out.print("nombre d'auteur " + listPublication.size());
		HashMap<String, Integer> authorPublicationMap = new HashMap();

		for (int i = 0; i < listPublication.size(); i++) {
			authorPublicationMap.put(listPublication.get(i), us5
					.getNumberOfTaskPerAuthor(file_name,
							listPublication.get(i)));
		}

		for (int j = 0; j < listPublication.size(); j++) 
			System.out.println("Auteur = " + listPublication.get(j)
					+ " Number of publications ="
					+ authorPublicationMap.get(listPublication.get(j)));
	}
	
}
