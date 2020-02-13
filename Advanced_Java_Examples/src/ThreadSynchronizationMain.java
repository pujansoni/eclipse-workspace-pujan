
public class ThreadSynchronizationMain {
	static final ThreadSynchronizationBankAccount account = new ThreadSynchronizationBankAccount(50);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		account.topUp(100);
//		There can be two person withdrawing the money from the same account which is represent below by creating two threads which withdraws money from the same account
		Thread t1 = new Thread(() -> {
			ThreadSynchronizationATM.withdraw(account, 100);
		});
		
		Thread t2 = new Thread(() -> {
			ThreadSynchronizationATM.withdraw(account, 100);
		});
		
		t1.start();
		t2.start();
	}
}
