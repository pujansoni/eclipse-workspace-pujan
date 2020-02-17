/*
 * When 2 different threads perform operations on same ConcurrentHashMap object simultaneously, then compiler won't throw runtime exception
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex_3_ConcurrentCollectionConcurrentModificationExceptionSolveConcurrentHashMap implements Runnable {
	//creating ConcurrentHashMap object of type <Integer, String>
	static ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<Integer, String>();
	
	@Override
	public void run() {
		try {
			//sleeping thread for 1000 ms
			Thread.sleep(1000);
			//removing entry with key=1
			String value = chm.remove(1);
			System.out.println("Entry with {key=1" + " & value=" + value + "} is removed");
		} catch(InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("Removal is done... !!");
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// adding key-value pairs to ConcurrentHashMap object
        chm.put(1, "<a class='vglnk' href='http://google.com' rel='nofollow'><span>google</span><span>.</span><span>com</span></a>");
        chm.put(2, "<a class='vglnk' href='http://youtube.com' rel='nofollow'><span>youtube</span><span>.</span><span>com</span></a>");
        chm.put(3, "<a class='vglnk' href='http://facebook.com' rel='nofollow'><span>facebook</span><span>.</span><span>com</span></a>");
        // creating another thread
        Thread newThread = new Thread(new Ex_3_ConcurrentCollectionConcurrentModificationExceptionSolveConcurrentHashMap());
        newThread.start();
        // iterating CHM object using enhanced for-loop
        for(Map.Entry<Integer, String> me : chm.entrySet()) {
            System.out.println("{Key=" + me.getKey() + "\t" + "Value=" + me.getValue() + "}");
            // sleeping thread for 2000 ms, after every turn
            Thread.sleep(2000);
        }
        System.out.println("Iterating completed... !!");
	}
}
