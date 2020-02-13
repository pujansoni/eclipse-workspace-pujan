
public class ThreadExampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Initially the thread is in the waiting state
		ThreadExample thread1 = new ThreadExample();
//		To start the thread we will use the start() method which will call the run() method in thread
		thread1.setName("My first thread");
		thread1.start();
		
		ThreadExample thread2 = new ThreadExample();
		thread2.setName("My second thread");
		thread2.start();
	}

}
