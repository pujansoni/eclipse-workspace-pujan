/*
 * When super-class is serializable, then any class that is extending super-class will also be serializable by default through inheritance principle
 * So, here sub-class doesn’t required to implement java.io.Serializable explicitly
 * When sub-class is serialized, then sub-class properties as well as inherited super-class properties will also be serialized during serialization process
 * Note: To prevent sub class from serializing by default, then we need to override writeObject() and readObject() methods
 */
import java.io.*;

public class Ex_8_SerializableParentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_8_ChildPrivilegeCustomer serializePrivilegedCustomer = new Ex_8_ChildPrivilegeCustomer();
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
        Ex_8_SerializableParentCustomer deSerializePrivilegedCustomer = null;
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
            deSerializePrivilegedCustomer = (Ex_8_ChildPrivilegeCustomer) ois.readObject();
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
