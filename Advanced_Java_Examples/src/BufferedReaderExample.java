import java.io.*;
public class BufferedReaderExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myFile = new File("example.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
