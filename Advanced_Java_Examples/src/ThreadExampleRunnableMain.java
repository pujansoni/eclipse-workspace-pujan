
public class ThreadExampleRunnableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		In order to use the ThreadExampleRunnable class the first thing we need to do is create a variable of type thread
		Thread thread1 = new Thread(new ThreadExampleRunnable());
//		When the start() method is executed the code inside the run() method is called
		thread1.start();
		
//		It is not necessary to create a separate class to implement the Runnable interface we can also pass the new instance of Runnable to the thread constructor
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i <= 100) {
					System.out.println(i + " " + Thread.currentThread().getName());
					i++;
				}
			}
		});
		thread2.start();
		
//		We can further shorten our code as Runnable is a functional interface because it has only one abstract method we can also use the lambda expression in this case
		Thread thread3 = new Thread(() -> {
			int i = 0;
			while(i <= 100) {
				System.out.println(i + " " + Thread.currentThread().getName());
				i++;
			}
		});
		thread3.start();
	}

}
