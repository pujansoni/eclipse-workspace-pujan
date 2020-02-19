/*
 * From above output, it is clear that hashcode of both instances are different
 * Which means they are 2 different objects
 * Hence, making Customer class as singleton design pattern fails
 * Although, for every serialization hashcode remain same, until/unless if we change any class detail
 * But with every de-serialization, hashcode of Customer class might change
 */
import java.io.*;

public class Ex_11_SerializableCustomerWithoutHashCodeDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an customer object using 3-arg parametrized constructor
		Ex_11_SerializableCustomerWithoutHashCode serializeCustomer = Ex_11_SerializableCustomerWithoutHashCode.getInstance();
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_11_SerializableCustomerWithoutHashCode deSerializeCustomer = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("Customer.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(serializeCustomer);
            oos.flush();
            oos.close();
            System.out.println("Serialization: "
                    + "Customer object saved to Customer.ser file\n");
            // reading binary data
            fis = new FileInputStream("Customer.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            deSerializeCustomer = (Ex_11_SerializableCustomerWithoutHashCode) ois.readObject();
            ois.close();
            System.out.println("De-Serialization: Customer object "
                    + "de-serialized from Customer.ser file\n");
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        // printing hash code of serialize customer object
        System.out.println("Hash code of the serialized "
                + "Customer object is " + serializeCustomer.hashCode());
        // printing hash code of de-serialize customer object
        System.out.println("\nHash code of the de-serialized "
                + "Customer object is " + deSerializeCustomer.hashCode());
	}
}
