package School;

import java.util.ArrayList;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread");
		Thread t1 = new Thread(Grade.obj()) {
			public void run() {
				System.out.println("Thread Started");
				Grade.getValues();
			}
		};
		System.out.println("2nd");
		Thread t2 = new Thread(Grade.obj()) {
			public void run() {
				ArrayList<String> name = Grade.publishTopper(Grade.result);
				if(name.size()==0) {
					System.out.println("0 100 Scorers");
				}else {
					for(String s:name) {
						System.out.println(s);
					}
				}
				
			}
		};
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}

}
