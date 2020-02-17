import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex_1_ConcurrentCollectionConcurrentHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating ConcurrentHashMap object of type <Integer, String>
		ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<Integer, String>();
		//adding key-value pairs to ConcurrentHashMap object
		chm.put(1, "<a class='vglnk' href='http://google.com' rel='nofollow'><span>google</span><span>.</span><span>com</span></a>");
	    chm.put(2, "<a class='vglnk' href='http://youtube.com' rel='nofollow'><span>youtube</span><span>.</span><span>com</span></a>");
	    chm.put(3, "<a class='vglnk' href='http://facebook.com' rel='nofollow'><span>facebook</span><span>.</span><span>com</span></a>");
	    //adding key-value pairs using ConcurrentMap method
	    chm.putIfAbsent(5, "<a class='vglnk' href='http://yahoo.com' rel='nofollow'><span>yahoo</span><span>.</span><span>com</span></a>"); // 1st
	    chm.putIfAbsent(7, "<a class='vglnk' href='http://wikipedia.com' rel='nofollow'><span>wikipedia</span><span>.</span><span>com</span></a>"); // 2nd
	    //not-inserted, as key is already present
	    chm.putIfAbsent(1, "<a class='vglnk' href='http://baidu.com' rel='nofollow'><span>baidu</span><span>.</span><span>com</span></a>"); // 3rd
	    System.out.println("Iterating before remove and replace\n");
	    // iterating using enhanced for-loop
        for(Map.Entry<Integer, String> me : chm.entrySet()) {
            System.out.println("Rank : "  + me.getKey() + "\t" + "Website : "  + me.getValue());
        }
        //removing: both key & value should match
        chm.remove(5, "<a class='vglnk' href='http://yahoo.com' rel='nofollow'><span>yahoo</span><span>.</span><span>com</span></a>");
        System.out.println("\n\nIterating after remove(5, <a class='vglnk' href='http://yahoo.com' rel='nofollow'><span>yahoo</span><span>.</span><span>com</span></a>)\n");
        //iterating using enhanced for-loop
	    for(Map.Entry<Integer, String> me : chm.entrySet()) {
	    	System.out.println("Rank : " + me.getKey() + "\t" + "Website : " + me.getValue());
	    }
	    //removing: both key and value should match
	    chm.replace(2, "<a class='vglnk' href='http://youtube.com' rel='nofollow'><span>youtube</span><span>.</span><span>com</span></a>", "<a class='vglnk' href='http://amazon.com' rel='nofollow'><span>amazon</span><span>.</span><span>com</span></a>");
	    System.out.println("\n\nIterating after " + "replace(2, <a class='vglnk' href='http://youtube.com' rel='nofollow'><span>youtube</span><span>.</span><span>com</span></a>, <a class='vglnk' href='http://amazon.com' rel='nofollow'><span>amazon</span><span>.</span><span>com</span></a>)\n");
	    //iterating using enhanced for-loop
	    for(Map.Entry<Integer, String> me : chm.entrySet()) {
	    	System.out.println("Rank : " + me.getKey() + "\t" + "Website : " + me.getValue());
	    }
	}
}
