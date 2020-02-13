import java.util.*;
public class QueueStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Customer> queue = new LinkedList();
		queue.add(new Customer("Sally"));
		queue.add(new Customer("Ben"));
		queue.add(new Customer("Emma"));
		queue.add(new Customer("Fred"));
		System.out.println(queue);
		serveCustomer(queue);
		System.out.println(queue);
	}
	
	static void serveCustomer(LinkedList<Customer> queue) {
//		The poll method returns the first customer from the queue and also removes that customer
		Customer c = queue.poll();
		c.serve();
	}

}
