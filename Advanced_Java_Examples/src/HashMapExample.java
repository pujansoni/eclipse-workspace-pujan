import java.util.*;
public class HashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Duplicate keys are not allowed in HashMap. Moreover, the order in which the data is inserted in a HashMap is not the same that is printed
		HashMap<String, Integer> phoneBook = new HashMap<>();
		phoneBook.put("Kevin", 123454);
		phoneBook.put("Jill", 987650);
		phoneBook.put("Brenda", 123123);
//		As Brenda is already present the previous value is overridden
		phoneBook.put("Brenda", 222222);
		phoneBook.put(null, 000);
		if(phoneBook.containsKey("Brenda")) {
			phoneBook.remove("Brenda");
		}
		System.out.println(phoneBook);
//		To remove all the entries we can use clear() method
		phoneBook.clear();
		System.out.println(phoneBook);
	}
}
