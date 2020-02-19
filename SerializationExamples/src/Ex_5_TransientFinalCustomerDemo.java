/*
 * final variable: variable declared as final modifier is known as final variable
 * value of final variable can’t be changed, once it‘s initialized
 * final variables are CONSTANT
 * Very important: final variable can be initialized at 3 places either
 * a) at the time of variable declaration i.e.; explicit initialization
 * b) inside constructor, rather parameterized constructor
 * c) instance initialization block
 * So when we declare any variable as both final & transient, then there are 2 cases,
 * Case 1: Initializing final transient variable at the time of declaration (explicit initialization)
 * i) This case is very simple, as during serialization process directly value is serialized instead of final variable
 * ii) Important : There is no impact on final variable declaring as transient
 * iii) In the below example customerAge is declared as final as well as transient and explicitly initialized with value 10
 * Case 2 & 3: Initializing final transient variable inside constructor or instance block
 * Serialization: 
 * These cases are bit tricky; when we serialize an Object
 * i) all non-final instance variables will be serialized
 * ii) all non-final transient variable won’t be serialized
 * iii) all final non-transient variable will be serialized (directly as values)
 * iv) Important : But all final transient variable won’t be serialized
 * De-Serialization :
 * i) During de-serialization process, constructor of an object isn’t invoked and this is handled by JVM for object instantiation
 * ii) after de-serialization process final transient variable will be assigned to default value
 */
import java.io.*;

public class Ex_5_TransientFinalCustomerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_5_TransientFinalCustomer serializeCustomer = new Ex_5_TransientFinalCustomer(107, "Mike", 117896);
		//creating output stream variables
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//creating input stream variables
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Ex_5_TransientFinalCustomer deSerializeCustomer = null;
		try {
			fos = new FileOutputStream("Customer.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(serializeCustomer);
			oos.flush();
			oos.close();
			System.out.println("Serialization success: Customer" + " object saved to Customer.ser file\n");
			fis = new FileInputStream("Customer.ser");
			ois = new ObjectInputStream(fis);
			deSerializeCustomer = (Ex_5_TransientFinalCustomer) ois.readObject();
			ois.close();
			System.out.println("De-Serialization success: Customer" + " object de-serialized from Customer.ser file\n");
		} catch(FileNotFoundException fnfex) {
			fnfex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		} catch(ClassNotFoundException ccex) {
			ccex.printStackTrace();
		}
		System.out.println("Printing customer values from " + "de-serialized object...\n" + deSerializeCustomer);
	}

}
