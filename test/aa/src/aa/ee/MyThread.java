package aa.ee;

public class MyThread extends Thread {
	
	@Override
	public void run() {
		
		for (int i = 0; i < 200; i++) {
			System.out.println(i + ", ");
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			}
		}

	}
