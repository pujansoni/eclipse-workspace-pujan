/**
 * 
 * @author pujan

 * HTMLtoText converter: Write a program that takes the 100 given Web pages (W3C Web Pages.zip),
 * and using Jsoup, converts all files into text. 
 * The text files should be saved as individual files for use in the next tasks of this assignment.
 * Keep good OO design practice by creating a method processes one file. 
 * That method will then be called 100 times.
 *
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Task_3_105167055 {

	//ArrayList to store all the 100 files
	static List<File> allfiles  = new ArrayList<File>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Pujan\\eclipse-workspace\\Languages\\W3C Web Pages"))) {
			allfiles = walk.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
			allfiles.forEach(file -> {
				convertHtmlToText(file);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// This method is called 100 times and in each iteration it converts an Html file to its corresponding txt file
	public static void convertHtmlToText(File file) {
		try {
			Document doc = Jsoup.parse(file, "UTF-8");
			String content = doc.text();
			PrintWriter out = new PrintWriter("C:\\Users\\Pujan\\eclipse-workspace\\A4_105167055\\src\\TextFiles\\" + extractFileName(file) + ".txt");
			out.println(content);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// This method extracts the file name from the given path without extension
	public static String extractFileName(File filePathName) {
		String filePath = filePathName.toString();
		if ( filePath == null ) {
	    	return null;
	    }
	    int dotPos = filePath.lastIndexOf( '.' );
	    int slashPos = filePath.lastIndexOf( '\\' );
	    if ( slashPos == -1 )
	    	slashPos = filePath.lastIndexOf( '/' );
	    if ( dotPos > slashPos ) {
	    	return filePath.substring( slashPos > 0 ? slashPos + 1 : 0, dotPos );
	    }
	    return filePath.substring( slashPos > 0 ? slashPos + 1 : 0 );
	}
}
