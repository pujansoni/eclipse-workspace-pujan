/**
 * 
 * @author pujan
 *
 *	Download file Protein.txt from the Resources. Using class TST provided in the source code:
 *		a. Write a program that reads file “Protein.txt” and creates a trie using TST. 
 *		   Use StringTokenizer, Jsoup or a similar API to extract the words from the file.
 *		b. Do several searches of keys “protein”, “complex”, “PPI”, “prediction”, and others,
 *		   and show the occurrences of these words in file Protein.txt
 *
 */

import java.util.ArrayList;
import textprocessing.In;
import textprocessing.StdOut;
import textprocessing.TST;

public class Task_2_105167055 {
	// ArrayList of words to store the words from the Protein.txt file
	static ArrayList<String> words = new ArrayList<String>();
	
	// Words we will search in the Protein.txt file
	static String[] keys = { "Protein", "complex", "PPI", "prediction", "characterization", "server", "information", "interface" };
	
	static In file = new In("Protein.txt");
	
	static int count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		fileToWord();
		buildTableAndPrintResults();
        countWordOccurences();
	}
	
	public static void fileToWord() {
		// Splitting the file into a List of words
		String[] parts = file.readAll().split("[\\p{Punct}\\s]+");
		for(String part : parts) {
			words.add(part);
		}
	}
	
	public static void buildTableAndPrintResults() {
		// build symbol table from standard input
        TST<Integer> tst = new TST<Integer>();
        for (int i = 0; i < keys.length; i++) {
            //String key = In.readString();
            tst.put(keys[i], i);
        }
	
        // print results
        if (tst.size() < 100) {
            StdOut.println("keys(\"\"):");
            for (String key : tst.keys()) {
                StdOut.println(key + " " + tst.get(key));
            }
            StdOut.println();
        }
	}
	
	public static void countWordOccurences() {
		// Count Words occurences in words ArrayList
		for (int k = 0; k < keys.length; k++) {
			count = 0;
			for (int i = 0; i < words.size(); i++) {
				// Check if ArrayList contains the Key
				if (words.get(i).contains(keys[k])) {
					count++;
				}
			}
			System.out.printf("Occurence of word %s is: %d\n", keys[k], count);
		}
	}
}