package syn_notifyAll_wait;

public class MultithreadExample {

	public static void main(String[] args) {
		SharedArea sharedarea = new SharedArea();

		Thread thread1 = new CalcThread(sharedarea);
		Thread thread2 = new PrintThread(sharedarea);
		Thread thread3 = new LuxuryPrintThread(sharedarea);
		Thread thread4 = new SimplePrintThread(sharedarea);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
