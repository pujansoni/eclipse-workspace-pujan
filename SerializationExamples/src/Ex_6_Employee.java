import java.io.Serializable;

public class Ex_6_Employee implements Serializable {
	int employeeId;
	String employeeName;
	public Ex_6_Employee (int employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "Employee ["
                + "employeeId=" + employeeId 
                + ", employeeName=" + employeeName 
                + "]";
	}
}
