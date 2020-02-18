import java.io.Serializable;

public class Ex_3_TransientCustomer implements Serializable {
	//member variables
	int customerId;
	String customerName;
	int customerAge;
	transient int customerSSN;
	public Ex_3_TransientCustomer(int customerId, String customerName, int customerAge, int customerSSN) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerSSN = customerSSN;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge + ", customerSSN=" + customerSSN + "]";
	}
}
