package loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenKeyword {
	public static String[] generateKeyword(String keyword) {

		ArrayList<String> stopWords = new ArrayList<>();
		String[] filteredKeywords = {};
		String line;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Pujan\\eclipse-workspace\\ACC_SearchEngine_Group_1\\ACC_SearchEngine_Group_1\\stopWords.txt"));

			while ((line = reader.readLine()) != null) {
				stopWords.add(line);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] keywords = keyword.split(" ");
		StringBuilder builder = new StringBuilder();
		for (String word : keywords) {
			word = word.trim();
			if (!stopWords.contains(word)) {
				builder.append(word + "\n");
			}
		}

		filteredKeywords = builder.toString().split("\n").clone();

		return filteredKeywords;

	}


}
