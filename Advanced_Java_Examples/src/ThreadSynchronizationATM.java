
public class ThreadSynchronizationATM {
//	By writing the synchronized keyword in the method signature we are making sure that only one thread enters inside the method at any given time
	static synchronized void withdraw(ThreadSynchronizationBankAccount account, int amount) {
		int balance = account.getBalance();
		if((balance - amount) < - account.getOverdraft()) {
			System.out.println("Transaction denied!");
		} else {
			account.debit(amount);
			System.out.println("$" + amount + " successfully withdrawn");
		}
		System.out.println("Current balance: " + account.getBalance());
	}
}
