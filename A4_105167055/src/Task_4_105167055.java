/**
 * 
 * @author pujan
 *
 * Pattern finder: Using Java Regex, find phone numbers and email addresses in the 100 text files.
 *
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import textprocessing.*;

public class Task_4_105167055 {

	//ArrayList to store all the 100 files
	static List<File> allfiles  = new ArrayList<File>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pat_email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String pat_phone ="(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}";
		//Finding the pattern for email
		find_pattern(pat_email);
		//Finding the pattern for phone
		find_pattern(pat_phone);
	}
	
	public static void find_pattern(String pattern) {
		Pattern reg = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Pujan\\eclipse-workspace\\A4_105167055\\src\\TextFiles"))) {
			allfiles = walk.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
			allfiles.forEach(file -> {
				In file1 = new In(file);
				String line;
				int count = 0;
				while(file1.hasNextLine()) {
					line = file1.readLine();
					count++;
					Matcher match = reg.matcher(line);
					while(match.find()) {
						System.out.println("Found value: " + match.group(0) + " at line " + count + " in the file \"\"" + file.getName() + "\"\"");
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
