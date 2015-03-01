public class SyncMethodOrBlock {

	public static void main(String[] args) {

		Program p = new Program();
		Runnable r = () -> {

			String name = Thread.currentThread().getName();
			
		//	System.out.println(name);
			
			p.doSomething1(name);
			p.doSomething2(name);

		};

		int threadCount = 5;

		Thread[] threads = new Thread[threadCount];

		for (int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(r, "" + i);
			threads[i].start();

		}

		try {
			for (int i = 0; i < threadCount; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Program {
	private static Object locker1 = new Object();
	private static Object locker2 = new Object();

	public   void doSomething1(String name) {

		synchronized (locker1) {
			for (int i = 0; i < 5; i++) {
				System.out.println("First " + name);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public    void doSomething2(String name) {

		synchronized (locker2) {
			for (int i = 0; i < 5; i++) {
				System.out.println("second"+ name);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
