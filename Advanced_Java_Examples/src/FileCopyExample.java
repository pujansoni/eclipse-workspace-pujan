import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path source = Paths.get("C:\\Users\\Pujan\\eclipse-workspace\\Advanced_Java_Examples\\example.txt");
		Path dest = Paths.get("C:\\Users\\Pujan\\eclipse-workspace\\Advanced_Java_Examples\\new.txt");
		try {
			Files.copy(source, dest);
//			If file already exists in the folder than the above line can be written as: Files.copy(source, dest, REPLACE_EXISTING); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
