package Engineer_2022_1;

public class java_016 {

	class Car implements Runnable{
		  int a;
		  
		  public void run(){
		     System.out.println("Hello");
		  }
		}
		  
		public class Main{
		  public static void main(String[] args){
		    Thread t1 = new Thread(new Car());
		    t1.start();
		  }
		}
	
	
}
