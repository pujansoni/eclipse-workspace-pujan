import java.io.Serializable;

public class Ex_4_TransientStaticCustomer implements Serializable {
	// static data member
    static int customerCount = 2;
	//member variables
	int customerId;
	String customerName;
	int customerAge;
	transient int customerSSN;
	public Ex_4_TransientStaticCustomer(int customerId, String customerName, int customerAge, int customerSSN) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerSSN = customerSSN;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge + ", customerSSN=" + customerSSN + ", customerCount=" + customerCount + "]";
	}
}
