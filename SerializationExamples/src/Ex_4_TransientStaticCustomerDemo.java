/*
 * Transient keyword or modifier is applicable only for variables
 * We can stop persisting specific variable, by declaring transient keyword
 * During serialization, JVM ignores the original value of transient variable and saves default value to file
 * Examples: Customer SSN or password need not to be stored. Hence, it’s a good practice to declare those variables as transient
 * So whenever we encounter transient keyword, it means that not to serialize
 * Static Variable:
 * A variable declared with static modifier is known as static variable
 * Alternatively it is referred as class variable as it belongs to class rather to any specific instance
 * Static variable shared among every instance like for example organization name of the employee
 * It should be used whenever there is common property for all objects of that class
 * Static variables can be accessed directly by class name or interface name instead of creating an instance and then accessing
 * Static variables can be accessed from static and non-static methods/blocks using class name or interface name
 * Memory allocation for static variables happens at the time of class loading by JVM
 */
import java.io.*;

public class Ex_4_TransientStaticCustomerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an customer instance using 4-arg constructor
		Ex_4_TransientStaticCustomer serializeCustomer = new Ex_4_TransientStaticCustomer(103, "AK", 21, 112563);
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_4_TransientStaticCustomer deSerializeCustomer = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("Customer.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(serializeCustomer);
            oos.flush();
            oos.close();
            System.out.println("Serialization success: Customer" + " object saved to Customer.ser file\n");
            // reading binary data
            fis = new FileInputStream("Customer.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            deSerializeCustomer = (Ex_4_TransientStaticCustomer) ois.readObject();
            ois.close();
            System.out.println("De-Serialization success: Customer" + " object de-serialized from Customer.ser file\n");
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        // printing customer object to console using toString() method
        System.out.println("Printing customer values from " + "de-serialized object... \n" + deSerializeCustomer);
	}
}
/*
 * In above Customer POJO, customerSSN declared as transient so therefore this is ignored by JVM
 * Only Object’s state is persisted to file (i.e.; only instance variables)
 * Static data member aren’t part of Object’s state, so this won’t be considered
 * When we de-serialize, all instance variables without transient keyword will be restored
 * But static data member doesn’t participated in serialization neither its gets persisted nor restored back from file
 */