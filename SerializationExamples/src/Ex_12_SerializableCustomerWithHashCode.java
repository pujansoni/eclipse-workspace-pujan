/*
 * A simple POJO class called Customer implementing java.io.Serializable interface to mark that this class got special ability (i.e.; it can be serialized and de-serialized)
 * Consists of private constructor, so that no one outside of class can construct a new object
 * A public method to return same instance every time which is eagerly initialized
 * Note: we can also initialize lazily, by null checking and initializing afterwards
 * Finally, it contains readResolve(); method to suppress creation of new instance or say returns same singleton instance every time during de-serialization
 */
import java.io.*;

public class Ex_12_SerializableCustomerWithHashCode implements Serializable {
	// serialVersionUID
    private static final long serialVersionUID = 1L;
    // to always, return same instance
    private volatile static Ex_12_SerializableCustomerWithHashCode CUSTOMER = new Ex_12_SerializableCustomerWithHashCode();
    // private constructor
    private Ex_12_SerializableCustomerWithHashCode() {
        // private constructor
    }
    // create static method to get same instance every time
    public static Ex_12_SerializableCustomerWithHashCode getInstance(){
        return CUSTOMER;
    }
    // readResolve method
    private Object readResolve() throws ObjectStreamException {
        return CUSTOMER;
    }
    // other methods and details of this class
}
