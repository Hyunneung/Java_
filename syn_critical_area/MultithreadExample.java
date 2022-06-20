package syn_critical_area;

public class MultithreadExample {

	public static void main(String[] args) {
		Account a1 = new Account("111-111-1111", "ÀÌ¸ù·Õ",2000000);
		Account a2 = new Account("222-222-2222", "¼ºÃáÇâ",1000000);
		
		SharedArea area = new SharedArea(a1,a2);
		
		Thread thread1 = new TransferThread(area);
		Thread thread2 = new PrintThread(area);
		
		thread1.start();
		thread2.start();
		
	}

}
