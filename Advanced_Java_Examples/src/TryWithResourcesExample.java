import java.io.*;
public class TryWithResourcesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		In the try block we can only write the classes that implements the AutoCloseable interface
		try(BufferedReader reader = new BufferedReader(new StringReader("Hello World"));
				StringWriter writer = new StringWriter();) {
			writer.write(reader.readLine());
			System.out.println(writer.toString());
		} catch (IOException ioe) {
			
		}
	}
}
