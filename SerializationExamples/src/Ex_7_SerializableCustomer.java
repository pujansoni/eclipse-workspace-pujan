/*
 * Customer class aggregates both Address and Phone classes
 * 
 */
import java.io.Serializable;

class Ex_7_SerializableCustomer implements Serializable {
 
    // instance variables
    int customerId;
    String customerName;
    Ex_7_SerializableAddress address;
    Ex_7_SerializablePhone phone;
 
    // 4-arg parameterized constructor
    public Ex_7_SerializableCustomer(int customerId, String customerName, Ex_7_SerializableAddress address, Ex_7_SerializablePhone phone) {
        super();
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
    }
 
    // overriding toString() method
    @Override
    public String toString() {
        return "Customer ["
                + "customerId=" + customerId 
                + ", customerName=" + customerName 
                + ", address=" + address
                + ", phone=" + phone
                + "]";
    }
}