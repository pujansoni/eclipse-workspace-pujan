import java.util.*;

public class LinkedListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> myList = new LinkedList();
		myList.add("A");
		myList.add("B");
		myList.add(1, "C");
		System.out.println(myList);
		myList.remove("B");
		System.out.println(myList);
	}

}
