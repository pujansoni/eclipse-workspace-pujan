/*
 * Before moving ahead, we should understand whether is it possible to serializable sub-class, if it’s super-class isn’t serializable ?
 * The answer is yes, because if the condition to serialize any class on the basis of its super-class implementing java.io.Serializable interface, then no class in Java can be serialized
 * Reason: java.lang.Object is the base class for any class defined in Java, and it doesn’t implements java.io.Serializable interface
 * In that way, it is very well possible to serialize a sub-class even if its super-class doesn’t implement java.io.Serializable interface
 */
import java.io.*;

public class Ex_9_SerializableChildDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating Privileged Customer object
		Ex_9_SerializableChildPrivilegeCustomer serializePrivilegedCustomer = 
                new Ex_9_SerializableChildPrivilegeCustomer();
        // initialize values for privileged customer object
        serializePrivilegedCustomer.customerId = 101;
        serializePrivilegedCustomer.customerName = "SJ";
        serializePrivilegedCustomer.discountRate = 12.5f;
        serializePrivilegedCustomer.bonusPoints = 1000;
        // time to play with Serialization and De-Serialization process
        // creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_9_SerializableChildPrivilegeCustomer deSerializePrivilegedCustomer = null;
        try {
            // for writing or saving binary data
            fos = new FileOutputStream("CustomerInheritance.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(serializePrivilegedCustomer);
            oos.flush();
            oos.close();
            System.out.println("Serialization: Privileged Customer "
                    + "object saved to CustomerInheritance.ser file\n");
            // reading binary data
            fis = new FileInputStream("CustomerInheritance.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // reading object's value and casting to Customer class
            deSerializePrivilegedCustomer = 
                    (Ex_9_SerializableChildPrivilegeCustomer) ois.readObject();
            ois.close();
            System.out.println("De-Serialization: "
                    + "Privileged Customer object de-serialized "
                    + "from CustomerInheritance.ser file\n");
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
        System.out.println("Printing privilege customer values "
                + "from de-serialized object... \n"
                + deSerializePrivilegedCustomer);
	}
}
/*
 * Important points to remember while Serialization with Inheritance:
 * If super-class implements java.io.Serializable interface, then all sub-class is also serializable by default
 * It is possible to serialize sub-class, even if its corresponding super-class doesn’t implements java.io.Serializable interface
 * While serializing sub-class whose super-class doesn’t implements java.io.Serializable interface, then during serialization process inheriting instance variables of non-serializable super-class will be stored to default value ignoring their original values (like 0 for Integer, null for String, etc)
 * During de-serialization process, JVM will execute instance initialization flow in 3 steps i.e.;
 * 1. 1st checks direct variable assignment,
 * 2. 2nd check inside initialization block and then
 * 3. finally 3rd check inside no-argument constructor
 * For 3rd check, it is very must to code no-argument constructor inside non-serializable super-class
 * Otherwise, InvalidClassException will be thrown at run time
 */