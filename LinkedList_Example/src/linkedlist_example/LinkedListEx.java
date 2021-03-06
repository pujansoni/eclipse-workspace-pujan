package linkedlist_example;
import java.util.LinkedList;
import java.util.ListIterator;
public class LinkedListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> states = new LinkedList<String>();
        states.add("Alaska");
        states.add("Arizona");
        states.add("Arkansas");
        states.add("Pennsylvania");
        states.add("California");
        states.add("Colorado");
        states.add("Connecticut");
        
        states.addFirst("Alabama");
        System.out.println(states);
        System.out.println("last state in my list: "+states.getLast());
        
        ListIterator<String> iterator = states.listIterator(states.size());
        while(iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
	}

}
