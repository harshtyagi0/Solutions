package School;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.*;

public class Grade implements Assesment, Runnable{
	
	
	static HashMap<String,Integer> result = new HashMap();
	private static Grade single = null;
	private Grade() {
		
	}
	static Grade obj() {
		if(single==null)
			single = new Grade();
		return single;
	}
	public static ArrayList<String> publishTopper(HashMap<String,Integer> r) {
		ArrayList<String> al = new ArrayList();
		for(Map.Entry<String, Integer> e : result.entrySet()) {
			if(e.getValue()==100) {
				al.add(e.getKey());
			}
		}
		return al;
	}
	
	public static void getValues() {
		Scanner scan  = new Scanner(System.in);
		System.out.print("Number of Students in class :- ");
		int StudentCount = scan.nextInt();
		for(int i=0; i<StudentCount; i++) {
			System.out.print("Enter Marks :- ");
			int marks = scan.nextInt();
			System.out.print("Enter Student Name :- ");
			String name = scan.nextLine();
//			scan.nextInt();
			
			Grade gg = Grade.obj();
			gg.centPercenter(name, marks);
		}
	}
	public void centPercenter(String name, int marks) {
		result.put(name, marks);
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}



	

}
