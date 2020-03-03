import java.util.Arrays;
import java.util.List;

public class FunctionalJava8 {

	public static void main(String[] args)
	{
	    List<String> countries = Arrays.asList("France", "India", "China",
	            "USA", "Germany");

	    countries.stream().forEach(
	            (String country) -> System.out
	                    .println("Hello " + country + "!"));
	}

}
