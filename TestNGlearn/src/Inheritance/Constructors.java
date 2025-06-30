package Inheritance;

public class Constructors extends Multiply {
	
	
	int a;
	
	public Constructors(int a) {  //a value comes from class MobSecond
		super(a);
		this.a=a;
	}

	public int add() {
		a=a+1;
		return a;
	}
	
	public int minus() {
		a=a-2;
		return a;
	}
}
