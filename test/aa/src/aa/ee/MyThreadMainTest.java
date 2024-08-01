package aa.ee;

public class MyThreadMainTest {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		
		MyThread thread1 = new MyThread();
		thread1.start();
		
		System.out.println("-----------");
		
//		MyThread thread2 = new MyThread();
//		thread2.start();
	}

}
