import java.util.LinkedList;
import java.util.Queue;
public class Queue_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=10; i++)
        {
            queue.add(i);
        }
        System.out.println("Element in the queue: "+queue);
        int removed = queue.remove();
        System.out.println(removed + " was removed");
        
        int top  = queue.peek();
        System.out.println("top element is: "+top);
        
        System.out.println(queue);
	}

}
