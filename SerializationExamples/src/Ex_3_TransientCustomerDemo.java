/*
 * Transient keyword or modifier is applicable only for variables
 * We can stop persisting specific variable, by declaring transient keyword
 * During serialization, JVM ignores the original value of transient variable and saves default value to file
 * Examples: Customer SSN or password need not to be stored. Hence, it’s a good practice to declare those variables as transient
 * So whenever we encounter transient keyword, it means that not to serialize
 */
import java.io.*;

public class Ex_3_TransientCustomerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_3_TransientCustomer serializeCustomer = new Ex_3_TransientCustomer(102, "SR", 17, 112569);
		//creating output stream variables
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//creating input stream variables
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		//creating customer object reference to hold values after de-serialization
		Ex_3_TransientCustomer deSerializeCustomer = null;
		try {
			//for writing or saving binary data
			fos = new FileOutputStream("Customer.ser");
			//converting java-object to binary-format
			oos = new ObjectOutputStream(fos);
			// writing or saving customer object's value to stream
            oos.writeObject(serializeCustomer);
            oos.flush();
            oos.close();
            System.out.println("Serialization success: Customer " + "object saved to Customer.ser file\n");
         // reading binary data
            fis = new FileInputStream("Customer.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            deSerializeCustomer = (Ex_3_TransientCustomer) ois.readObject();
            ois.close();
            System.out.println("De-Serialization success: Customer " + "object de-serialized from Customer.ser file\n");
		} catch(FileNotFoundException fnfex) {
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
 * In above Customer POJO, customerSSN declared as transient
 * So during serialization process, original value of customerSSN won’t be saved to file
 * Instead default value will be saved (i.e.; 0 for int, null for String, etc)
 * 1st half of the program illustrate serialization process
 * And 2nd half deals with de-serialization process, which de-serializes the serialized Object
 * While de-serializing all instance member values are re-stored back perfectly except for customerSSN
 * Reason: because this is marked with transient keyword
 * So, by declaring instance variable with transient keyword, we can restrict to store/save that particular variable into file storage during serialization process
 * And it depends purely on business requirement that, which all instance variables need to be restricted
 */
