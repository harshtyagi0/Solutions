package School;

import java.util.Scanner;

public class myThread extends Thread {
	private Grade g;

	public myThread(Grade g) {
		// TODO Auto-generated constructor stub
		this.g=g;
	}
	public void run() {
		synchronized(g) {
			Scanner scan  = new Scanner(System.in);
			System.out.print("Number of Students in class :- ");
			int StudentCount = scan.nextInt();
			for(int i=0; i<StudentCount; i++) {
				System.out.print("Enter Student Name :- ");
				String name = scan.nextLine();
				System.out.print("Enter Marks :- ");
				int marks = scan.nextInt();
				g.result.put(name, marks);
			}
		}
	}

}
