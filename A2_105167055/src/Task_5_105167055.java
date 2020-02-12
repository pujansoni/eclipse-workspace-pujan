import java.security.SecureRandom;
import java.util.*;
import algorithmDesign.*;

public class Task_5_105167055 {
    static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    static final String NUMBER = "0123456789";
    static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
	static final int RECORDS = 1000;
	static Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
	static String [] randStrArr = new String[RECORDS];
	static Scanner sc = new Scanner(System.in);
	static SecureRandom random = new SecureRandom();
	static int choice = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1) Length 10\n2) Length 20\n3) Length 50\n4) Length 100\n5) Exit");
		System.out.println("Please Enter your choice to generate random string of length(above) and compute the edit distance: ");
		hm.put(1, 10);
		hm.put(2, 20);
		hm.put(3, 50);
		hm.put(4, 100);
		choice = sc.nextInt();
		switch(choice) {
		case 1:
		case 2:
		case 3:
		case 4:
			computeEditDistance();
			break;
		case 5:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Please enter a valid choice.");
		}
	}
	
	public static void computeEditDistance() {
		long startTime, endTime, totalTime = 0, distance, totalEditDistance = 0;
		fillArrayRandom();
		for(int i=0; i<(RECORDS-1); i++) {
			startTime = System.nanoTime();
			distance = Sequences.editDistance(randStrArr[i], randStrArr[i+1]);
			endTime = System.nanoTime();
			totalTime += (endTime - startTime);
			totalEditDistance += distance;
		}
		System.out.println("The Edit Distance for words of length " + hm.get(choice) + " is: " + totalEditDistance);
		System.out.println("The average CPU time for each pair is: " + (totalTime/(RECORDS-1)));
	}
	
	public static void fillArrayRandom() {
		for(int i=0; i<RECORDS; i++) {
			randStrArr[i] = generateRandomString();
		}
	}
	
	public static String generateRandomString() {
        StringBuilder sb = new StringBuilder(hm.get(choice));
        for (int i=0; i<hm.get(choice); i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
