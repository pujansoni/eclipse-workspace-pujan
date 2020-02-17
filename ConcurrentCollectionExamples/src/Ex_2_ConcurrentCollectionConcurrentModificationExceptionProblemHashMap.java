/*
 * If 2 different threads perform operations on same HashMap object simultaneously, then compiler will throw ConcurrentModificationException
 */
import java.util.HashMap;
import java.util.Map;

public class Ex_2_ConcurrentCollectionConcurrentModificationExceptionProblemHashMap extends Thread {
	//creating HashMap object of type <Integer, String>
	static HashMap<Integer, String> hm = new HashMap<Integer, String>();
	
	@Override
	public void run() {
		try {
			//sleeping thread for 1000 ms
			Thread.sleep(1000);
			//removing entry with key=1
			String value = hm.remove(1);
			System.out.println("Entry with {key=1" + ".& value=" + value + "} is removed");
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("Removal is done... !!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// adding key-value pairs to HashMap object
        hm.put(1, "<a class='vglnk' href='http://google.com' rel='nofollow'><span>google</span><span>.</span><span>com</span></a>");
        hm.put(2, "<a class='vglnk' href='http://youtube.com' rel='nofollow'><span>youtube</span><span>.</span><span>com</span></a>");
        hm.put(3, "<a class='vglnk' href='http://facebook.com' rel='nofollow'><span>facebook</span><span>.</span><span>com</span></a>");
        // creating another thread
        Thread newThread = new Thread(new Ex_2_ConcurrentCollectionConcurrentModificationExceptionProblemHashMap());
        newThread.start();
        // iterating HM object using enhanced for-loop
        for(Map.Entry<Integer, String> me : hm.entrySet()) {
            System.out.println("{Key=" + me.getKey() + "\t" + "Value=" + me.getValue() + "}");
            // sleeping thread for 1500 ms, after every turn
            Thread.sleep(1500);
        }
        System.out.println("Iterating completed... !!");
	}
}
