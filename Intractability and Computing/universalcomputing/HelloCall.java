package universalcomputing;

import java.io.*;

public class HelloCall {

	public static void main(String[] args) {
        try { 
        	String line;
        	String program = "java universalcomputing/"+ args[0];
            System.out.println("Running..." + program);
            Process p = Runtime.getRuntime().exec(program);
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
                 System.out.println(line);
            }
            bre.close();
            p.waitFor();
            System.out.println("Done.");       
               
        }  catch (Exception e) {  
            e.printStackTrace();  
       }
    }

}
