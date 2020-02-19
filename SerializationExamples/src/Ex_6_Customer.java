import java.io.Serializable;

public class Ex_6_Customer implements Serializable {
	int customerId;
	String customerName;
	public Ex_6_Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + "]";
	}
}
