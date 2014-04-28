package fr.dauphine.publications_analytics_task3.src;

import java.util.HashMap;
import java.util.List;

public class Calcul {
	
	public static void display(HashMap<String, Double> h){
		System.out.println("Moyenne : " + h.get("mean"));
		System.out.println("Médiane : " + h.get("median"));
		System.out.println("Mode : " + h.get("mode"));
	}
	
	public static HashMap<String, Double> computeAll(List<Integer> l) {
		HashMap<String, Double> h = new HashMap();
		h.put("mean", mean(l));
		h.put("median", median(l));
		h.put("mode", mode(l));
		return h;
	}
	
	public static double mean(List<Integer> m) {
	    double sum = 0;
	    for (int i = 0; i < m.size(); i++) {
	        sum += m.get(i);
	    }
	    return sum / m.size();
	}
	
	public static double median(List<Integer> m) {
	    int middle = m.size()/2;
	    if (m.size()%2 == 1) {
	        return m.get(middle);
	    } else {
	        return (m.get(middle - 1) + m.get(middle)) / 2.0;
	    }
	}
	
	public static double mode(List<Integer> a) {
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
