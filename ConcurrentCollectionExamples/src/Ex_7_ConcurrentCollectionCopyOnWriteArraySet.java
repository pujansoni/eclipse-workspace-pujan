import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Ex_7_ConcurrentCollectionCopyOnWriteArraySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOnWriteArraySet<String> cowas = new CopyOnWriteArraySet<String>();
		// adding elements to COWAS
        cowas.add("Mumbai");
        cowas.add("Tokyo");
        cowas.add("Shanghai");
        cowas.add(null); // 1st NULL
        cowas.add("Melbourne");
        cowas.add("Mumbai"); // duplicate
        cowas.add("Centurion");
        cowas.add(null); // 2nd NULL
        cowas.add("Singapore");
        cowas.add("Tokyo"); // duplicate
        System.out.println("CopyOnWriteArraySet demo example:\n");
        // get Iterator object
        Iterator<String> cities = cowas.iterator();
        // iterate using while-loop
        while(cities.hasNext()){
            System.out.println(cities.next());
        }
	}

}
