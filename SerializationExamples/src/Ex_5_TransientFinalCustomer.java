import java.io.Serializable;

public class Ex_5_TransientFinalCustomer implements Serializable {
	//member variables
	final int customerId;
	transient final String customerName;
	transient final int customerAge = 10;
	transient int customerSSN;
	//3-arg parameterized constructor
	public Ex_5_TransientFinalCustomer(int customerId, String customerName, int customerSSN) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSSN = customerSSN;
	}
	//overriding toString() method
	public String toString() {
		return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", customerAge=" + customerAge
                + ", customerSSN=" + customerSSN
                + "]";
	}
}
