/*
 * The process of reading a state of an Object from a file is called De-Serialization
 * But practically, it is the process of converting and re-storing Java Object’s state into heap memory from file supported form (which is in binary format)
 */
import java.io.*;

public class Ex_2_DeserializeCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating input stream variables
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		//creating customer object reference to store values after de-serialization
		Ex_1_Customer customer = null;
		try {
			// reading binary data
            fis = new FileInputStream("Customer.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            customer = (Ex_1_Customer) ois.readObject();
		} catch(FileNotFoundException fnfex) {
			fnfex.printStackTrace();
		} catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
		System.out.println("Customer object de-serialized from Customer.ser file\nLet's print to console... \n");
		System.out.println(customer);
	}

}
