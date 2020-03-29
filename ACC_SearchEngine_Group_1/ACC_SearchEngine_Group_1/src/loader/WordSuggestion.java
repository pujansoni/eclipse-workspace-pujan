package loader;

import service.Sequences;

public class WordSuggestion {

	public static String wordSuggestion(String[] input) {

		String suggestedWord = "";
		int eD = 1000;
		int dist;
		String w = null;
		for (String s : input) {
			for (String t : ServletContextClass.words) {
				dist = Sequences.editDistance(s, t);
				if (dist < eD) {
					eD = dist;
					w = t;
				}
			}
			suggestedWord += w + " ";
			eD = 1000;

		}

		return suggestedWord;
	}


}
