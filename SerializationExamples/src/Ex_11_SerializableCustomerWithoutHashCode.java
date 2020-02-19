/*
 * A simple POJO class called Customer implementing java.io.Serializable interface to mark that this class got special ability (i.e.; it can be serialized and de-serialized)
 * Consists of private constructor, so that no one outside of class can construct a new object
 * A public method to return same instance every time which is eagerly initialized
 * Note: we can also initialize lazily, by null checking and initializing afterwards
 */
import java.io.Serializable;

public class Ex_11_SerializableCustomerWithoutHashCode implements Serializable {
	// serialVersionUID
    private static final long serialVersionUID = 1L;
    // to always, return same instance
    private volatile static Ex_11_SerializableCustomerWithoutHashCode CUSTOMER = new Ex_11_SerializableCustomerWithoutHashCode();
    // private constructor
    private Ex_11_SerializableCustomerWithoutHashCode() {
        // private constructor
    }
    // create static method to get same instance every time
    public static Ex_11_SerializableCustomerWithoutHashCode getInstance(){
        return CUSTOMER;
    }
    // other methods and details of this class
}
