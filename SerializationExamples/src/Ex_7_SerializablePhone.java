import java.io.Serializable;

class Ex_7_SerializablePhone implements Serializable {
    // instance variables
    int countryCode;
    int telephoneNumber;
    // 2-arg parameterized constructor
    public Ex_7_SerializablePhone(int countryCode, int telephoneNumber) {
        super();
        this.countryCode = countryCode;
        this.telephoneNumber = telephoneNumber;
    }
    // overriding toString() method
    @Override
    public String toString() {
        return "Phone ["
                + "countryCode=" + countryCode 
                + ", telephoneNumber=" + telephoneNumber
                + "]";
    }
}