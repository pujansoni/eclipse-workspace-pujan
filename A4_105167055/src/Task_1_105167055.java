import textprocessing.*;

public class Task_1_105167055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] offset = {};
	   String pat = "abracadabra";
	   String txt = "abracadabraabacadabrabracabracadabrabrabracad";
	   char[] pattern = pat.toCharArray();
	   char[] text    = txt.toCharArray();
	   
	   
	   int offset1b = BruteForceMatch.search1(pattern, text);
	
	   // print results
	   StdOut.println("text:    " + txt);
	   
	   // from brute force search method 1b
	   StdOut.print("pattern: ");
	   for (int i = 0; i < offset1b; i++) {
		   StdOut.print(" ");
	   }
	   StdOut.println(pat + " at pos " + offset1b);
	}
}
