import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Here we will create a text file helloworld.txt which we will delete. The file should be created in the project folder
		Path path = Paths.get("helloworld.txt");
		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {

		}
		
		Path path2 = Paths.get("C:\\Users\\Pujan\\eclipse-workspace\\Advanced_Java_Examples\\myFile.txt");
//		The getParent() method will return the parent directory
		System.out.println(path2.getParent());
//		The getRoot() method will return the root directory
		System.out.println(path2.getRoot());
		System.out.println(path2.getFileName());
	}

}
