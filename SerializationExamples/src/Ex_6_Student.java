import java.io.Serializable;

public class Ex_6_Student implements Serializable {
	int studentId;
	String studentName;
	public Ex_6_Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "Student ["
                + "studentId=" + studentId 
                + ", studentName=" + studentName
                + "]";
	}
}
