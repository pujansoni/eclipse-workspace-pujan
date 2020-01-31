import java.util.*;
import sorting.*;
import java.security.*;

public class Task_3_a_105167055 {
    static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    static final String NUMBER = "0123456789";
    static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	static final int RECORDS = 100000;
	static final int STRING_LEN = 4;
	static String [] randStrArr = new String[RECORDS];
	static Scanner sc = new Scanner(System.in);
	static SecureRandom random = new SecureRandom();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1) Mergesort\n2) Quicksort\n3) Heapsort\n4) dual-pivot Quicksort\n5) Radix sort\n6) Exit");
		System.out.println("Please Enter your choice to sort 100000 random strings each of length 4: ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			sortArray(choice);
			break;
		case 6:
			System.out.println("Exiting...");
			return;
		default:
			System.out.println("Please enter a valid choice.");
		}
	}
	
	static public void sortArray(int choice) {
		long totalTime = 0, startTime = 0, endTime = 0;
		String tempString = "";
		fillArrayRandom();
		if(choice == 1) {
			startTime = System.nanoTime();
			Sort.mergeSort(randStrArr);
			endTime = System.nanoTime();
			tempString = "Mergesort";
		} else if(choice == 2) {
			startTime = System.nanoTime();
			Sort.quicksort(randStrArr);
			endTime = System.nanoTime();
			tempString = "Quicksort";
		} else if(choice == 3) {
			startTime = System.nanoTime();
			Sort.heapsort(randStrArr);
			endTime = System.nanoTime();
			tempString = "Heapsort";
		} else if(choice == 4) {
			startTime = System.nanoTime();
			Arrays.sort(randStrArr);
			endTime = System.nanoTime();
			tempString = "dual-pivot Quicksort";
		} else if(choice == 5) {
			startTime = System.nanoTime();
			RadixSort.radixSortA(randStrArr, STRING_LEN);
			endTime = System.nanoTime();
			tempString = "Radix sort";
		}
		totalTime += (endTime - startTime);
		System.out.println("The average CPU time taken to sort 100000 random Strings each of length "
				+ STRING_LEN + " for " + tempString + " is " + totalTime + " nanoseconds");
	}
	
	public static void fillArrayRandom() {
		for(int i=0; i<RECORDS; i++) {
			randStrArr[i] = generateRandomString();
		}
	}
	
	public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(STRING_LEN);
        for (int i=0; i<STRING_LEN; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
