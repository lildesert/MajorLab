package fr.dauphine.publications_analytics.src;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;


public class XMLPublication {

	
	
	public int get_number_of_publicationsA(String file_name) {
		
		return 0;
		
	}
	
	public int get_number_of_publicationsB(String file_name) {
		
		return 1;
		
	}
	
	public int get_number_of_publicationsC(String file_name) {
		
		int number_of_publications = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/* return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_publications = seq.getInt();
	
			System.out.println("Number of publications of is "+number_of_publications);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_publications;
	}
	

	public int get_number_of_author_appearancesA(String file_name) {
		
		return 0;
		
	}
	
	public int get_number_of_author_appearancesB(String file_name) {
		
		return 2;
		
	}
	
	public int get_number_of_author_appearancesC(String file_name) {
		
		int number_of_author_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/*/author return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_author_appearances = seq.getInt();
	
			System.out.println("Number of authors of is "+number_of_author_appearances);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_author_appearances;
		
	}
	
	
	public double get_mean_number_of_authors_per_publicationA(String file_name) {
		
		double mean = 0.0;
		
		return mean;
		
	}
	
	public double get_mean_number_of_authors_per_publicationB(String file_name) {
		
		double mean = 2.0;
		
		return mean;
		
	}
	
	
	public double get_mean_number_of_authors_per_publicationC(String file_name) {
		
		double mean = 0.0;
		
		double num_publications = this.get_number_of_publicationsC(file_name);
		double num_authors = this.get_number_of_author_appearancesC(file_name);
		
		mean = num_authors/num_publications;
		
		return mean;	
	}
	
	public int get_number_of_journal_articles(String file_name) {
		
		int number_of_journal_articles = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/article return 1)";
				
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_journal_articles = seq.getInt();
	
			System.out.println("Number of articles of is "+number_of_journal_articles);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_journal_articles;
		
	}
	
	public int get_number_of_journal_per_author(String file_name, String author) {
		
		int number_of_journal_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/article where $y/author= '" + author + "' return 1)";
				
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_journal_per_author = seq.getInt();
	
			System.out.println("Number of articles per author of is "+number_of_journal_per_author);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_journal_per_author;
		
	}
	
	public int get_number_of_books_per_author(String file_name, String author) {
		
		int number_of_books_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/books where $y/author= '" + author + "' return 1)";
				
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
	
	public int get_number_of_bookchapters_per_author(String file_name, String author) {
		
		int number_of_bookchapters_per_author = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/incollection where $y/author= '" + author + "' return 1)";
				
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
	
	
	
	//David
	public int getNumberOfConferenceProcessing(String fileName) {
		
		int nbConf = 0;

		String xml_file = getClass().getResource(fileName).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/inproceedings return 1)";

		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			nbConf = seq.getInt();

			System.out.println("Number of inprocessing of is "
					+ nbConf);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return nbConf;
	}
	
	public int get_number_of_publication_for_one_author(String file_name, String author) {

		int number_of_publications = 0;

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return count(for $y in $x/* where $y/author='"+ author +"' return 1)";


		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			seq.next();

			number_of_publications = seq.getInt();

			System.out.println("Number of publications of is "
					+ number_of_publications);

			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		return number_of_publications;


	}
	
	public List<String> getAuthor(String file_name) {

		List<String> authors = new ArrayList<String>();

		String xml_file = getClass().getResource(file_name).toExternalForm();

		String query = "for $x in doc(\"" + xml_file + "\")/dblp "
				+ "return distinct-values($x/*/author/text())";


		System.out.println("XQuery query:" + query);

		try {
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();

			XQSequence seq = exp.executeQuery(query);

			while(seq.next())
			{
				authors.add(seq.getItemAsString(null));
			}	
			
			System.out.println("Liste auteurs " + authors);
			seq.close();

		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}

		Collections.sort(authors);
		return authors;

	}
	
	
	
	//Vincent
	public double get_mean_number_of_authors_per_publicationC(String file_name) {
		
		double mean = 0.0;
		
		double num_publications = this.get_number_of_publicationsC(file_name);
		double num_authors = this.get_number_of_author_appearancesC(file_name);
		
		mean = num_authors/num_publications;
		
		return mean;
		
	}
	
public int get_number_of_books_appearancesC(String file_name) {
		
		int number_of_author_appearances = 0;
		
		String xml_file = getClass().getResource(file_name).toExternalForm();
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/book return 1)";
		
		System.out.println("XQuery query:"+query);

		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
	
	
			XQSequence seq = exp.executeQuery(query);			
	
			seq.next();
			
			number_of_author_appearances = seq.getInt();
	
			System.out.println("Number of books of is "+number_of_author_appearances);
			
			seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
		return number_of_author_appearances;
		
	}


public int get_number_of_chapters_appearancesC(String file_name) {
	
	int number_of_author_appearances = 0;
	
	String xml_file = getClass().getResource(file_name).toExternalForm();
	
	String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
			"return count(for $y in $x/incollection return 1)";
	
	System.out.println("XQuery query:"+query);

	try{
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection conn = ds.getConnection();
		XQExpression exp = conn.createExpression();


		XQSequence seq = exp.executeQuery(query);			

		seq.next();
		
		number_of_author_appearances = seq.getInt();

		System.out.println("Number of chapters of is "+number_of_author_appearances);
		
		seq.close();

	} catch (XQException err) {
		System.out.println("Failed as expected: " + err.getMessage());
	}
	
	return number_of_author_appearances;
	
}

public int get_number_of_conferencesProcedings_per_authorsC(String file_name,String author) {
	
	int number_of_author_appearances = 0;
	
	String xml_file = getClass().getResource(file_name).toExternalForm();
	
	String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				" return count(for $y in $x/inproceedings where $y/author= \"" + author +
			"\" return 1)";
	
	System.out.println("XQuery query:"+query);

	try{
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection conn = ds.getConnection();
		XQExpression exp = conn.createExpression();


		XQSequence seq = exp.executeQuery(query);			

		seq.next();
		
		number_of_author_appearances = seq.getInt();

		System.out.println("Number of conference proceedings for the author " + author + " is "+number_of_author_appearances);
		
		seq.close();

	} catch (XQException err) {
		System.out.println("Failed as expected: " + err.getMessage());
	}
	
	return number_of_author_appearances;
	
}
	

public List<String> get_list_of_authors_appearancesC(String file_name) {
		
	String xml_file = getClass().getResource(file_name).toExternalForm();
	
	String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
			"return distinct-values($x/*/author/text())";
	
	System.out.println("XQuery query:"+query);
	
	List<String> listAuthor = new ArrayList();

	try{
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection conn = ds.getConnection();
		XQExpression exp = conn.createExpression();


		XQSequence seq = exp.executeQuery(query);			

		while(seq.next())	{
			listAuthor.add(seq.getItemAsString(null));
		}
		
		System.out.println("Number of authors of is "+ listAuthor.size());
		
		seq.close();

	} catch (XQException err) {
		System.out.println("Failed as expected: " + err.getMessage());
	}
	
	return listAuthor;
}
}
