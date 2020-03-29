package loader;

import java.io.File;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLtoText {
	
	public static void htmlToText(String[] myHTMLFiles) {

		try {
			for (int i = 0; i < myHTMLFiles.length; i++) {

				File myFile = new File(ServletContextClass.htmlPath + myHTMLFiles[i]);
				Document doc = Jsoup.parse(myFile, "UTF-8");
				String text = doc.text();

				PrintWriter out = new PrintWriter(ServletContextClass.textPath + myHTMLFiles[i].replaceAll(".htm*", ".txt"));
				out.println(text);
				out.close();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


}
