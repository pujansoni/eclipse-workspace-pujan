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
				findPattern("hard", 1);
				findPattern("hard", 2);
				findPattern("hard", 3);
				break;
			case 2:
				findPattern("disk", 1);
				findPattern("disk", 2);
				findPattern("disk", 3);
				break;
			case 3:
				findPattern("hard disk", 1);
				findPattern("hard disk", 2);
				findPattern("hard disk", 3);
				break;
			case 4:
				findPattern("hard drive", 1);
				findPattern("hard drive", 2);
				findPattern("hard drive", 3);
				break;
			case 5:
				findPattern("hard dist", 1);
				findPattern("hard dist", 2);
				findPattern("hard dist", 3);
				break;
			case 6:
				findPattern("xltpru", 1);
				findPattern("xltpru", 2);
				findPattern("xltpru", 3);
				break;
			case 7:
				System.out.println("Exiting");
				System.exit(0);;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	public static void findPattern(String pattern, Integer searchAlgo) throws Exception {
		FileInputStream fis = null;
		BufferedReader reader = null;
		try {
			fis = new FileInputStream("C:\\Users\\Pujan\\eclipse-workspace\\Text Processing\\textprocessing\\Hard disk.txt");
			reader = new BufferedReader(new InputStreamReader(fis));
			if (searchAlgo == 1) {
				bruteForceSearch(pattern, reader);
			}
			if (searchAlgo == 2) {
				boyerMooreSearch(pattern, reader);
			}
			if (searchAlgo == 3) {
				KMPSearch(pattern, reader);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			reader.close();
			fis.close();
		}
	}
	
	public static void bruteForceSearch(String pattern, BufferedReader reader) throws Exception {
		ArrayList<Integer> offset = new ArrayList<Integer>();
		int offset1a = 0;
		String line = reader.readLine();
		while (line != null) {
			for (int i = 0; i < 100; i++) {
				offset1a = BruteForceMatch.search1(pattern, line);
			}
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		if (offset.isEmpty()) {
			
		}
		System.out.println("Brute Force Search Pattern: "+ pattern + ", Offset: " + offset);
		offset.clear();
	}
	
	public static void boyerMooreSearch(String pattern, BufferedReader reader) throws Exception {
		ArrayList<Integer> offset = new ArrayList<Integer>();
		BoyerMoore boyer = new BoyerMoore(pattern);
		int offset1a;
		String line = reader.readLine();
		while (line != null) {
			offset1a = boyer.search(line);
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		System.out.println("Boyer Moore Search Pattern: "+ pattern + ", Offset: " + offset);
		offset.clear();
	}
	
	public static void KMPSearch(String pattern, BufferedReader reader) throws Exception {
		ArrayList<Integer> offset = new ArrayList<Integer>();
		KMP kmp = new KMP(pattern);
		int offset1a;
		String line = reader.readLine();
		while (line != null) {
			offset1a = kmp.search(line);
			if (offset1a != line.length()) {
				offset.add(offset1a);
			}
			line = reader.readLine();
		}
		System.out.println("KMP Search Pattern: "+ pattern + ", Offset: " + offset);
		offset.clear();
	}
}
