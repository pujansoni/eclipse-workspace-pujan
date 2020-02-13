import java.io.File;
import java.io.IOException;

public class FileCreationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myFile = new File("C:\\Users\\Pujan\\eclipse-workspace\\Advanced_Java_Examples\\myFile.txt");
		try {
			boolean fileCreated = myFile.createNewFile();
			System.out.println(fileCreated);
		} catch (IOException ioe) {
			
		}
	}

}
