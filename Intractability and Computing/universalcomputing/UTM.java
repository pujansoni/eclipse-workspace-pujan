package universalcomputing;

import java.io.*;

public class UTM {

	public static void main(String[] args) {
        try { 
        	String line;
            System.out.println("Compiling...");
            //Process p = Runtime.getRuntime().exec("javac "+ args[0]+".java");
            System.out.println("arguments: "+args[0] + " - " + args[1]);
            String program = "java universalcomputing/"+ args[0] + " " + args[1] + " " + args[1];
            System.out.println("Running..." + program);
            Process p2 = Runtime.getRuntime().exec(program);
            //Process p2 = Runtime.getRuntime().exec("java universalcomputing/HelloWorld");
            BufferedReader bri = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p2.getErrorStream()));
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
            bri.close();
            while ((line = bre.readLine()) != null) {
                 System.out.println(line);
            }
            bre.close();
            p2.waitFor();
            System.out.println("Done.");       
               
        }  catch (Exception e) {  
            e.printStackTrace();  
       }
    }

}
