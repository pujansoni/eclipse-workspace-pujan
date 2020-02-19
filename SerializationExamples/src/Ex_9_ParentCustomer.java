
public class Ex_9_ParentCustomer {
	// instance variables
    int customerId;
    String customerName;
    // overriding toString() method
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId 
                + ", customerName=" + customerName + "]";
    }
}
