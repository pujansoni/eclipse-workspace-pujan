/*
 * Customer class is the one to be serialized. Therefore, it must implement java.io.Serializable interface
 */
import java.io.Serializable;
public class Ex_1_Customer implements Serializable {
	//member variables
	int customerId;
	String customerName;
	int customerAge;
	public Ex_1_Customer(int customerId, String customerName, int customerAge) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
	}
	//overriding toString() method
	@Override
	public String toString() {
		return "Customer [" + " customerId=" + customerId + "," + " customerName=" + customerName + "," + " customerAge=" + customerAge + "]";
	}
}
// Note: An Object said to be Serializable only if corresponding class implements java.io.Serializable interface