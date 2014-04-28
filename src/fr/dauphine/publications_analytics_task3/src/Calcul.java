package fr.dauphine.publications_analytics_task3.src;

import java.util.List;

public class Calcul {
	
	public static double mean(List<Double> m) {
	    double sum = 0;
	    for (int i = 0; i < m.size(); i++) {
	        sum += m.get(i);
	    }
	    return sum / m.size();
	}
	
	public static double median(List<Double> m) {
	    int middle = m.size()/2;
	    if (m.size()%2 == 1) {
	        return m.get(middle);
	    } else {
	        return (m.get(middle - 1) + m.get(middle)) / 2.0;
	    }
	}
	
	public static int mode(List<Integer> a) {
	    int maxValue = 0;
	    int maxCount = 0;

	    for (int i = 0; i < a.size(); ++i) {
	        int count = 0;
	        for (int j = 0; j < a.size(); ++j) {
	            if (a.get(j) == a.get(i)) ++count;
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = a.get(i);
	        }
	    }

	    return maxValue;
	}
	
}
