//	The second way to implement the thread in java is by implementing the Runnable interface
// 	The benefit of using the Runnable interface is that if we extend the thread class instead of implementing the Runnable interface then we can not extend any other classes, because in java we can not extend more than one class
public class ThreadExampleRunnable implements Runnable {
	@Override
	public void run() {
		int i = 0;
		while(i <= 100) {
			System.out.println(i + " " + Thread.currentThread().getName());
			i++;
		}
	}
}
