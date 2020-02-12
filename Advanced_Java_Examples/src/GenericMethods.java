import java.util.*;

public class GenericMethods {
	static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
	static Integer[] intArray = {1, 2, 3, 4};
	static Boolean[] boolArray = {true, false, true};
	
	//Here T indicates that the return type of the list should match the list type that is passed in the argument.
	public static <T> List<T> arrayToList(T[] array, List<T> list){
		for(T object : array) {
			list.add(object);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> charList = arrayToList(charArray, new ArrayList<>());
		List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
		List<Integer> intList = arrayToList(intArray, new ArrayList<>());
		System.out.println(charList);
		System.out.println(boolList);
		System.out.println(intList);
	}

}
