
public class FunctionalInterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuntionalInterfaceGreetingMessage gm = new FuntionalInterfaceGreetingMessage() {
			@Override
			public void greet(String name) {
				System.out.println("Hello " + name);
			}
		};
		gm.greet("Pujan");
		
//		The same code shown above could be rewritten in less line by the use of lambda
		FuntionalInterfaceGreetingMessage gm2 = (String name) -> {
			System.out.println("Hello " + name);
		};
		gm2.greet("Pujan");
		
		MessagePrinter mp = () -> {
			System.out.println("This is a message");
		};
		mp.printMessage();
	}
}
