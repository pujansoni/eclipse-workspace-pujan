import java.io.Serializable;

public class Ex_9_SerializableChildPrivilegeCustomer extends Ex_9_ParentCustomer implements Serializable {
	// instance variables
    float discountRate;
    int bonusPoints;
    @Override
    public String toString() {
        return "PrivilegedCustomer [customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", discountRate=" + discountRate 
                + ", bonusPoints=" + bonusPoints + "]";
    }
}
