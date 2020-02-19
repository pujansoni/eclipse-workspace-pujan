/*
 * While serializable implemented class does the necessary job of Serialization and de-serialization in saving & restoring object but it saves altogether all member variables of an object
 * This way, even if programmer requires only couple of member variables of an Object to be saved, Serializable doesn’t allow those kinds of flexibility
 * That is no flexibility saving & restoring partial object
 * It is time consuming in saving and restoring object during both serialization and de-serialization process
 * As JVM controls complete serialization and de-serialization process and programmer has nothing to do with serializable interface
 * With transient modifier also, we can stop serializing original value but still that particular member variable get saved to file storage although with default value
 * Due to saving and restoring of all member variables of an Object, even if programmer requires only couple of variables to be saved/restored back, there is big performance hit
 * To overcome above listed performance issue with serializable, we have to serialize with externalizable interface which is sub-interface of Serializable interface
 * Allows saving/restoring partial object i.e.; 2 or 3 member variables of an object out of total object
 * As programmer has to code/write custom logic for serialization and de-serialization process, so write/code logic to save/restore those variables which is required
 * This way, there is performance boost relatively when comparing with serializable interface
 * Transient variable is not required as programmer has control over saving/restoring object and can easily ignore those variables whose value is secure or need to kept very secret
 * By saving/restoring partial object instead of total object, time consumption decreases i.e.; time is saved in externalizable interface
 * Externalizable interface is sub-interface of Serializable interface
 * Present in java.io package
 * Fully qualified class name is java.io.Externalizable
 * It has got 2 methods namely, writeExternal(); and readExternal();
 * Method 1: with writeExternal(ObjectOutput out) method, programmer has to explicitly code/write logic for saving only those required variables to file storage
 * Method 2: with readExternal(ObjectInput in) method, programmer has to explicitly code/write logic for restoring object back from file storage
 * Note: class implementing externalizable interface should definitely consist of a public no-arg constructor, otherwise InvalidClassException is thrown
 * Design choice: This is the best suit; when partial object or few member variables of an object need to be serialized to file storage, otherwise still serializable interface is a good option for saving total object
 */
import java.io.*;

public class Ex_10_ExternalizableCustomerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an customer object using 4-arg constructor
        Ex_10_ExternalizableCustomer serializeCustomer = new Ex_10_ExternalizableCustomer(102, "NK", 19, "SSN-78087");
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null; 
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_10_ExternalizableCustomer deSerializeCustomer = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("Customer.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(serializeCustomer);
            oos.flush();
            oos.close();
            System.out.println("Externalization: " + "Customer object saved to Customer.ser file\n");
            // reading binary data
            fis = new FileInputStream("Customer.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            deSerializeCustomer = (Ex_10_ExternalizableCustomer) ois.readObject();
            ois.close();
            System.out.println("Externalization: Customer object " + "de-serialized from Customer.ser file\n");
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
 * Note: As we stated earlier that there is always a serialVersionUID associated with every serializable class, then where we have declared in earlier example ?
 * Serialization: Actually, we haven’t declared this field explicitly and if it isn’t declared then compiler does job for us by declaring this static field and it get saved to serialized file along with Object values
 * De-Serialization: while restoring object back from file storage, then first thing it does is, compare stored serialVersionUID inside serialized file with serializable class
 * Exception: if there is a mismatch between serialVersionUID present in the serialized file and serializable class, then InvalidClassException will be thrown
 * Compiler generated serialVersionUID is highly complex as it uses combination of class name and properties to generate this unique Id
 * Due to complexity in creation of this unique Id, performance of serialization and de-serialization process becomes slow
 * Therefore, it is highly recommended to define serialVersionUID inside serializable class and use for both serialization and de-serialization process
 * Firstly it reduces complexity in creating compiler generated serialVersionUID and second comparing this unique Id during de-serialization process
 * Also, programmer hasflexibility of declaring any Long value
 */