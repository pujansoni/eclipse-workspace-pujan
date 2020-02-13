
public class ThreadExample extends Thread {
//	Any code that you want to write in the thread should be written in the run() method
	@Override
	public void run() {
		int i = 1;
		while(i <= 100) {
			System.out.println(i + " " + this.getName());
			i++;
		}
	}
}
