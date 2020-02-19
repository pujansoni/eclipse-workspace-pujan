import java.io.Serializable;

public class Ex_8_SerializableParentCustomer implements Serializable {
	// instance variables
    int customerId;
    String customerName;
    // overriding toString() method
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName
                + "]";
    }
}
