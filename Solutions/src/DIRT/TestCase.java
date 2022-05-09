package DIRT;

//Test case :1
class Generic<T> {
	T t;
	int a, b;

	Generic() {

	}

	Generic(T t, int a) {
		this.t = t;
		this.a = a;
	}

	Generic(T t, int a, int b) {
		this.t = t;
		this.a = a;
		this.b = b;
	}

	public void get() {
		System.out.println(t + " " + a + " " + b);
	}

}

//Test case : 2
class Grade {
	private int a;
	int b, c;

	public Grade(int r) {
		b = r;
	}

	public Grade(int r, int s) {
		b = r;
		c = s;
	}

	public Grade(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void alfa() {
		a = 10;
		b = 20;
		c = 30;
	}
}


//Test case :3
public class TestCase {
	protected int a,b,c;
	
	TestCase(){
		this.a=this.b=this.c=0;
	}
	
	TestCase(int a){
		this.a=a;
		this.b=this.c=0;
	}
	
	TestCase(int a,int b){
		this.a=a;
		this.b=b;
		this.c=0;
	}
	
	TestCase(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
}