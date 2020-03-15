/**
 * 
 * @author pujan
 *
 * URL finder: Using Java Regex, write a program that finds Web links (URLs) in a Web file. Test your program with the 100 HTML files to find the following:
 * a. Links with domain w3.org
 * b. Links that contain folders: e.g., www.w3.org/TR/owl-features/
 * c. Links that contain references in a Web page and may contain folders; for example: www.w3.org/TR/owl-features/#DefiningSimpleClasses
 * d. Links with domain .net, .com, .org
 *
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_5_105167055 {

	static ArrayList<String> txtArr = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File folder = new File("C:\\Users\\Pujan\\eclipse-workspace\\Languages\\W3C Web Pages");
		File[] files = folder.listFiles();
		// find pattern to find links that contains w3.org domain
		String pattern1 = "(http)[s]?://?[A-Za-z0-9-.]+(w3.org)(/[\\w/_-]+)*";
		// find pattern to find links that contains folders
		String pattern2 = "(http)[s]?://?[A-Za-z0-9-.]+[A-Za-z]{2,4}+/[\\w/_-]+/";
		// find pattern to find links that contains references and folders(optional)
		String pattern3 = "(http)[s]?://?[A-Za-z0-9-.]+[A-Za-z]{2,4}+/[\\w/_-]+/#\\w+";
		// find pattern to find links that contains domain .net, .com, .org
		String pattern4 = "(http)[s]?://?[A-Za-z0-9-.]+(net|com|org)";
		txtArr.add("Links with domain w3.org\n");
		findPattern(files, pattern1);
		txtArr.add("\nLinks that contain folders\n");
		findPattern(files, pattern2);
		txtArr.add("\nLinks that contain references in a Web page and may contain folders\n");
		findPattern(files, pattern3);
		txtArr.add("\nLinks with domain .net, .com or .org\n");
		findPattern(files, pattern4);
		// Writing the output to a file
		writeOuput();
	}
	
	public static void findPattern(File[] fileList, String pattern) throws Exception {
		Pattern pat = Pattern.compile(pattern);
		Matcher match;
		Elements elements;
		if (fileList!=null)
		for (File file : fileList) {
			if (file.isFile()) {
				Document doc = Jsoup.parse(file, "UTF-8");
				elements = doc.select("a");
				String str;
				for (Element element : elements) {
					str = element.attr("href");
					match = pat.matcher(str);
					if (match.find()) {
						txtArr.add("Found Value: " + match.group());
					}
				}
			}
		}
	}
	
	public static void writeOuput() throws Exception {
		PrintWriter writer = new PrintWriter("src/Task_5_Output_105167055.txt", "UTF-8");
		txtArr.forEach(str -> { writer.println(str); });
		writer.close();
	}
}
