package loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tokenizer {

	// Returning Tokens of a file
		public static String[] textTokenizing(String f) {

			String[] tokens = null;
			try {

				String fName = ServletContextClass.textPath + f;
				File myTextFile = new File(fName);

				// storing file content into string
				BufferedReader reader = new BufferedReader(new FileReader(myTextFile));
				String line = null;
				String myStr;
				StringBuilder stringBuilder = new StringBuilder();
				String ls = System.getProperty(" ");

				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
					stringBuilder.append(ls);
				}

				reader.close();
				myStr = stringBuilder.toString().toLowerCase();

				// Tokenizing the file content
				tokens = myStr.split(" ");

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return tokens;

		}
		
}
