import java.util.*;
import sorting.*;

public class Task_2_105167055 {
	static final int RECORDS = 100000;
	static Long [] randLongArr = new Long[RECORDS];
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1) Mergesort\n2) Quicksort\n3) Heapsort\n4) dual-pivot Quicksort\n5) Exit");
		System.out.println("Please Enter your choice to sort 100000 random keys(100 times): ");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
		case 2:
		case 3:
		case 4:
			sortArray(choice);
			break;
		case 5:
			System.out.println("Exiting...");
			return;
		default:
			System.out.println("Please enter a valid choice.");
		}
	}
	
	static public void sortArray(int choice) {
		long totalTime = 0, startTime = 0, endTime = 0;
		String tempString = "";
		for(int j=0; j<100; j++) {
			fillArrayRandom();
			if(choice == 1) {
				startTime = System.nanoTime();
				Sort.mergeSort(randLongArr);
				endTime = System.nanoTime();
				tempString = "Mergesort";
			} else if(choice == 2) {
				startTime = System.nanoTime();
				Sort.quicksort(randLongArr);
				endTime = System.nanoTime();
				tempString = "Quicksort";
			} else if(choice == 3) {
				startTime = System.nanoTime();
				Sort.heapsort(randLongArr);
				endTime = System.nanoTime();
				tempString = "Heapsort";
			} else if(choice == 4) {
				startTime = System.nanoTime();
				Arrays.sort(randLongArr);
				endTime = System.nanoTime();
				tempString = "dual-pivot Quicksort";
			}
			totalTime += (endTime - startTime);
		}
		System.out.println("The average CPU time taken to sort the keys for " 
				+ tempString + " is " + (totalTime/RECORDS) + " nanoseconds");
	}
	
	static public void fillArrayRandom() {
		Random r = new Random();
		for(int i=0; i<RECORDS; i++) {
			randLongArr[i] = r.nextLong();
		}
	}
}
