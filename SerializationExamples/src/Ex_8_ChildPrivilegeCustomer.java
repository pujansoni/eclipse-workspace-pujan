
public class Ex_8_ChildPrivilegeCustomer extends Ex_8_SerializableParentCustomer {
	// instance variables
    float discountRate;
    int bonusPoints;
    @Override
    public String toString() {
        return "PrivilegedCustomer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", discountRate=" + discountRate 
                + ", bonusPoints=" + bonusPoints 
                + "]";
    }
}
