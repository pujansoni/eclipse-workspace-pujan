/*
 * When 2 different threads performs operations on same CopyOnWriteArrayList object simultaneously then compiler won't throw any runtime exception.
 * It works on different cloned copies which is later merged into one/original copy by JVM
 */
import java.util.concurrent.CopyOnWriteArrayList;
public class Ex_6_ConcurrentCollectionConcurrentModificationExceptionSolveCopyOnWriteArrayList implements Runnable {

	//creating CopyOnWriteArrayList of type String
	static CopyOnWriteArrayList<String> cowalStars = new CopyOnWriteArrayList<String>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//sleeping thread for 1000 ms
			Thread.sleep(1000);
			//removing element at 2nd position
			String star = cowalStars.remove(1);
			System.out.println("Thread 2: removed " + star);
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("Removal is done... !!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//adding elements to CopyOnWriteArrayList
		cowalStars.add("Rock Star");
		cowalStars.add("Ultimate Star");
		cowalStars.add("Little Star");
		//creating another thread
		Thread newThread = new Thread(new Ex_6_ConcurrentCollectionConcurrentModificationExceptionSolveCopyOnWriteArrayList());
		newThread.start();
		//iterating CopyOnWriteArrayList using enhanced for-loop
		for(String star : cowalStars) {
			System.out.println("Thread 1 iterating : " + star);
			//sleeping thread for 1500 ms, after every turn
			Thread.sleep(1500);
		}
		System.out.println("Iterating COWAL completed... !!");
	}
}
