/*
 * We will demonstrate a simple example using ArrayList which performs
 * a) 1st thread iterating or reading element/objects one-by-one
 * b) 2nd thread removing a particular element from List while other thread is iterating ArrayList object
 */
import java.util.ArrayList;

public class Ex_5_ConcurrentCollectionConcurrentModificationExceptionProblemArrayList extends Thread {
	//creating ArrayList of type String
	static ArrayList<String> alStars = new ArrayList<String>();
	
	@Override
	public void run() {
		try {
			//sleeping thread for 1000 ms
			Thread.sleep(1000);
			//removing element at 2nd position
			String star = alStars.remove(1);
			System.out.println("Thread 2: removed " + star);
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("Removal is done...!!");
	}
	
	/*
	 * main() method
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//adding elements to ArrayList
		alStars.add("Rock Star");
		alStars.add("Ultimate Star");
		alStars.add("Little Star");
		//creating another thread
		Thread newThread = new Thread(new Ex_5_ConcurrentCollectionConcurrentModificationExceptionProblemArrayList());
		newThread.start();
		//iterating ArrayList using enhanced for-loop
		for(String star : alStars) {
			System.out.println("Thread 1 iterating : " + star);
			//sleeping thread for 1500 ms, after every turn
			Thread.sleep(1500);
		}
		System.out.println("Iterating AL completed...!!");
	}

}
