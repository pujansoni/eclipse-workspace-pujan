import java.util.*;
import hashTable.*;
import heaps.*;

/*
Task 1 :- Within a java class, write a method that creates n random strings of length 10 and inserts them in a hash table. 
The method should compare the average time for each insertion. 
*/

public class Task_1_Hash_Table_Insertion {
	
	static String getRandomString(int lengthOfRandomString) {
		// lower limit for LowerCase Letters 
        int lowerLimit = 97; 
        // lower limit for LowerCase Letters 
        int upperLimit = 122;
        Random random = new Random(); 
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(lengthOfRandomString); 
        for (int i = 0; i < lengthOfRandomString; i++) { 
            // take a random value between 97 and 122 
            int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar); 
        } 
        // return the resultant string 
        return r.toString(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of Random Strings to generate: ");
		int x = sc.nextInt();
	    Hashtable<Integer, String> h1 = new Hashtable<>();	// Created Hashtable
	    //Add mappings to the Hashtable
		for(int i=0; i<x; i++) {
			h1.put(i, getRandomString(10));
		}
		System.out.println(h1);
	}

}