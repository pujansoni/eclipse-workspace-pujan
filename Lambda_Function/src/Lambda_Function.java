
public class Lambda_Function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Answerable phone = () -> {return "Hello";};
		System.out.println(phone.answer());
		
		Predicate isOdd = n -> n % 2 != 0;
		System.out.println(isOdd.test(3));
	}

}
