import java.io.*;
public class DirectoriesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		To print only the files we can use the FilenameFilter class which is a functional interface so we can use the lambda expression here
		FilenameFilter filter = (file, fileName) -> {
			return fileName.contains(".");
		};
//		To read everything in the current directory we will create a string array
		String[] contents = new File(".").list(filter);
		for(String file: contents) {
			System.out.println(file);
		}
		//a directory is created as follo
		new File("myDirectory").mkdir();
	}
}
