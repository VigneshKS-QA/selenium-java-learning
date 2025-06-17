package Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java {

	
	public static void main(String[] args) {
		
		int[] num = new int [5];
		num[0]=6;
		num[1]=8;
		num[2]=7;
		num[3]=2;
		num[4]=9;
		
	 System.out.println(num[0]);
	 
	 
	 String[] name = {"Raj", "Kim", "Jay", "Tim"};
	 
	 System.out.println(name[0]);
	 
	 for (int i=1; i<name.length; i++)
	 {
     
	 System.out.println(name[i]);
		 
	 }
	for (String N: name)
	{
		System.out.println(N);
	}
	
	int[] k= {1,2,4,8,20,16,12,5,7,24};
	
	for (int L : k)
	{
		if(L % 4 ==0)
		{
			System.out.println(L);
			break;
	    }
		else {
			System.out.println(L + " " + "is not divided by 4");
		}
		
	}
	
	//Array list
	ArrayList al = new ArrayList(); //ArrayList<String> al = new ArrayList<String>(); to store only string
	al.add(4);
	al.add("Im");
	al.add("not");
	al.add("Tom");
	
	System.out.println(al);
	System.out.println(al.get(2));
	al.remove(2);
	System.out.println(al);
	
	//Normal array to list
	String[] city= {"Mandya", "Bang", "Mysore"};
	List<String> cities = Arrays.asList(city);
	System.out.println(cities.contains("Bang"));
	System.out.println(cities);
	
	for(int i=0; i<city.length; i++) {
		System.out.println(city[i]);
	}
	
	
	
}
}
