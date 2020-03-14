/**
 * 
 * @author pujan
 * Use classes BruteForceMatch, BoyerMoore and KMP provided in the source code.
 *		a. Download file Hard disk.txt from the Resources.
 *		b. Find all occurrences of patterns “hard”, “disk”, “hard disk”, “hard drive”, 
 *		   “hard dist” and “xltpru”, and show the offsets.
 *		c. Repeat (b) 100 times and record the average CPU time for each case.
 *		d. Compare the CPU times with the running times of the three algorithms 
 *	 	   (discussed in class) and comment on asymptotic running time of the corresponding algorithms.
 *
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import textprocessing.*;

public class Task_1_105167055 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Please select an option to find all occurences of the given string: ");
			System.out.println("1. 'hard'");
			System.out.println("2. 'disk'");
			System.out.println("3. 'hard disk'");
			System.out.println("4. 'hard drive'");
			System.out.println("5. 'hard dist'");
			System.out.println("6. 'xltpru'");
			System.out.println("7. exit");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				findPattern("hard");
				break;
			case 2:
				findPattern("disk");
				break;
			case 3:
				findPattern("hard disk");
				break;
			case 4:
				findPattern("hard drive");
				break;
			case 5:
				findPattern("hard dist");
				break;
			case 6:
				findPattern("xltpru");
				break;
			case 7:
				System.out.println("Exiting");
				System.exit(0);;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	public static void findPattern(String pattern) throws Exception {
		bruteForceSearch(pattern);
		boyerMooreSearch(pattern);
		KMPSearch(pattern);
	}
	
	public static void bruteForceSearch(String pattern) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Pujan\\eclipse-workspace\\Text Processing\\textprocessing\\Hard disk.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		int characterCount = 0;
		int offset1a = 0;
		double startTime = 0.0, endTime = 0.0, totalTime = 0.0;
		ArrayList<Integer> offset = new ArrayList<Integer>();
		String line = reader.readLine();
		while (line != null) {
			characterCount += line.length();
			for (int i = 0; i < 100; i++) {
				startTime = System.currentTimeMillis();
				offset1a = BruteForceMatch.search1(pattern, line);
				endTime = System.currentTimeMillis();
				totalTime += (endTime - startTime);
			}
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		if (offset.isEmpty()) {
			offset.add(characterCount);
			System.out.println("Brute Force Search Pattern: " + pattern + ", Offset: " + offset + " (Could not find the pattern!)");
		} else {
			System.out.println("Brute Force Search Pattern: " + pattern + ", Offset: " + offset);
		}
		System.out.println("Brute Force Search Pattern CPU Time: " + totalTime + " milliseconds");
		offset.clear();
	}
	
	public static void boyerMooreSearch(String pattern) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Pujan\\eclipse-workspace\\Text Processing\\textprocessing\\Hard disk.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		int characterCount = 0;
		int offset1a = 0;
		double startTime = 0.0, endTime = 0.0, totalTime = 0.0;
		ArrayList<Integer> offset = new ArrayList<Integer>();
		BoyerMoore boyer = new BoyerMoore(pattern);
		String line = reader.readLine();
		while (line != null) {
			characterCount += line.length();
			for (int i = 0; i < 100; i++) {
				startTime = System.currentTimeMillis();
				offset1a = boyer.search(line);
				endTime = System.currentTimeMillis();
				totalTime += (endTime - startTime);
			}
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		if (offset.isEmpty()) {
			offset.add(characterCount);
			System.out.println("Boyer Moore Search Pattern: "+ pattern + ", Offset: " + offset + " (Could not find the pattern!)");
		} else {
			System.out.println("Boyer Moore Search Pattern: "+ pattern + ", Offset: " + offset);
		}
		System.out.println("Boyer Moore Search Pattern CPU Time: " + totalTime + " milliseconds");
		offset.clear();
	}
	
	public static void KMPSearch(String pattern) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Pujan\\eclipse-workspace\\Text Processing\\textprocessing\\Hard disk.txt");
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		int characterCount = 0;
		int offset1a = 0;
		double startTime = 0.0, endTime = 0.0, totalTime = 0.0;
		ArrayList<Integer> offset = new ArrayList<Integer>();
		KMP kmp = new KMP(pattern);
		String line = reader.readLine();
		while (line != null) {
			characterCount += line.length();
			for (int i = 0; i < 100; i++) {
				startTime = System.currentTimeMillis();
				offset1a = kmp.search(line);
				endTime = System.currentTimeMillis();
				totalTime += (endTime - startTime);
			}
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		if (offset.isEmpty()) {
			offset.add(characterCount);
			System.out.println("KMP Search Pattern: "+ pattern + ", Offset: " + offset + " (Could not find the pattern!)");
		} else {
			System.out.println("KMP Search Pattern: "+ pattern + ", Offset: " + offset);
		}
		System.out.println("KMP Search Pattern CPU Time: " + totalTime + " milliseconds");
		offset.clear();
	}
}
