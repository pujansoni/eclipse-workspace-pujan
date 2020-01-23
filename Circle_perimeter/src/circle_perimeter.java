import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class circle_perimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int radius = 0;
		System.out.println("Please enter radius of a circle");
		try {
			//get the radius from console
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			radius = Integer.parseInt(br.readLine());
		}
		//if invalid value was entered
		catch(NumberFormatException ne) {
			System.out.println("Invalid radius value " + ne);
			System.exit(0);
		}
		catch(IOException ioe) {
			System.out.println("IO Error :" + ioe);
			System.exit(0);
		}
		double perimeter = 2 * Math.PI * radius;
		System.out.println("Perimeter of a circle is " + perimeter);
	}

}
