package Intro;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;


import org.testng.Assert;


public class Streams {

	public static void main(String[] args) {
		ArrayList<String> names =new ArrayList<String>();
		names.add("Armin");	
		names.add("Jay");
		names.add("Lim");
		names.add("Alen");
		names.add("Akaza");
		
		//count name starts with "A" 
		
		  /*int count=0; 
		  for(int i=0; i<names.size(); i++) { 
			  String nameA = names.get(i);
		  if(nameA.startsWith("A")) { 
			  count++; 
		  } 
		  } System.out.println(count);*/
		 
		
		/*Long c =names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);*/
		
	
		//Also we can assign list to stream without Arraylist 
													  //Intermediate operator(Iop)  //Terminal operator(Top) if Iop false then Top wont execute
		Long d =Stream.of("Armin","Jay","Lim","Alen","Akaza").filter(s->
		{	//use {} when we have more condition
			s.startsWith("A");		
		return true;
		}).count();
		System.out.println(d);
		
		
		//print names with length
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//same but prints one result (first result)
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		
		//convert into UPPERCASE which ends with "n"
		names.stream().filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//sort names 
		List<String> p = Arrays.asList("Armin","Jay","Lim","Alen","Akaza");
		p.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
		//Merge 2 lists
		List<String> name1 = Arrays.asList("Xe","Ze","Ab");
		Stream.concat(names.stream(), name1.stream()).sorted().forEach(s->System.out.println(s));
		
		//find any name present in list
		boolean match =Stream.concat(names.stream(), name1.stream()).anyMatch(s->s.equalsIgnoreCase("Xe"));
		System.out.println(match);
		Assert.assertTrue(match);
		
		//collect modified/sorted result
		List<String> ls =Stream.concat(names.stream(), name1.stream()).filter(s->s.startsWith("A")).collect(Collectors.toList()); //converted into list
		System.out.println(ls);
		System.out.println(ls.getLast());  //we can use list methods
		
		//sort and print unique number
		Stream.of(1,3,2,1,5,4,6,2).sorted().distinct().forEach(s->System.out.println(s));
		//print 3rd number
		//so convert it into list and use method
		List<Integer> li =Stream.of(1,3,2,1,5,4,6,2).sorted().distinct().collect(Collectors.toList());
		System.out.println(li.get(2));
		
		System.out.println("The line");
		Integer[] num = {1,3,2,1,5,4,6,2,3};
		List<Integer> m = Arrays.asList(num);
		
		
	}

}
