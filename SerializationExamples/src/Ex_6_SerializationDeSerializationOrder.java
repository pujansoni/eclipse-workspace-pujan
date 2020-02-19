import java.io.*;

public class Ex_6_SerializationDeSerializationOrder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex_6_Customer customer = new Ex_6_Customer(101, "Jeremy Krist");
		Ex_6_Employee employee = new Ex_6_Employee(111, "Mike Gentry");
		Ex_6_Student student = new Ex_6_Student(121, "Azeen Sayad");
		// creating output stream variables
        FileOutputStream fos = null;
        ObjectOutputStream oos = null; 
        // creating input stream variables
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        // creating customer object reference 
        // to hold values after de-serialization 
        Ex_6_Customer deSerializeCustomer = null;
        Ex_6_Employee deSerializeEmployee = null;
        Ex_6_Student deSerializeStudent = null;
        try {
        	// for writing or saving binary data
            fos = new FileOutputStream("OrderOfObjects.ser");
            // converting java-object to binary-format 
            oos = new ObjectOutputStream(fos);
            // writing or saving customer object's value to stream
            oos.writeObject(customer);
            oos.writeObject(employee);
            oos.writeObject(student);
            oos.flush();
            oos.close();
            System.out.println("Serialization: All objects " + "saved to OrderOfObjects.ser file\n");
            // reading binary data
            fis = new FileInputStream("OrderOfObjects.ser");
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
            // temp Object variable
            Object object = null;
         // iterating, reading & casting to respective class 
            while((object = ois.readObject()) != null){
                if(object instanceof Ex_6_Customer)
                    deSerializeCustomer = (Ex_6_Customer) object;
                else if(object instanceof Ex_6_Employee)
                    deSerializeEmployee = (Ex_6_Employee) object;
                else if(object instanceof Ex_6_Student)
                    deSerializeStudent = (Ex_6_Student) object;
            } // END of while loop
        } catch (EOFException eofex) {
            // eofex.printStackTrace();
            System.out.println("De-Serialization: All objects " + "de-serialized from OrderOfObjects.ser file\n");
            System.out.println("End of file reached...\n");
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        } finally {
            ois.close(); // closing stream
        }
     // printing customer object to console using toString() method
        System.out.println("Printing values " + "from de-serialized object... \n");
        System.out.println(deSerializeCustomer);
        System.out.println(deSerializeEmployee);
        System.out.println(deSerializeStudent);
	}

}
