import java.util.*;
public class LinkedHashMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		When we use the normal HashMap we can't get the order in which the records were inserted.
//		To ensure that we get the same order of values in which they were inserted we can use the LinkedHashMap
//		Arguments in LinkedHashMap: If we do not want to specify the size of the LinkedHashMap and do not care about the order in which the elements are printed then we do no have to specify any arguments
//		If we want to specify the size of the LinkedHashMap we can specify it in the first argument i.e. 4 in this case
//		If we want to specify that the LinkedHashMap should be resized after some amount of records are stored then we can specify it with the second argument i.e. 0.75f in this case which means that LinkedHashMap will increase in size when 75% of the LinkedHashMap is full
//		The third argument specifies the order in which we want to retrieve the elements in LinkedHashMap. The false value indicate the default option that is we will retrieve the elements in order they were inserted. The true value means that we retrieve the value by the order in which they were accessed, so the entry that was modified the longest time ago will be at the top.
		LinkedHashMap<String, Integer> phoneBook = new LinkedHashMap(4, 0.75f, false);
		phoneBook.put("Kevin", 123454);
		phoneBook.put("Jill", 987650);
		phoneBook.put("Brenda", 123123);
		phoneBook.put("Gary", 222222);
		System.out.println("Kevin's number: " + phoneBook.get("Kevin"));
		System.out.println("\nList of contacts in phoneBook: ");
		for(Map.Entry<String, Integer> entry : phoneBook.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
