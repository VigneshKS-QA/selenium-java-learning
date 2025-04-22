package Intro;

public class MyMethods {

	public static void main(String[] args) {
		 
		MyMethods sim = new MyMethods();
		
		String s =sim.simpleMethod();
		
		System.out.println(s);
		
		sim.simpleMethod();
		
		CreateMethods d= new CreateMethods();
		d.diffClassMethod();
		String f = d.diffClassMethod();
		System.out.println(f);
		
		d.ClassMethod();
		String g = d.ClassMethod();
		System.out.println(g);
		
		classmethod1();
		String L = classmethod1();
		System.out.println(L);
		
	}
	
	/*public void simpleMethod()
	{
		System.out.println("Hello World");
	}*/
	public String simpleMethod()
	{
		System.out.println("Hello World");
		
		return "Hi Everyone"; //this method will take only strings
	}
	public static String classmethod1()
	{
		System.out.println("Yo Everyone");
		return "how are you";
		
	}
	
	
}
