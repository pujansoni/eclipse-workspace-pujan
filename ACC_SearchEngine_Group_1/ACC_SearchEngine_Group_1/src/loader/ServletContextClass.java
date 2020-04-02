package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import service.Sequences;
import service.TST;

public class ServletContextClass implements ServletContextListener {

	public static String htmlPath = "C:\\Users\\Pujan\\eclipse-workspace\\ACC_SearchEngine_Group_1\\ACC_SearchEngine_Group_1\\HTML_Files";
	public static String textPath = "C:\\Users\\Pujan\\eclipse-workspace\\ACC_SearchEngine_Group_1\\ACC_SearchEngine_Group_1\\Text_Files\\";
	public static ArrayList<TST<Integer>> myTST = new ArrayList<>();
	public static Set<String> words = new HashSet<>();
	private static String[] myHTMLFiles;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextDestroyed Called..");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		System.out.println("Inside Initializer..");
		
		File myFolder = new File(htmlPath);
		myHTMLFiles = myFolder.list();
		System.out.println(htmlPath);
		// Converting html to text
		// long s = System.currentTimeMillis();
		// HTMLtoText.htmlToText(myHTMLFiles);
		// long e = System.currentTimeMillis();
		// System.out.println(e-s);

		// reading text folder
		myFolder = new File(textPath);
		String[] files = myFolder.list();

		// reading each text files
		for (String f : files) {	

			TST<Integer> tst = new TST<>();
			String[] tokens = Tokenizer.textTokenizing(f);

			// storing the tokens into TST
			for (int i = 0; i < tokens.length; i++) {
				// Calculating frequency of word and storing it as value in
				// TST.(taking more Time)
				String temp = tokens[i].replaceAll("[^a-zA-Z]", "");
				words.add(temp);
				if (temp.length() > 0) {
					if (tst.contains(temp)) {
						tst.put(temp, tst.get(temp) + 1);
					} else {
						tst.put(temp, 1);
					}
				}
			}
			myTST.add(tst);
		}
		System.out.println("Pre-processed Data!");
	}

	public static List<String> finalCall(String input) {
		String searchWord = input.toLowerCase();
		String[] keywords = GenKeyword.generateKeyword(searchWord);
		String sw = WordSuggestion.wordSuggestion(keywords);
		if (sw.trim().equals(String.join(" ", keywords))) {
			sw = "";
		}

		List<String> result = new ArrayList<>();
		result.add(sw);
		int[][] f = FastFind.search(keywords);
		Arrays.sort(f, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				if (entry1[0] < entry2[0])
					return 1;
				else
					return -1;
			}
		});
		
		for (int i = 0; i < f.length; i++) {
			int index = f[i][1];
			if(f[i][0] == 0) {
				break;
			}
			// System.out.println(myHTMLFiles[index]);
			result.add(myHTMLFiles[index]);
		}
		return result;
	}
}
