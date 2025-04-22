package Intro;

import java.util.Arrays;
public class Mystring {

	public static void main(String[] args) {
		String s1= "Welcome home";
		String s2= "Welcome home";  //this wont store in s2
		
		String s3 = new String("Welcome home");
		String s4 = new String("Welcome home");   //this will store in s4
		
		String clr = "White Green Red Blue";
		String[] clrSeperate= clr.split("Red");  //String[] clrSeperate= clr.split(" "); to seperate the string into array
		
		for (int i=0; i<clrSeperate.length; i++)
		{
			System.out.println(clrSeperate[i]);
		}
		
		System.out.println(clrSeperate[1]);
		System.out.println(clrSeperate[0]);
		//System.out.println(clrSeperate[2]);
		
		System.out.println(clrSeperate[1].trim());
		
		for (int i=0; i<clr.length(); i++)
		{
			System.out.println(clr.charAt(i));
		}

	}
}
