/*
 * This is a thread-safe version of ArrayList where modify operation is performed on a separate cloned copy and finally JVM merges both original and cloned copies
 * Apart from thread-safety difference between ArrayList and CopyOnWriteArrayList, all properties of ArrayList are applicable to CopyOnWriteArrayList
 */
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Ex_4_ConcurrentCollectionCopyOnWriteArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<String> allCapital = new CopyOnWriteArrayList<String>();
		allCapital.addIfAbsent("Berlin");
		allCapital.addIfAbsent("Tokyo");
		allCapital.addIfAbsent("Moscow");
		allCapital.addIfAbsent("Tokyo"); //adding Tokyo again
		//AL of European capital
		ArrayList<String> euroCapital = new ArrayList<String>();
		euroCapital.add("Moscow");
		euroCapital.add("London");
		euroCapital.add("Paris");
		//To simply add all the elements without absent we can use addAll() method
		//adding European capital to all capital using addAllAbsent()
		allCapital.addAllAbsent(euroCapital);
		//print to console
		System.out.println(allCapital);
	}

}
