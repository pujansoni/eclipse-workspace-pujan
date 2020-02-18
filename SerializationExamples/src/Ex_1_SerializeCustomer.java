/*
 * The process of writing a state of an Object to a file is called Serialization
 * In other words, process of saving on Object's State to a file is called Serialization
 * But practically, it is the process of converting and storing Java Object’s state from heap memory (in byte stream) to file supported form (in binary format)
 */
import java.io.*;

public class Ex_1_SerializeCustomer {

	public static void main(String[] args) {
        // create a customer object using 3-arg parametrized constructor
        Ex_1_Customer customer = new Ex_1_Customer(101, "SJ", 19);
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("Customer.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(customer);
            oos.flush();
            oos.close();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        System.out.println("Customer object saved to Customer.ser file");
    }
}
