import java.util.Random;

import hashTable.*;

public class Task_3_Hash_Table {
	// Creating different types of hash table
	static CuckooHashTable<String> c1 = new CuckooHashTable<>(new StringHashFamily(101));
    static QuadraticProbingHashTable<String> q1 = new QuadraticProbingHashTable<String>();
    static SeparateChainingHashTable<String> s1 = new SeparateChainingHashTable<String>();
    
	public static void main(String[] args) {
		System.out.println("Number\tCuckoo\tQuad\tSeparate\tCuckoo\tQuad\tSeparate");
		System.out.println("\t\tInsert\t\t\t\tSearch\t\t");
		for(int i=1; i<=20; i++) {
			int numberOfStrings = (int) Math.pow(2, i);
			System.out.println(numberOfStrings
					+ "\t" + avgTimeOfInsertion(numberOfStrings, c1)
					+ "\t" + avgTimeOfInsertion(numberOfStrings, q1)
					+ "\t" + avgTimeOfInsertion(numberOfStrings, s1)
					+ "\t\t" + avgTimeOfSearch(numberOfStrings, c1)
					+ "\t" + avgTimeOfSearch(numberOfStrings, q1)
					+ "\t" + avgTimeOfSearch(numberOfStrings, s1));
		}
	}
	
	@SuppressWarnings("unchecked")
	static long avgTimeOfInsertion(int numberOfStrings, Object typeOfHash) {
		// totalInsertionTime is used for computing the total time of inserting records in the hash table
		long totalInsertionTime = 0;
	    // Inserting random strings in the hash table
	    for(int i=0; i<numberOfStrings; i++) {
	    	long startTime = 0, endTime = 0;
	    	String randStr = getRandomString(10);
	    	if(typeOfHash instanceof CuckooHashTable) {
	    		startTime = System.nanoTime();
	    		((CuckooHashTable<String>) typeOfHash).insert(randStr);
		    	endTime = System.nanoTime();
	    	} else if(typeOfHash instanceof QuadraticProbingHashTable) {
	    		startTime = System.nanoTime();
	    		((QuadraticProbingHashTable<String>) typeOfHash).insert(randStr);
		    	endTime = System.nanoTime();
	    	} else {
	    		startTime = System.nanoTime();
	    		((SeparateChainingHashTable<String>) typeOfHash).insert(randStr);
		    	endTime = System.nanoTime();
	    	}
	    	totalInsertionTime += (endTime - startTime);
	    }
	    //return the average time for insertion
		return totalInsertionTime/numberOfStrings;
	}
	
	@SuppressWarnings("unchecked")
	static long avgTimeOfSearch(int numberOfStrings, Object typeOfHash) {
		// totalSearchTime is used for computing the total time of search records in the hash table
		long totalSearchTime = 0;
		// Searching random strings in the hash table
		for(int i=0; i<numberOfStrings; i++) {
			String randStr = getRandomString(10);
			long startTime = 0, endTime = 0;
			boolean searchString = false;
			if(typeOfHash instanceof CuckooHashTable) {
	    		startTime = System.nanoTime();
	    		searchString = ((CuckooHashTable<String>) typeOfHash).contains(randStr);
		    	endTime = System.nanoTime();
		    	if(searchString)
		    		((CuckooHashTable<String>) typeOfHash).remove(randStr);
	    	} else if(typeOfHash instanceof QuadraticProbingHashTable) {
	    		startTime = System.nanoTime();
	    		searchString = ((QuadraticProbingHashTable<String>) typeOfHash).contains(randStr);
		    	endTime = System.nanoTime();
		    	if(searchString)
		    		((QuadraticProbingHashTable<String>) typeOfHash).remove(randStr);
	    	} else {
	    		startTime = System.nanoTime();
	    		searchString = ((SeparateChainingHashTable<String>) typeOfHash).contains(randStr);
		    	endTime = System.nanoTime();
		    	if(searchString)
		    		((SeparateChainingHashTable<String>) typeOfHash).remove(randStr);
	    	}
			totalSearchTime += (endTime - startTime);
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