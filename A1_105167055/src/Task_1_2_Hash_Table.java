import hashTable.QuadraticProbingHashTable;
import java.util.*;

/*
Task 1 :- Within a java class, write a method that creates n random strings of length 10 and inserts them in a hash table. 
The method should compare the average time for each insertion. 
*/

public class Task_1_2_Hash_Table {
	// Creating quadratic probing hash table
    static QuadraticProbingHashTable<String> q1 = new QuadraticProbingHashTable<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice = getUserMenu(sc);
		int x = 0;
		while(true) {
			switch(choice) {
			case 1:
				System.out.println("Please enter the number of Random Strings to generate: ");
				x = sc.nextInt();
				System.out.println("Average time for each insertion is " + avgTimeOfInsertionQuadraticProbing(x) + " nanoseconds");
				break;
			case 2:
				System.out.println("Please enter the number of Random Strings to search HashTable");
				x = sc.nextInt();
				System.out.println("Average time for each search is " + avgTimeOfSearchQuadraticProbing(x) + " nanoseconds");
				break;
			case 3:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
			choice = getUserMenu(sc);
		}
	}
	
	static int getUserMenu(Scanner sc) {
		System.out.println("1. Insert into HashTable\n"
				+ "2. Search and Remove from HashTable\n"
				+ "3. Exit\n"
				+ "Enter your choice: ");
		return sc.nextInt();
	}
	
	static long avgTimeOfInsertionQuadraticProbing(int numberOfStrings) {
		// totalInsertionTime is used for computing the total time of inserting records in the hash table
		long totalInsertionTime = 0;
	    // Inserting random strings in the hash table
	    for(int i=0; i<numberOfStrings; i++) {
	    	long startTime = System.nanoTime();
	    	q1.insert(getRandomString(10));
	    	long endTime = System.nanoTime();
	    	totalInsertionTime += (endTime - startTime);
	    }
	    //return the average time for insertion
		return totalInsertionTime/numberOfStrings;
	}
	
	static long avgTimeOfSearchQuadraticProbing(int numberOfStrings) {
		// totalSearchTime is used for computing the total time of search records in the hash table
		long totalSearchTime = 0;
		// Searching random strings in the hash table
		for(int i=0; i<numberOfStrings; i++) {
			String temp = getRandomString(10);
			long startTime = System.nanoTime();
			boolean searchString = q1.contains(temp);
			long endTime = System.nanoTime();
			totalSearchTime += (endTime - startTime);
			if(searchString)
				q1.remove(temp);
		}
		// return the average time for searching
		return totalSearchTime/numberOfStrings;
	}
	
	static String getRandomString(int stringLength) {
		// lower limit for LowerCase Letters 
	    int lowerLimit = 97; 
	    // lower limit for LowerCase Letters 
	    int upperLimit = 122;
	    Random random = new Random();
	    // Create a StringBuffer to store the result 
	    StringBuffer r = new StringBuffer(stringLength); 
	    for (int i = 0; i < stringLength; i++) { 
	        // take a random value between 97 and 122 
	        int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
	        r.append((char)nextRandomChar); 
	    }
	    // return the resultant string 
	    return r.toString();
	}
}