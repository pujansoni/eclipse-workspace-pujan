/*
 * Here, both aggregating classes Ex_7_SerializableAddress and Ex_7_SerializablePhone is serializable
 * Also main Customer class which has reference to Ex_7_SerializableAddress/Ex_7_SerializablePhone is also serializable
 */
import java.io.*;
public class Ex_7_SerializationWithAggregation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating address object --&gt; implements java.io.Serializable
		Ex_7_SerializableAddress address = new Ex_7_SerializableAddress(402, "2nd street");
        // creating phone object --&gt; implements java.io.Serializable
		Ex_7_SerializablePhone phone = new Ex_7_SerializablePhone(022, 27759868);
        // creating customer object --&gt; implements java.io.Serializable
		Ex_7_SerializableCustomer serializeCustomer = new Ex_7_SerializableCustomer(101, "SJ", address, phone);
        // time to play with Serialization and De-Serialization process 
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_7_SerializableCustomer deSerializeCustomer = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("CustomerAggregation.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(serializeCustomer);
            oos.flush();
            oos.close();
            System.out.println("Serialization: Customer object " + "saved to CustomerAggregation.ser file\n");
            // reading binary data
            fis = new FileInputStream("CustomerAggregation.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis); 
            // reading object's value and casting to Customer class
            deSerializeCustomer = (Ex_7_SerializableCustomer) ois.readObject();
            ois.close();
            System.out.println("De-Serialization: Customer object " + "de-serialized from CustomerAggregation.ser file");
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        // printing customer object to console using toString() method
        System.out.println("Printing customer values from " + "de-serialized object... \n" + deSerializeCustomer);
	}
}

/*
 * Rule 1: all classes that need to be serialized must implement java.io.Serializable interface
 * Rule 2: All reference classes inside a serializable class must also be java.io.Serializable
 * Rule 3: If any of the class is not implementing java.io.Serializable in the serialization process, then JVM will throw NotSerializableException
 */