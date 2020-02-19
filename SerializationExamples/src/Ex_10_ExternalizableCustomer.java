/*
 * Below Customer class consists of 4 member variables, out of which 2 variables need to be serialized and other variables are discarded
 * In Externalization, programmer need to implement/override 2 methods for saving/restoring object
 * For partial serialization, we have to override 2 methods namely,
 * writeExternal(); –> for saving/writing in serialization process
 * readExternal(); –> for restoring during de-serialization process
 * During serialization inside writeExternal(); method, programmer has to code/write custom logic to save/persist 2 member variables
 * During de-serialization inside readExternal(); method, programmer has to code/write custom logic to read 2 variable and then finally assigning to actual member variables
 */
import java.io.*;

public class Ex_10_ExternalizableCustomer implements Externalizable {
	// member variables for Customer
    int customerId;
    String customerName;
    int customerAge;
    String customerSSN;
    // default public no-arg constructor
    public Ex_10_ExternalizableCustomer() {
        System.out.println("public no-arg constructor is must for "
                + "Externalizable, "
                + "while restoring object back from file storage");
    }
    // 4-arg parameterized constructor for Customer
    public Ex_10_ExternalizableCustomer(int customerId, String customerName, 
            int customerAge, String customerSSN) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerSSN = customerSSN;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // saving to file storage
        out.writeInt(customerId);
        out.writeObject(customerName);
    }
    @Override
    public void readExternal(ObjectInput in) 
            throws IOException, ClassNotFoundException {
        // restoring variables, as per order of serialization
        int tempCustId = in.readInt();
        String tempCustName = (String) in.readObject();
        // assigning restored values to member variables
        customerId = tempCustId;
        customerName = tempCustName;
    }
    // to print nicely - customer object
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", customerSSN=" + customerSSN
                + ", customerAge=" + customerAge 
                + "]";
    }
}
