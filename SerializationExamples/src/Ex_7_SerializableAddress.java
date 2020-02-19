import java.io.Serializable;

class Ex_7_SerializableAddress implements Serializable {
    // instance variables
    int flatNo;
    String streetName;
    // 2-arg parameterized constructor
    public Ex_7_SerializableAddress(int flatNo, String streetName) {
        super();
        this.flatNo = flatNo;
        this.streetName = streetName;
    }
    // overriding toString() method
    @Override
    public String toString() {
        return "Address ["
                + "flatNo=" + flatNo 
                + ", streetName=" + streetName
                + "]";
    }
}