package Intro;

public class Exercise {
    public static void main(String[] args) {
    
    int[] numbers={3,5,4,8,7};
    
    System.out.println(numbers[0]);
    System.out.println(numbers[4]);
    
    for(int i=4; i>=0; --i)
{
    System.out.println(numbers[i]);
}
    System.out.println(numbers.length);

}
}

//OR // 1. Create an Array
/*double[] numbers = {2.5, 9.0, 17.2, 5.0, 3.14};

// 2. Access and Print
System.out.println("First element: " + numbers[0]);
System.out.println("Last element: " + numbers[numbers.length - 1]); 

// 3. Reverse Order
System.out.println("Elements in reverse order: ");
for (int i = numbers.length - 1; i >= 0; i--) {
    System.out.println(numbers[i]);
}

// 4. Bonus: Element Count
System.out.println("Total elements in the array: " + numbers.length);
}*/
