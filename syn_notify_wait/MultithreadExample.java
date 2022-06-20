package syn_notify_wait;

public class MultithreadExample {

	public static void main(String[] args) {
		SharedArea sharedarea = new SharedArea();

		Thread thread1 = new CalcThread(sharedarea);
		Thread thread2 = new PrintThread(sharedarea);

		thread1.start();
		thread2.start();
	}
}
